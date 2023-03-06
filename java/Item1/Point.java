package Item1;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Point o) {
        if (getX() > o.getX()) {
            return 1;
        } else if (getX() < o.getX()) {
            return -1;
        } else {
            if (getY() > o.getY()) {
                return 1;
            } else if (getY() < o.getY()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, -1);
        Point p2 = new Point(1, -5);
        Point p3 = new Point(2, 10);
        Point p4 = new Point(2, 1);
        Point p5 = new Point(1, 0);
        Point[] points = new Point[]{p1, p2, p3, p4, p5};

        Arrays.sort(points);
        System.out.println(Arrays.toString(points));

        List<Point> points1 = Arrays.asList(new Point(1, -1), new Point(10, 10), new Point(0,0));
        Collections.sort(points1);
        System.out.println(points1);
    }
}
