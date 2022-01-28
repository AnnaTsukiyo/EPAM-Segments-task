package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {

    public Segment(Point start, Point end) throws RuntimeException {
        if (!start.equals(end)) {
            this.start = start;
            this.end = end;
        } else {
            throw new RuntimeException();
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
        double k1 = (end.getY() - start.getY() / (end.getX() - start.getX()));
        double k2 = (another.end.getY() - another.start.getY() / (another.end.getX() - another.start.getX()));
        if (k1 == k2) {
            return null;
        }
        double x1 = start.getX();
        double x2 = end.getX();
        double x3 = another.start.getX();
        double x4 = another.end.getX();
        double y1 = start.getY();
        double y2 = end.getY();
        double y3 = another.start.getY();
        double y4 = another.end.getY();
        double inY;
        double inX;
        double denom;
        denom = (((y4 - y3) * (x2 - x1)) - ((x4 - x3) * (y2 - y1)));
        if (denom == 0) {
            return null;
        } else {
            double u1 = (((x4 - x3) * (y1 - y3)) - ((y4 - y3) * (x1 - x3))) / denom;
            double u2 = (((x2 - x1) * (y1 - y3)) - ((y2 - y1) * (x1 - x3))) / denom;
            if (u1 > 1 || u1 < 0 || u2 > 1 || u2 < 0) {
                return null;
            } else {
                inX = x1 + (u1 * (x2 - x1));
                inY = y1 + (u1 * (y2 - y1));
            }
        }
        return new Point(inX, inY);
    }
}