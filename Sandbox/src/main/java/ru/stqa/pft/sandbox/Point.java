package ru.stqa.pft.sandbox;

/**
 * 1. Создать класс ru.stqa.pft.sandbox.Point для представления точек на двумерной плоскости.
 * Объекты этого класса должны содержать два атрибута, которые
 * соответствуют координатам точки на плоскости.
 * <p>
 * 2. Создать функцию
 * public static double distance(ru.stqa.pft.sandbox.Point p1, ru.stqa.pft.sandbox.Point p2)
 * которая вычисляет расстояние между двумя точками.
 * Для вычисления квадратного корня можно использовать функцию Math.sqrt
 * <p>
 * 3. Сделать запускаемый класс, то есть содержащий функцию
 * public static void main(String[] args) {...}
 * и при помощи него убедиться, что функция вычисления расстояния между
 * точками действительно работает. Результат вычисления выводить на экран и контролировать
 * визуально.
 * <p>
 * 4. Реализовать то же самое (вычисление расстояния между двумя точками)
 * при помощи метода в классе ru.stqa.pft.sandbox.Point, и добавить в созданный в предыдущем
 * пункте запускаемый класс примеры использования метода вместо ранее созданной функции.
 */
public class Point {
    public double x;
    public double y;//public double x2;
//public double y2;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p2) {
        return Math.sqrt(Math.pow((p2.x - this.x), 2) + Math.pow((p2.y - this.y), 2));
    }
}

