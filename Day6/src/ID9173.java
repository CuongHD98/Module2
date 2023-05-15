import java.util.Arrays;

public class ID9173 {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(2, 2);
        System.out.println(point2D);
        System.out.println(Arrays.toString(point2D.getXY()));
        Point3D point3D = new Point3D(2, 3, 4);
        System.out.println(point3D);
        System.out.println(Arrays.toString(point3D.getXYZ()));

    }
}

class Point2D {
    private float x, y;

    public Point2D() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public Point2D(float x, float y) {
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
        return "Point2D with x = " + getX() + " y = " + getY();
    }
}

class Point3D extends Point2D {
    private float z;

    public Point3D() {
        this.z = 0.0f;
    }

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        setZ(z);
    }

    public float[] getXYZ() {
        float[] Array = new float[3];
        Array[0] = super.getX();
        Array[1] = super.getY();
        Array[2] = getZ();
        return Array;
    }

    @Override
    public String toString() {
        return "Point3D with z = " + getZ() + ", which is a subclass of " + super.toString();
    }
}
