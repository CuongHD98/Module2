package ID9201;

public class TriangleClassifier {

    public static final String EquilateralTriangle = "Equilateral Triangle";
    public static final String IsoscelesTriangle = "Isosceles Triangle";
    public static final String NormalTriangle = "Normal Triangle";
    public static final String NOTTriangle = "NOT Triangle";

    public static String findTypeTriangle(float edge1, float edge2, float edge3) {
        boolean isPositiveEdge1 = edge1 > 0;
        boolean isPositiveEdge2 = edge2 > 0;
        boolean isPositiveEdge3 = edge3 > 0;

        boolean isSumEdge12BiggerEdge3 = edge1 + edge2 > edge3;
        boolean isPumEdge13BiggerEdge2 = edge1 + edge3 > edge2;
        boolean isSumEdge23BiggerEdge1 = edge2 + edge3 > edge1;

        boolean isEqualEdge12 = edge1 == edge2;
        boolean isEqualEdge13 = edge1 == edge3;
        boolean isEqualEdge23 = edge2 == edge3;

        boolean equalEdge123 = edge1 == edge2 && edge1 == edge3;

        if (isPositiveEdge1 && isPositiveEdge2 && isPositiveEdge3) {
            if (isSumEdge12BiggerEdge3 && isSumEdge23BiggerEdge1 && isPumEdge13BiggerEdge2) {
                if (equalEdge123) return EquilateralTriangle;
                else if (isEqualEdge12 || isEqualEdge13 || isEqualEdge23) return IsoscelesTriangle;
                else return NormalTriangle;
            } else return NOTTriangle;
        } else return NOTTriangle;
    }
}
