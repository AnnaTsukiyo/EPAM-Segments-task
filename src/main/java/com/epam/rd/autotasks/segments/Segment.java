package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    Point start;
    Point end;

    public Segment(Point start, Point end) throws RuntimeException {
        if (start.equals(end) || (this.end == null) || (this.start == null)) {
            throw new RuntimeException();
        } else {
            this.start = start;
            this.end = end;
        }
    }

    double length() {
        return Math.sqrt((Math.pow((end.getX() - start.getX()), 2)) + Math.pow((end.getY() - start.getY()), 2));
    }

    Point middle() {
        return new Point((start.getX() + end.getX()) / 2,
                (start.getY() + end.getY()) / 2);
    }

    Point intersection(Segment another) {
        if ((end.getY() - start.getY() / end.getX() - start.getX()) == another.end.getY() - another.start.getY() / another.end.getX() - another.start.getX()) {
            return null;
        }
        double A1 = another.end.getY() - another.start.getY();
        double B1 = another.start.getX() - another.end.getX();
        double C1 = A1 * another.start.getX() + B1 * another.start.getY();

        double A2 = end.getY() - start.getY();
        double B2 = start.getX() - end.getX();
        double C2 = A2 * start.getX() + B2 * start.getY();

        double det = A1 * B2 - A2 * B1;
        if (det == 0) {
            return null;
        }
        double x = (B2 * C1 - B1 * C2) / det;
        double y = (A1 * C2 - A2 * C1) / det;
        return new Point(x, y);
    }
}
