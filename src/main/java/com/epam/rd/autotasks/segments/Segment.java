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

        double denom = (another.end.getY() - another.start.getY()) * (this.end.getX() - this.start.getX()) - (another.end.getX() - another.start.getX()) * (this.end.getY() - this.start.getY());
        if (denom == 0.0) { // Lines are parallel.
            return null;
        }
        double ua = ((another.end.getX() - another.start.getX()) * (this.start.getY() - another.start.getY()) - (another.end.getY() - another.start.getY()) * (this.start.getX() - another.start.getX())) / denom;
        double ub = ((this.end.getX() - this.start.getX()) * (another.start.getX() - another.start.getY()) - (this.end.getY() - this.start.getY()) * (this.start.getX() - another.start.getX())) / denom;
        if (ua >= 0.0 && ua <= 1.0 && ub >= 0.0 && ub <= 1.0) {

            return new Point((this.start.getX() + ua * (this.end.getX() - this.start.getX())), (this.start.getY() + ua * (this.end.getY() - this.start.getY())));
        }

        return null;
    }
}
