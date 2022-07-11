public class PrimitivosEnteros {
    public static void main(String[] args) {
        byte numerobyte = 127;
        System.out.println("numeroByte = "+ numerobyte);
        System.out.print("tipo byte corresponde en byte a " + Byte.BYTES);
        System.out.println(" tipo byte corresponde en bites a " + Byte.SIZE);
        System.out.println("valor máximo de un short: " + Byte.MAX_VALUE);
        System.out.println("valor mínimo de un short: " + Byte.MIN_VALUE);
        short numeroShort = 32767;
        System.out.println("numeroShort = "+ numeroShort);
        System.out.println("tipo short corresponde en byte a " + Short.BYTES);
        System.out.println("tipo short corresponde en bites a " + Short.SIZE);
        System.out.println("valor máximo de un short: " + Short.MAX_VALUE);
        System.out.println("valor mínimo de un short: " + Short.MIN_VALUE);

        int numeroInt = 2147483647;
        System.out.println("numeroInt = "+ numeroInt);
        System.out.println("tipo int corresponde en byte a " + Integer.BYTES);
        System.out.println("tipo int corresponde en bites a " + Integer.SIZE);
        System.out.println("valor máximo de un sh: " + Integer.MAX_VALUE);
        System.out.println("valor mínimo de un short: " + Integer.MIN_VALUE);

        long numeroLong = 2147483648999L;
        System.out.println("numeroLong = "+ numeroLong);
        System.out.println("tipo long corresponde en byte a " + Long.BYTES);
        System.out.println("tipo long corresponde en bites a " + Long.SIZE);
        System.out.println("valor máximo de un long: " + Long.MAX_VALUE);
        System.out.println("valor mínimo de un long: " + Long.MIN_VALUE);

        var numerovar = 9223372036854775808F;

    }
}
