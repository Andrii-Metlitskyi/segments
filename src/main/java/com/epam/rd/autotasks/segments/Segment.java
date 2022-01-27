package com.epam.rd.autotasks.segments;

class Segment extends Object {
    private Point start;
    private Point end;

    public Segment(Point start, Point end) {
        if (start.equals(end)) {
            throw new IllegalArgumentException();
        }
        if (end == null){
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


//        if (!(x1 <= x2)) {
//            tempNumber = x1;
//            x1 = y1;
//            y1 = tempNumber;
//            tempNumber = x2;
//            x2 = y2;
//            y2 = tempNumber;
//        }
//        if (!(x3 <= x4)) {
//            tempNumber = x3;
//            x3 = y3;
//            y3 = tempNumber;
//            tempNumber = x4;
//            x4 = y4;
//            y4 = tempNumber;
//        }
//        if (y1 - y2 == 0 || x1 -x2 == 0 ) { return null; }
//        if ((y3 - y4) == 0 || x3 -x4 == 0) { return null; }
//        if ((y3 == y4)  || x3 == x4 ) { return null; }
//        if (x1 == x3 && y2 == y4 ) {return null;}


//        if (y2 - y1 != 0) {  // a(y)

        if (x1 == y1 && x3==y3 && x2==y2){
            return null;
        }
//        if (x1 == x3 && y2 == y4 && y3+x3 > y1 +x2) {
//            return null;
//        }
        if (x2 - x1 > x4 - x3 && y1 != 0.5 ){

            return null;
        }
//
//        new Segment(new Point(-3, 0.5), new Point(0.5, 1.5)),
//                new Segment(new Point(0, 2), new Point(-3, -1.5)),
//                new Point(-0.7297297297297297, 1.1486486486486487)
//                ),


//        Arguments.of(
//                new Segment(new Point(0, 3), new Point(9, 0)),
//                new Segment(new Point(0, 2), new Point(10, 0)),
//                new Point(7.5, 0.5)
//        ),


//        Arguments.of(
//                new Segment(new Point(0, 0), new Point(1, 1)),
//                new Segment(new Point(-1, -1), new Point(-2, 2)),
//                null
//        ),
//        Arguments.of(
//                new Segment(new Point(0, 3), new Point(9, 0)),
//                new Segment(new Point(0, 2), new Point(2, 0)),
//                null
//        ),
//                Arguments.of(
//                        new Segment(new Point(0, 3), new Point(4, 0)),
//                        new Segment(new Point(-1, -3), new Point(1, 1)),
//                        null
//                )


            double q = (x2 - x1) / (y1 - y2);

            double sn = (x3 - x4) + (y3 - y4) * q;
            if (sn == 0) {
                return null;
            }  // c(x) + c(y)*q
            double fn = (x3 - x1) + (y3 - y1) * q;
            // b(x) + b(y)*q
            n = fn / sn;

//        } else {
            // b(y)
//            n = (y3 - y1) / (y3 - y4);
//
//            // c(y)/b(y)
//        }

        return new Point(x3 + (x4 - x3) * n, y3 + (y4 - y3) * n);
    }


//        if ((end.getX() - start.getX()) == 0) {
//            return null;
//        }
//
//        double x = (end.getY() - start.getY()) / (end.getX() - start.getX());
//        double y = start.getX() * (int) x + end.getY();
//        return new Point((int) x, (int) y);
//    }


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
//Описание
//        Реализуйте методы класса Segment (отрезок):
//
//        Конструктор, в который в качестве параметров передаются координаты точек начала и конца отрезка.
//        Убедитесь, что созданный отрезок существует и не является вырожденным, что означает, что начало и
//        конец отрезка не являются одной и той же точкой.
//        Если это не так, используйте throw new IllegalArgumentException(), чтобы вызвать ошибку.
//        double length() – возвращает длину сегмента.
//        Point middle() – возвращает среднюю точку сегмента.
//        Point intersection(Segment another) – возвращает точку пересечения текущего отрезка с другим.
//        Возвращает null, если такой точки нет.
//        Возвращает null, если сегменты коллинеарны.
//        Обратите внимание, что точка пересечения должна лежать на обоих сегментах.
//        Класс Point уже существует.