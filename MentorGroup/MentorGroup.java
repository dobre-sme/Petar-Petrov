package com.company;

import java.util.*;

public class MentorGroup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Student> nameStudents = new HashMap<>();
        List<String> studentNames = new ArrayList<>();
        while (!input.equals("end of dates")) {
            String[] nameAndDates = input.split(" ");
            String[] inputDates = nameAndDates[1].split(",");
                if (Character.isDigit(nameAndDates[1].charAt(0))) {
                    List<String> dates = new ArrayList<>(Arrays.asList(inputDates));
                    String name = nameAndDates[0];
                    studentNames.add(name);
                    Student student = new Student(name, new ArrayList<>(), dates);
                    nameStudents.put(name, student);
                }

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("end of comments")) {
            String[] studentComments = input.split("-");
            String studentName = studentComments[0];
            String comment = studentComments[1];
            if (!Character.isDigit(comment.charAt(0)) && nameStudents.containsKey(studentName)) {
                nameStudents.get(studentName).getComments().add(comment);
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < nameStudents.size(); i++) {
            String currentStudent = studentNames.get(i);
            System.out.println(currentStudent);
            System.out.println("Comments:");
            int commentsCounter = nameStudents.get(currentStudent).getComments().size();
            for (int j = 0; j < commentsCounter; j++) {
                System.out.println("- " + nameStudents.get(currentStudent).getComments().get(j));
            }
            System.out.println("Dates Attended:");
            int datesCounter = nameStudents.get(currentStudent).getAttendanceDays().size();
            for (int j = 0; j < datesCounter; j++) {
                System.out.println("-- " + nameStudents.get(currentStudent).getAttendanceDays().get(j));
            }
        }
    }
}