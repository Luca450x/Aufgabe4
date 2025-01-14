package org.hbrs.se1.ws24.uebung10;

import java.util.Objects;

public class MyPoint {
    private double x, y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPoint myPoint = (MyPoint) o;
        return Double.compare(myPoint.x, x) == 0 &&
                Double.compare(myPoint.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "MyPoint{" + "x=" + x + ", y=" + y + '}';
    }
}
