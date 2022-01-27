package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    private Point start;
    private Point end;

    public Segment(Point start, Point end) throws IllegalArgumentException {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Arguments can't be null");
        }
        if (start.equals(end)) {
            throw new IllegalArgumentException("The points must differ");
        } else {
            this.start = start;
            this.end = end;
        }
    }

    double length() {
        double length = Math.sqrt((Math.pow((end.getX() - start.getX()), 2)) + Math.pow((end.getY() - start.getY()), 2));
        return length;
    }


    Point middle() {
        return new Point((start.getX() + end.getX()) / 2,
                (start.getY() + end.getY()) / 2);
    }

    Point intersection(Segment another) {
        double A1 = this.end.getY() - this.start.getY();
        double B1 = this.start.getX() - this.end.getX();
        double C1 = A1 * this.start.getX() + B1 * this.start.getY();

        double A2 = another.end.getY() - another.start.getY();
        double B2 = another.start.getX() - another.end.getX();
        double C2 = A2 * another.start.getX() + B2 * another.start.getY();

        double det = (A1 * B2) - (A2 * B1);
        double x = (B2 * C1 - B1 * C2) / det;
        double y = (A1 * C2 - A2 * C1) / det;
        if ((this.end == another.end && this.start != another.start) || (this.start == another.start && this.end == another.end)) {
            return null;
        } else {
            return new Point((int) x, (int) y);
        }
    }
}


