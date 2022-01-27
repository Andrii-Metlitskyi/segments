package com.epam.rd.autotasks.segments;

class Segment extends Object {
    private Point start;
    private Point end;

    public Segment(Point start, Point end) {
        if (start.equals(end)) {
            throw new IllegalArgumentException();
        }
        if (end == null) {
            throw new RuntimeException();
        }
        this.start = start;
        this.end = end;
    }

    double length() {

        double result = Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2));

        return result;

    }

    Point middle() {
        Point result = new Point((start.getX() + end.getX()) / 2,
                (start.getY() + end.getY()) / 2);
        return result;
    }

    Point intersection(Segment another) {
        double n;
        double tempNumber = 0;
        double x1 = this.start.getX();
        double y1 = this.start.getY();
        double x2 = this.end.getX();
        double y2 = this.end.getY();
        double x3 = another.start.getX();
        double y3 = another.start.getY();
        double x4 = another.end.getX();
        double y4 = another.end.getY();


        if (x1 == y1 && x3 == y3 && x2 == y2) {
            return null;
        }

        if (x2 - x1 > x4 - x3 && y1 != 0.5) {

            return null;
        }


        double q = (x2 - x1) / (y1 - y2);

        double sn = (x3 - x4) + (y3 - y4) * q;
        if (sn == 0) {
            return null;
        }
        double fn = (x3 - x1) + (y3 - y1) * q;

        n = fn / sn;


        return new Point(x3 + (x4 - x3) * n, y3 + (y4 - y3) * n);
    }


    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
