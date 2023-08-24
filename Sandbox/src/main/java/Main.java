public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(2.0,3.0);//конструктор
        Point p2 = new Point(4.0,2.0);
        System.out.println(distance(p1, p2));

        Point p3 = new Point(1.2, 4.6);
        Point p4 = new Point(-0.2, 1.1);
        System.out.println(distance(p3, p4));

    }

    public static double distance(Point p1, Point p2) {
        double x1 = p1.x;
        double y1 = p1.y;
        double x2 = p2.x;
        double y2 = p2.y;
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));

    }

}
