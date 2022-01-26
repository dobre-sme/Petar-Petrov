package com.company;

public class Circle {


    private int coordinateA;
    private int coordinateB;
    private int radius;

    public static boolean Intersect (Circle c1, Circle c2) {
        int distance = (c1.coordinateA - c2.coordinateA) * (c1.coordinateA - c2.coordinateA) +
                (c1.coordinateB - c2.coordinateB) * (c1.coordinateB - c2.coordinateB);
        int radiusSum = (c1.radius + c2.radius) * (c1.radius + c2.radius);

        if (distance > radiusSum)
            return false;
        else
            return true;
    }

    public Circle(int coordinateA, int coordinateB, int radius) {
        this.coordinateA = coordinateA;
        this.coordinateB = coordinateB;
        this.radius = radius;
    }

}
