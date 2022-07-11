import javax.swing.*;

public class SistemasNumericos {
    public static void main(String[] args) {

        String numeroStr = JOptionPane.showInputDialog(null, "Ingrese un numero decimal");
        int numeroDecimal = Integer.parseInt(numeroStr);
        System.out.println("numeroDecimal = " + numeroDecimal);

        String resutadoBinario = ("numero binario de " + numeroDecimal + " = " + Integer.toBinaryString(numeroDecimal));
        System.out.println(resutadoBinario);
        int numeroBinario = 0b111110100;
        System.out.println("numeroBinario = " + numeroBinario);

        String resultadoOctal = ("numero octal de " + numeroBinario + " = " + Integer.toOctalString(numeroBinario));
        System.out.println(resultadoOctal);
        int numeroOctal = 0764;
        System.out.println("numeroOctal = " + numeroOctal);

        String resultadoHexadecimal = ("numero hexadecimal de " + numeroOctal + " = " + Integer.toHexString(numeroOctal));
        System.out.println(resultadoHexadecimal);
        int numeroHex = 0x1f4;
        System.out.println("numeroHex = " + numeroHex);


    }
}
