package com.company;

import java.util.ArrayList;
import java.util.List;

public class Student {

    public String getName() {
        return name;
    }

    private String name;
    private List<Double> grades = new ArrayList<>();
    private double averageGrade;


    public double getAverageGrade() {
        double grade = 0.0;
        for (int i = 0; i < grades.size(); i++) {
            grade += grades.get(i);
        }
        return grade/grades.size();
    }


    public Student(String name, List<Double> grades) {
        this.name = name;
        this.grades = grades;
    }
}
