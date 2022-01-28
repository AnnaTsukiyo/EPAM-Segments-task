package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {

    private final Point start;
    private final Point end;

    public Segment(Point start, Point end) throws RuntimeException {
        if (start.equals(end)) {
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
        double denom = (another.end.getY() - another.start.getY()) * (end.getX() - start.getX()) - (another.end.getX() - another.start.getX()) * (end.getY() - start.getY());
        if (denom == 0) { // Lines are parallel.
            return null;
        }
        if (((end.getX() - start.getX()) / (another.end.getX() - another.start.getX())) == (((end.getY()) - start.getY()) / (another.end.getY() - another.start.getY()))) {
            return null;
        }
        double ua = ((another.end.getX() - another.start.getX()) * (start.getY() - another.start.getY()) - (another.end.getY() - another.start.getY()) * (start.getX() - another.start.getX())) / denom;
        double ub = ((end.getX() - start.getX()) * (another.start.getX() - another.start.getY()) - (end.getY() - start.getY()) * (start.getX() - another.start.getX())) / denom;
        return new Point((start.getX() + ua * (end.getX() - start.getX())), (start.getY() + ub * (end.getY() - start.getY())));
    }
}
