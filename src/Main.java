import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
//        testTriangles();
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        List<Triangle> triangles = new ArrayList<>(TriangleService.createListTriangles());
        System.out.println("Count of equilateral: " + TriangleService.getCountType(triangles, Triangle.Type.EQUILATERAL)
                                                    + " max square: " + decimalFormat.format(TriangleService.getMaxSquare(triangles, Triangle.Type.EQUILATERAL))
                                                    + " max perimeter: " + decimalFormat.format(TriangleService.getMaxPerimeter(triangles, Triangle.Type.EQUILATERAL)));
        System.out.println("Count of isosceles: " + TriangleService.getCountType(triangles, Triangle.Type.ISOSCELES)
                                                  + " max square: " + decimalFormat.format(TriangleService.getMaxSquare(triangles, Triangle.Type.ISOSCELES))
                                                  + " max perimeter: " + decimalFormat.format(TriangleService.getMaxPerimeter(triangles, Triangle.Type.ISOSCELES)));
        System.out.println("Count of rectangular: " + TriangleService.getCountType(triangles, Triangle.Type.RECTANGULAR)
                                                    + " max square: " + decimalFormat.format(TriangleService.getMaxSquare(triangles, Triangle.Type.RECTANGULAR))
                                                    + " max perimeter: " + decimalFormat.format(TriangleService.getMaxPerimeter(triangles, Triangle.Type.RECTANGULAR)));
        System.out.println("Count of arbitrary: " + TriangleService.getCountType(triangles, Triangle.Type.ARBITRARY)
                + " max square: " + decimalFormat.format(TriangleService.getMaxSquare(triangles, Triangle.Type.ARBITRARY))
                + " max perimeter: " + decimalFormat.format(TriangleService.getMaxPerimeter(triangles, Triangle.Type.ARBITRARY)));
    }

    static void testTriangles() {
        Triangle equilateralTriangle = new Triangle(new Point(-3d,0d), new Point( 0d,3d), new Point(0d,-3d));

        System.out.println("Square: " + equilateralTriangle.getSquare());
        System.out.println("Perimeter: " + equilateralTriangle.getPerimeter());
        equilateralTriangle.setSquareByCoordinate();
        System.out.println("side AB: " + equilateralTriangle.getSideAB().shortValue() +
                " side BC: " + equilateralTriangle.getSideBC().shortValue() +
                " side AC: " + equilateralTriangle.getSideAC().shortValue());

        System.out.println("Angle a: " + equilateralTriangle.getAngleABC() + "\n" +
                "Angle b: " + equilateralTriangle.getAngleBAC().floatValue() + "\n" +
                "Angle c: " + equilateralTriangle.getAngleCAB().floatValue());
        System.out.println(equilateralTriangle.getAngleABC().floatValue());

        System.out.println(equilateralTriangle.getType());
        System.out.println("base is: " + equilateralTriangle.getBase());

        Triangle isoscelesTriangle = new Triangle(new Point(0d,3d), new Point( -6d,1d), new Point(-2d,-3d));

        System.out.println(isoscelesTriangle.getSquare() + " sq");
        equilateralTriangle.setSquareByCoordinate();
        System.out.println("AB: " + isoscelesTriangle.getSideAB().shortValue() +
                " BC: " + isoscelesTriangle.getSideBC().shortValue() +
                " AC: " + isoscelesTriangle.getSideAC().shortValue());

        System.out.println(isoscelesTriangle.getType());
        System.out.println("base is: " + isoscelesTriangle.getBase());

        Triangle rectangularTriangle = new Triangle(new Point(-5d, 0d), new Point(-5d, 6d), new Point(-0d, 0d));
        System.out.println("Angle a: " + rectangularTriangle.getAngleABC() + "\n" +
                "Angle b: " + rectangularTriangle.getAngleBAC().floatValue() + "\n" +
                "Angle c: " + rectangularTriangle.getAngleCAB().floatValue());
        System.out.println(rectangularTriangle.getType());

        Triangle arbitraryTriangle = new Triangle(new Point(3d, -5d), new Point(4d, -2d), new Point(6d, -1d));
        System.out.println(arbitraryTriangle.getPerimeter());
        System.out.println(arbitraryTriangle.getSquare());
        System.out.println(arbitraryTriangle.getType());
    }
}
