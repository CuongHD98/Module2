import java.util.Scanner;

public class ID9133 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length square matrix : ");
        int row = scanner.nextInt();
        int[][] matrix = new int[row][row];
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("Enter element row " + i + " : ");
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
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        System.out.print("Sum main diagonal = " + sum);
    }
}
