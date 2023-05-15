public class ID9148 {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        fan1.setColor("Yellow");
        fan1.setStatus(true);
        System.out.println(fan1.toStatus());

        Fan fan2 = new Fan();
        fan2.setSpeed(fan2.MEDIUM);
        System.out.println(fan2.toStatus());
    }
}

class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed = SLOW;
    private boolean status = false;
    private double radius = 5;
    private String color = "blue";

    Fan() {

    }

    int getSpeed() {
        return this.speed;
    }

    int setSpeed(int speed) {
        this.speed = speed;
        return this.speed;
    }

    double getRadius() {
        return this.radius;
    }

    double setRadius(double radius) {
        this.radius = radius;
        return this.radius;
    }

    boolean getStatus() {
        return this.status;
    }

    boolean setStatus(boolean status) {
        this.status = status;
        return this.status;
    }

    String getColor() {
        return this.color;
    }

    String setColor(String color) {
        this.color = color;
        return this.color;
    }

    String toStatus() {
        String result;
        if (this.status)
            result = "fan is on " + "speed = " + this.speed + " color = " + this.color + " radius = " + this.radius;
        else result = "fan is off " + "speed = " + this.speed + " color = " + this.color + " radius = " + this.radius;
        return result;
    }
}
