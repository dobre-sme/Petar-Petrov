package com.company;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<String> comments = new ArrayList<>();
    private List<String> attendanceDays = new ArrayList<>();

    public Student(String name, List<String> comments, List<String> attendanceDays) {
        this.name = name;
        this.comments = comments;
        this.attendanceDays = attendanceDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public List<String> getAttendanceDays() {
        return attendanceDays;
    }

    public void setAttendanceDays(List<String> attendanceDays) {
        this.attendanceDays = attendanceDays;
    }

}
