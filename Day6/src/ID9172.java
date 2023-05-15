public class ID9172 {
    public static void main(String[] args) {
        Circle2 circle2 = new Circle2(2, "red");
        System.out.println(circle2);
        System.out.println(circle2.getArea());
        Cylinder cylinder = new Cylinder(2, "blue", 2);
        System.out.println(cylinder);
        System.out.println(cylinder.getVolume());
    }
}

class Circle2 {
    private double radius;
    private String color;

    public Circle2() {
        this.radius = 1;
        this.color = "Black";
    }

    public Circle2(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }

    public double getPerimeter() {
        return 2 * this.radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A circle with radius = " + getRadius() + ", color : " + getColor();
    }
}

class Cylinder extends Circle2 {
    private double height;

    public Cylinder() {
        this.height = 1.0;
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return super.getArea() * this.height;
    }

    @Override
    public String toString() {
        return "A Cylinder with height = " + getHeight() + ", which is a subclass of " + super.toString();
    }
}