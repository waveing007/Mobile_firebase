package com.example.a60022101_senddatatofirebase;

public class Students {
    private String studentId;
    private String studentName;
    private String StudentLastName;
    private String    StudentNumber;

    public  Students(){

    }

    public Students(String studentId, String studentName, String studentLastName, String studentNumber) {
        this.studentId = studentId;
        this.studentName = studentName;
        StudentLastName = studentLastName;
        StudentNumber   = studentNumber;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentLastN() {
        return StudentLastName;
    }

    public String getStudentNumber() {
        return StudentNumber;
    }
}
