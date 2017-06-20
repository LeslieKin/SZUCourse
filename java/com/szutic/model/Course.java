package com.szutic.model;

public class Course {
    private String courseNumber;
    private String courseName;
    private String courseCredit;
    private String courseStudentNumber;
    private String courseLimitNumber;
    private String kkdw;
    private String courseType;
    private String courseClass;
    private String courseTeacher;
    private String courseWeek;
    private String courseTime;
    private String courseLocation;
    private String creditType;
    private String courseDescription;

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(String courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getCourseStudentNumber() {
        return courseStudentNumber;
    }

    public void setCourseStudentNumber(String courseStudentNumber) {
        this.courseStudentNumber = courseStudentNumber;
    }

    public String getCourseLimitNumber() {
        return courseLimitNumber;
    }

    public void setCourseLimitNumber(String courseLimitNumber) {
        this.courseLimitNumber = courseLimitNumber;
    }

    public String getKkdw() {
        return kkdw;
    }

    public void setKkdw(String kkdw) {
        this.kkdw = kkdw;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(String courseClass) {
        this.courseClass = courseClass;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public String getCourseWeek() {
        return courseWeek;
    }

    public void setCourseWeek(String courseWeek) {
        this.courseWeek = courseWeek;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    @Override
    public String toString() {
        String data = "Course[courseNumber : %s, courseName : %s, "
                + "courseCredit : %s, courseStudentNumber : %s, "
                + "courseLimitNumber : %s, kkdw : %s, "
                + "courseType : %s, courseClass : %s, "
                + "courseTeacher : %s, courseWeek : %s, "
                + "courseTime : %s, courseLocation : %s, "
                + "creditType : %s, courseDescription : %s]\n";
        return String.format(data,
                courseNumber, courseName,
                courseCredit, courseStudentNumber,
                courseLimitNumber, kkdw,
                courseType, courseClass,
                courseTeacher, courseWeek,
                courseTime, courseLocation,
                creditType, courseDescription);
    }
}