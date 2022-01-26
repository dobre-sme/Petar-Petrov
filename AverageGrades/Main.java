package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countOfStudent = Integer.parseInt(scan.nextLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < countOfStudent; i++) {
            String[] studentAndGrades = scan.nextLine().split(" ");
            String name = studentAndGrades[0];
            List<Double> studentGrades = new ArrayList<>();
            for (int j = 1; j < studentAndGrades.length; j++) {
                studentGrades.add(Double.parseDouble(studentAndGrades[j]));
            }
            Student student = new Student(name, studentGrades);
            students.add(student);
        }

        for (int i = 0; i < students.size(); i++) {
            String name = students.get(i).getName();
            for (int j = 0; j < students.size(); j++) {
                String otherName = students.get(j).getName();
                if (name.compareTo(otherName) < 0) {
                    Student currentStudent = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, currentStudent);
                } else if (name.compareTo(otherName) == 0) {
                    if (students.get(i).getAverageGrade() > students.get(j).getAverageGrade()) {
                        Student currentStudent = students.get(i);
                        students.set(i, students.get(j));
                        students.set(j, currentStudent);
                    }
                }
            }
        }
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() >= 5) {
                System.out.printf("%s -> %.2f", students.get(i).getName(), students.get(i).getAverageGrade());
                System.out.println();
            }
        }
    }
}
