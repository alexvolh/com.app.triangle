import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class TriangleService {
    static List<Triangle> createListTriangles() {
        List<Triangle> triangles = new ArrayList<>();
        triangles.add(new Triangle(new Point(-6d,-1d), new Point( 0d,-1d), new Point(-3d,5d)));
        triangles.add(new Triangle(new Point(0d,3d), new Point( -6d,1d), new Point(-2d,-3d)));
        triangles.add(new Triangle(new Point(-5d, 0d), new Point(-5d, 6d), new Point(-0d, 0d)));
        triangles.add(new Triangle(new Point(3d, -5d), new Point(4d, -2d), new Point(6d, -1d)));
        triangles.add(new Triangle(new Point(1d, 2d), new Point(10d, 2d), new Point(10d, 10d)));
        triangles.add(new Triangle(new Point(3d, 1d), new Point(-3d, 1d), new Point(0d, 3d)));
        triangles.add(new Triangle(new Point(3d, 1d), new Point(-3d, 1d), new Point(0d, 3d)));
        triangles.add(new Triangle(new Point(-2d, -2d), new Point(-8d, -2d), new Point(-5d, 8d)));
        triangles.add(new Triangle(new Point(4d, 0d), new Point(0d, -4d), new Point(0d, 0d)));
        triangles.add(new Triangle(new Point(5d, 6d), new Point(7d, -2d), new Point(5d, -6d)));
        triangles.add(new Triangle(new Point(5d, 6d), new Point(7d, -2d), new Point(5d, -6d)));
        triangles.add(new Triangle(new Point(3d, 1d), new Point(3d, 10d), new Point(7d, 5d)));
        triangles.add(new Triangle(new Point(10d, 5d), new Point(0d, -6d), new Point(11d, -2d)));
        triangles.add(new Triangle(new Point(6d, 10d), new Point(13d, 8d), new Point(10d, 10d)));
        triangles.add(new Triangle(new Point(-2d, 2d), new Point(-2d, 0d), new Point(-4d, 0d)));
        triangles.add(new Triangle(new Point(7d,2d), new Point( 1d,2d), new Point(4d,-4d)));

        return triangles;
    }

    static int getCountType(List<Triangle> triangles, Triangle.Type type) {
        return (int)triangles.stream().filter(t -> t.getType() == type).count();
    }

    static Double getMaxSquare(List<Triangle> triangles, Triangle.Type type) {
            return triangles.stream().filter(t -> t.getType() == type).max(Comparator.comparingDouble(Triangle::getSquare)).orElse(null).getSquare();
    }

    static Double getMaxPerimeter(List<Triangle> triangles, Triangle.Type type) {
            return triangles.stream().filter(t -> t.getType() == type).max(Comparator.comparingDouble(Triangle::getPerimeter)).orElse(null).getPerimeter();
    }
}
