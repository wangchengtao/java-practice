package app;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Point implements Comparable<Point> {
    private int x;
    private int y;

    public Point(int x, int y) {
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
        return getX() == point.getX() &&
                getY() == point.getY();
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    @Override
    public int compareTo(Point o) {
        if (x > o.x) {
            return 1;
        } else if (x == o.x) {
            return Integer.compare(y, o.y);
        } else {
            return -1;
        }
    }

    public static List<Point> sort(List<Point> points) {
        Collections.sort(points);
        return points;
    }

    public static void main(String[] args) {
        List<Point> points = Arrays.asList(
                new Point(1, 1),
                new Point(1, -1),
                new Point(2, 0),
                new Point(2, 1),
                new Point(1, 0)
        );

        System.out.println(Point.sort(points));
    }
}
