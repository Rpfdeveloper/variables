import javax.swing.*;
import java.util.Scanner;

public class SistemasNumericos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un numero entero:");
        String numeroStr = scanner.nextLine();
        int numeroDecimal = 0;
        try{
            Integer.parseInt(numeroStr);
        }catch(NumberFormatException e){
            System.out.println("Error debe ingresar un numero entero");
            main(args);
            System.exit(0);
        }
        System.out.println("numeroDecimal = " + numeroDecimal);

        String resutadoBinario = ("numero binario de " + numeroDecimal + " = " + Integer.toBinaryString(numeroDecimal));
        System.out.println(resutadoBinario);

        int numeroBinario = 0b111110100;
        System.out.println("numeroBinario = " + numeroBinario);

        String resultadoOctal = ("numero octal de " + numeroBinario + " = " + Integer.toOctalString(numeroBinario));
        System.out.println(resultadoOctal);
        int numeroOctal = 036;
        System.out.println("numeroOctal = " + numeroOctal);

        String resultadoHexadecimal = ("numero hexadecimal de " + numeroOctal + " = " + Integer.toHexString(numeroOctal));
        System.out.println(resultadoHexadecimal);
        int numeroHex = 0x1f4;
        System.out.println("numeroHex = " + numeroHex);

        String mensaje = resutadoBinario;
        mensaje += "\n" + resultadoOctal;
        mensaje += "\n" + resultadoHexadecimal;

        System.out.println(mensaje);



    }
}
