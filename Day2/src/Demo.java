public class Demo {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print(" ");
            }
            for (int l = 0; l < i*2+1; l++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        double[] array = new double[10];
        Object[] array2 = new Object[10];
        array2[1] = 12;
        array2[2] = "str";

        Object[] abc = new Object[3];
        abc[0] = array;
        abc[1] = array2;

        double[][] distances = {
                {0, 983, 787, 714, 1375, 967, 1087},
                {983, 0, 214, 1102, 1763, 1723, 1842},
                {787, 214, 0, 888, 1549, 1548, 1627},
                {714, 1102, 888, 0, 661, 781, 810},
                {1375, 1763, 1549, 661, 0, 1426, 1187},
                {967, 1723, 1548, 781, 1426, 0, 239},
                {1087, 1842, 1627, 810, 1187, 239, 0},
        };
        double[] myList = {1.9, 2.9, 3.4, 3.5};
        int [][] matrix;
        matrix = new int[5][5];
    }
}
