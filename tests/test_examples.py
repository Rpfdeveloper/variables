"""Compile the actual Java sources and exercise their console interfaces."""
import os
from pathlib import Path
import shutil
import subprocess
import tempfile
import unittest


ROOT = Path(__file__).resolve().parents[1]


class JavaExamplesTest(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        java_home = os.environ.get("JAVA_HOME")
        suffix = ".exe" if os.name == "nt" else ""
        cls.java = str(Path(java_home) / "bin" / ("java" + suffix)) if java_home else shutil.which("java")
        javac = str(Path(java_home) / "bin" / ("javac" + suffix)) if java_home else shutil.which("javac")
        if not cls.java or not javac or not Path(javac).is_file():
            raise RuntimeError("Install a JDK and set JAVA_HOME or add java and javac to PATH.")
        cls.build = tempfile.TemporaryDirectory()
        cls.addClassCleanup(cls.build.cleanup)
        sources = sorted((ROOT / "HelloWorld/src").glob("*.java"))
        sources += sorted((ROOT / "variables/src").glob("*.java"))
        subprocess.run([javac, "-encoding", "UTF-8", "-d", cls.build.name,
                        *map(str, sources)], check=True, capture_output=True, text=True, timeout=60)

    def run_example(self, name, input_text=""):
        result = subprocess.run([self.java, "-Dfile.encoding=UTF-8", "-cp", self.build.name, name],
                                input=input_text, capture_output=True, text=True,
                                encoding="utf-8", timeout=15)
        self.assertEqual(result.returncode, 0, result.stderr)
        return result

    def test_strings_compare_reference_and_content(self):
        result = self.run_example("EjemploString")
        self.assertEqual(result.stdout.splitlines(), ["esIgual = false", "esIgual = true"])

    def test_decimal_conversion_and_integer_boundaries(self):
        for value in (0, 42, -1, 2147483647, -2147483648):
            with self.subTest(value=value):
                result = self.run_example("SistemasNumericos", str(value) + "\n")
                unsigned = value & 0xffffffff
                self.assertIn(f"numeroDecimal = {value}\n", result.stdout)
                for label, spec in (("binario", "b"), ("octal", "o"), ("hexadecimal", "x")):
                    self.assertIn(f"numero {label} de {value} = {format(unsigned, spec)}\n", result.stdout)
                self.assertEqual(result.stderr, "")

    def test_invalid_lines_and_overflow_recover(self):
        result = self.run_example("SistemasNumericos", "hola\n2147483648\n\n 42 \n")
        self.assertEqual(result.stdout.count("Error debe ingresar un numero entero"), 3)
        self.assertIn("numeroDecimal = 42\n", result.stdout)
        self.assertEqual(result.stderr, "")

    def test_many_invalid_lines_do_not_exhaust_stack(self):
        result = self.run_example("SistemasNumericos", "x\n" * 2000 + "7\n")
        self.assertEqual(result.stdout.count("Error debe ingresar un numero entero"), 2000)
        self.assertIn("numeroDecimal = 7\n", result.stdout)
        self.assertEqual(result.stderr, "")

    def test_end_of_input_is_handled(self):
        for input_text in ("", "incorrecto\n"):
            with self.subTest(input_text=input_text):
                result = self.run_example("SistemasNumericos", input_text)
                self.assertIn("No se ha recibido un numero entero.", result.stderr)
                self.assertNotIn("Exception", result.stderr)


if __name__ == "__main__":
    unittest.main()
