import java.util.Scanner;

public class ID9132 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row matrix : ");
        int row = scanner.nextInt();
        System.out.print("Enter col matrix : ");
        int col = scanner.nextInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("Element row " + i + " : ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Col " + j + " : ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Matrix : ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        int numCol;
        System.out.print("Enter col find Sum : ");
        numCol = scanner.nextInt();
        int sum = sumColMatrix(matrix, numCol);
        System.out.println("Sum col " + numCol + " = " + sum);
    }

    public static int sumColMatrix(int[][] matrix, int col) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][col];
        }
        return sum;
    }
}
