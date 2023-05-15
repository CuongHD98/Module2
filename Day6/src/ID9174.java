import java.util.Arrays;

public class ID9174 {
    public static void main(String[] args) {
        Point point = new Point(2, 3);
        System.out.println(point.toString());
        System.out.println(Arrays.toString(point.getXY()));

        MoveablePoint moveablePoint = new MoveablePoint(3, 3, 1.5f, 1.5f);
        System.out.println(moveablePoint.toString());
        System.out.println(Arrays.toString(moveablePoint.move()));


    }
}

class Point {
    private float x, y;

    public Point() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        setX(x);
        setY(y);
    }

    public float[] getXY() {
        float[] Array = new float[2];
        Array[0] = getX();
        Array[1] = getY();
        return Array;
    }

    @Override
    public String toString() {
        return "Point with x = " + getX() + " y = " + getY();
    }
}

class MoveablePoint extends Point {
    private float xSpeed, ySpeed;

    public MoveablePoint() {
        this.xSpeed = 0.0f;
        this.ySpeed = 0.0f;
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        setxSpeed(xSpeed);
        setySpeed(ySpeed);
    }

    public float[] getSpeed() {
        float[] speed = new float[2];
        speed[0] = getxSpeed();
        speed[1] = getySpeed();
        return speed;
    }

    @Override
    public String toString() {
        return super.toString() + " speed = (" + getxSpeed() + "," + getySpeed() + ")";
    }

    public float[] move() {
        super.setX(super.getX() + getxSpeed());
        super.setY(super.getY() + getySpeed());
        float[] newArray = super.getXY();
        return newArray;
    }
}
