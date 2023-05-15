package ID9201;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    @Test
    void testFindTypeTriangle1() {
        float edge1 = 2;
        float edge2 = 2;
        float edge3 = 2;
        String expected = "Equilateral Triangle";
        String result = TriangleClassifier.findTypeTriangle(edge1, edge2, edge3);
        assertEquals(expected, result);
    }

    @Test
    void testFindTypeTriangle2() {
        float edge1 = 2;
        float edge2 = 2;
        float edge3 = 3;
        String expected = "Isosceles Triangle";
        String result = TriangleClassifier.findTypeTriangle(edge1, edge2, edge3);
        assertEquals(expected, result);
    }

    @Test
    void testFindTypeTriangle3() {
        float edge1 = 3;
        float edge2 = 4;
        float edge3 = 5;
        String expected = "Normal Triangle";
        String result = TriangleClassifier.findTypeTriangle(edge1, edge2, edge3);
        assertEquals(expected, result);
    }

    @Test
    void testFindTypeTriangle4() {
        float edge1 = 8;
        float edge2 = 2;
        float edge3 = 3;
        String expected = "NOT Triangle";
        String result = TriangleClassifier.findTypeTriangle(edge1, edge2, edge3);
        assertEquals(expected, result);
    }

    @Test
    void testFindTypeTriangle5() {
        float edge1 = -1;
        float edge2 = 2;
        float edge3 = 1;
        String expected = "NOT Triangle";
        String result = TriangleClassifier.findTypeTriangle(edge1, edge2, edge3);
        assertEquals(expected, result);
    }

    @Test
    void testFindTypeTriangle6() {
        float edge1 = 0;
        float edge2 = 1;
        float edge3 = 1;
        String expected = "NOT Triangle";
        String result = TriangleClassifier.findTypeTriangle(edge1, edge2, edge3);
        assertEquals(expected, result);
    }
}