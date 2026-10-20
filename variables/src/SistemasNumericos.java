import java.util.Scanner;

public class SistemasNumericos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroDecimal;
        while (true) {
            System.out.println("Ingrese un numero entero:");
            if (!scanner.hasNextLine()) {
                System.err.println("No se ha recibido un numero entero.");
                return;
            }
            try {
                numeroDecimal = Integer.parseInt(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error debe ingresar un numero entero");
            }
        }
        System.out.println("numeroDecimal = " + numeroDecimal);

        String resutadoBinario = ("numero binario de " + numeroDecimal + " = " + Integer.toBinaryString(numeroDecimal));

        String resultadoOctal = ("numero octal de " + numeroDecimal + " = " + Integer.toOctalString(numeroDecimal));

        String resultadoHexadecimal = ("numero hexadecimal de " + numeroDecimal + " = " + Integer.toHexString(numeroDecimal));

        String mensaje = resutadoBinario;
        mensaje += "\n" + resultadoOctal;
        mensaje += "\n" + resultadoHexadecimal;

        System.out.println(mensaje);



    }
}
