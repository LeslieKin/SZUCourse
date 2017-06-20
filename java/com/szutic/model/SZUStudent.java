package com.szutic.model;

public class SZUStudent {

    private String studentNumber;
    private String studentName;
    private String studentSex;
    private String studentClass;

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public String toString() {
        String data = "SZUStudent[studentNumber : %s, studentName : %s, "
                + "studentSex : %s, studentClass : %s]\n";
        return String.format(data,
                studentNumber, studentName,
                studentSex, studentClass);
    }
}
