package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SquareTests {
   //аннотация-особый класс, который используется как псевдо коммент
   @Test
    public void testArea() {
        Square s = new Square(5);
       Assert.assertEquals (s.area(), 25.0);//сравнение двух величин
    }
}
