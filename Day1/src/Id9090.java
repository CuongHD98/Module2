import java.util.Scanner;
public class ID9090 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Length = ");
        float length = sc.nextFloat();
        System.out.println("Width = ");
        float width = sc.nextFloat();
        float area = length * width;
        System.out.println("Area = " + area);
    }
}
