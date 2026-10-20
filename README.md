# Primeros pasos en Java · Variables y tipos

Colección de **10 ejemplos de consola** de mis primeras prácticas con Java. Trabaja salida por pantalla, tipos primitivos, conversiones, comparación de strings y sistemas de numeración.

Este repositorio recoge ejercicios de aprendizaje; no es una aplicación completa.

## Recorrido recomendado

| Tema | Archivo |
| --- | --- |
| Primer programa | [HelloWord.java](HelloWorld/src/HelloWord.java) |
| Salida por consola | [MyName.java](HelloWorld/src/MyName.java) |
| Strings e inferencia con `var` | [HolaMundo.java](variables/src/HolaMundo.java) |
| Enteros y límites de representación | [PrimitivosEnteros.java](variables/src/PrimitivosEnteros.java) |
| Coma flotante | [PrimitivosFloat.java](variables/src/PrimitivosFloat.java) |
| Caracteres y Unicode | [PrimitivosCaracteres.java](variables/src/PrimitivosCaracteres.java) |
| Booleanos y comparaciones | [PrimitivosBoolean.java](variables/src/PrimitivosBoolean.java) |
| Conversión entre tipos y texto | [ConversionDeTipos.java](variables/src/ConversionDeTipos.java) |
| Identidad y contenido de strings | [EjemploString.java](variables/src/EjemploString.java) |
| Representación binaria, octal y hexadecimal | [SistemasNumericos.java](variables/src/SistemasNumericos.java) |

## Ejecutar desde el código fuente

Necesitas Git y un **JDK 17** con `java` y `javac` en el PATH. No requiere Maven, Gradle ni bibliotecas externas.

```bash
git clone https://github.com/Rpfdeveloper/variables.git
cd variables
javac -encoding UTF-8 -d build/classes HelloWorld/src/HelloWord.java HelloWorld/src/MyName.java
java -cp build/classes HelloWord
```

El primer ejemplo imprime `Hola Mundo`.

Para compilar los ocho ejemplos de tipos:

**Windows PowerShell**

```powershell
$fuentesJava = (Get-ChildItem -Path variables/src -Filter *.java).FullName
javac -encoding UTF-8 -d build/classes $fuentesJava
java -cp build/classes EjemploString
```

**Linux / macOS**

```bash
javac -encoding UTF-8 -d build/classes variables/src/*.java
java -cp build/classes EjemploString
```

El ejemplo de strings contiene un literal y un objeto creado con `new String(...)`: `==` compara referencias y `equals` compara contenido. La salida que se desprende del código es:

```text
esIgual = false
esIgual = true
```

Para el ejemplo interactivo:

```bash
java -cp build/classes SistemasNumericos
```

Introduce un entero como `42`: el programa muestra sus representaciones binaria, octal y hexadecimal.

## Estructura y límites

- `HelloWorld/src`: dos programas iniciales.
- `variables/src`: ocho ejemplos de tipos y conversiones.
- `untitled`: configuración histórica de IntelliJ, sin código Java.
- Las carpetas `out` contienen binarios históricos. Los comandos anteriores recompilan los fuentes en `build/classes`.

**Revisión del 20 de octubre de 2026:** se han inspeccionado los diez archivos fuente. No se ha podido ejecutar la compilación en el entorno de esta revisión porque no dispone de un compilador Java utilizable; los resultados descritos son los esperados al leer el código, no una certificación de ejecución.

Se conservan los ejercicios originales. Hay aspectos pendientes de mejora: algunas etiquetas de tipos son imprecisas y `SistemasNumericos` reintenta mediante recursión cuando recibe una entrada inválida, en lugar de un bucle. No hay una suite automatizada de pruebas.

## Autoría y contexto

Ejercicios de formación de [Roberto Pajuelo](https://github.com/Rpfdeveloper). La documentación se ha preparado con asistencia de IA, a partir del código existente.

Para ejemplos posteriores: [Fundamentos de Java](https://github.com/Rpfdeveloper/Master-Java-Udemy) y [arrays, matrices y objetos](https://github.com/Rpfdeveloper/Master-Java-180h-Udemy).
