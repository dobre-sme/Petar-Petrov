package com.company;

import java.util.*;

public class IntersectionOfCircles {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] firstCircle = scan.nextLine().split(" ");
        String[] secondCircle = scan.nextLine().split(" ");
        int[] circleF = new int[firstCircle.length];
        int[] circleS = new int[firstCircle.length];
        for (int i = 0; i < firstCircle.length; i++) {
            circleF[i] = Integer.parseInt(firstCircle[i]);
            circleS[i] = Integer.parseInt(secondCircle[i]);
        }
        Circle first = new Circle(circleF[0], circleF[1], circleF[2]);
        Circle second = new Circle(circleS[0], circleS[1], circleS[2]);
        if (Circle.Intersect(first, second)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        };
    }
}

