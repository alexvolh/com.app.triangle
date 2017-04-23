import org.jetbrains.annotations.NotNull;

/**
 * Triangle class
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    private Double sideAB;
    private Double sideBC;
    private Double sideAC;

    private Double angleABC;
    private Double angleBAC;
    private Double angleCAB;

    private Double square = 0d;
    private Double perimeter =0d;

    private Type type = Type.ARBITRARY;
    private String Base = "none";

    Triangle() {};

    Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;

        setTriangleSides();
        setAngles();
        setPerimeter();
        setSquareByGeron();
//        setSquareByCoordinate();
        setType();
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public Double getSquare() {
        return square;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public Double getSideAB() {
        return sideAB;
    }

    private void setSideAB() {
        sideAB = lengthSide(a,b);
    }

    public Double getSideBC() {
        return sideBC;
    }

    private void setSideBC() {
        sideBC = lengthSide(b,c);
    }

    public Double getSideAC() {
        return sideAC;
    }

    private void setSideAC() {
        sideAC = lengthSide(a,c);
    }

    public void setTriangleSides() {
        setSideAB();
        setSideBC();
        setSideAC();
    }

    public Type getType() {
        return type;
    }

    public String getBase() {
        return Base;
    }

    public void setBase(String base) {
        Base = base;
    }

    public Double getAngleABC() {
        return angleABC;
    }

    public void setAngleABC() {
        angleABC = angleTriangle(a,b,c);
    }

    public Double getAngleBAC() {
        return angleBAC;
    }

    public void setAngleBAC() {
        angleBAC = angleTriangle(b,a,c);
    }

    public Double getAngleCAB() {
        return angleCAB;
    }

    public void setAngleCAB() {
        angleCAB = angleTriangle(c,a,b);
    }

    private void setAngles() {
        setAngleABC();
        setAngleBAC();
        setAngleCAB();
    }

    @NotNull
    private Double lengthSide(Point first, Point second) {
        return Math.sqrt(Math.pow((second.getX() - first.getX()),2) + Math.pow((second.getY()-first.getY()),2));
    }

    public void setSquareByCoordinate() {
        square = (((a.getX() - c.getX()) * (b.getY() - c.getY())) - ((b.getX() - c.getX()) * (a.getY() - c.getY()))) * 0.5;
    }

    public void setSquareByGeron() {
        Double halfPerimeter = perimeter /2;
        square = halfPerimeter * (halfPerimeter - sideAB) * (halfPerimeter - sideBC) * (halfPerimeter - sideAC);
    }

    public void setPerimeter() {
        if (sideAB != null & sideBC != null & sideAC != null) {
            perimeter = sideAB + sideBC + sideAC;
        }
    }

    public void setType() {
        if (sideAB.intValue() == sideBC.intValue()) {
            type = Type.ISOSCELES;
            setBase("AC");
        } else if (sideBC.intValue() == sideAC.intValue()) {
            type = Type.ISOSCELES;
            setBase("AB");
        } else if (sideAB.intValue() == sideAC.intValue()) {
            type = Type.ISOSCELES;
            setBase("BC");
        }

        if (sideAB.intValue() == sideBC.intValue() & sideBC.intValue() == sideAC.intValue()) {
            type = Type.EQUILATERAL;
        }

        if (angleABC == 0 | angleBAC == 0 | angleCAB == 0) {
            type = Type.RECTANGULAR;
        }
    }

    public Double angleTriangle(Point first, Point second, Point third) {
        //find vector coordinates
        Double x1 = second.getX() - first.getX();
        Double y1 = second.getY() - first.getY();
        Double x2 = third.getX() - first.getX();
        Double y2 = third.getY() - first.getY();

        //Scalar product
        Double scalar = (x1 * x2) + (y1 * y2);

        //length of vector
        Double lengthAB = Math.sqrt(Math.pow(x1,2) + Math.pow(y1,2));
        Double lengthAC = Math.sqrt(Math.pow(x2,2) + Math.pow(y2,2));

        //cos
        return scalar /(lengthAB * lengthAC);
    }
    enum Type{
        EQUILATERAL, ISOSCELES, RECTANGULAR, ARBITRARY
    }
}

