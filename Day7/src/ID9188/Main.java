package ID9188;

public class Main {
    public static void main(String[] args) {
        Square square1 = new Square(5,null,true);
        Square square2 = new Square(5,"Red",true);
        System.out.println(square1);
        System.out.println(square1.getArea());
        square1.howToColor();
        System.out.println(square2);
        System.out.println(square2.getArea());
        square2.howToColor();
    }
}
