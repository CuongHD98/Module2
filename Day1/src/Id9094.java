import java.util.Scanner;

public class ID9094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter weight: ");
        double weight = sc.nextFloat();
        System.out.println("Enter height: ");
        double height = sc.nextFloat();
        double bmi = weight / Math.pow(height, 2);
        if (bmi < 18.5) System.out.println("Underweight");
        else if (bmi < 25.0) System.out.println("Normal");
        else if (bmi < 30.0) System.out.println("Overweight");
        else System.out.println("Obese");
    }
}
