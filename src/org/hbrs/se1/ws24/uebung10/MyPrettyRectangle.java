package org.hbrs.se1.ws24.uebung10;

import java.util.Objects;

public class MyPrettyRectangle {
    private double x1, y1, x2, y2;

    public MyPrettyRectangle(double x1, double y1, double x2, double y2) {
        if (x1 > x2 || y1 > y2) {
            throw new IllegalArgumentException("Invalid rectangle coordinates");
        }
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }


    public boolean contains(MyPrettyRectangle other) {
        return this.x1 <= other.x1 && this.y1 <= other.y1 &&
                this.x2 >= other.x2 && this.y2 >= other.y2;
    }

    public MyPoint getCenter() {
        double centerX = (x1 + x2) / 2;
        double centerY = (y1 + y2) / 2;
        return new MyPoint(centerX, centerY);
    }

    public double getArea() {
        return (x2 - x1) * (y2 - y1);
    }

    public double getPerimeter() {
        return 2 * ((x2 - x1) + (y2 - y1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPrettyRectangle that = (MyPrettyRectangle) o;
        return Double.compare(that.x1, x1) == 0 &&
                Double.compare(that.y1, y1) == 0 &&
                Double.compare(that.x2, x2) == 0 &&
                Double.compare(that.y2, y2) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2);
    }
}
