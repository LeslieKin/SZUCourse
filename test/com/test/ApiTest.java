package com.test;

import com.szutic.course.Api;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {

    private Api api = new Api();

    @Test
    public void testContext() throws IOException {
        System.out.println(api.fetchXQHs());
    }

    @Test
    public void testKkdw() throws IOException {
        System.out.println(api.fetchKKDWs("20161"));
    }

    @Test
    public void testCourse() throws IOException {
        System.out.println(api.fetchCourses("20161", "MOOC"));
    }

    @Test
    public void testStudent() throws IOException {
        System.out.println(api.fetchStudents("20161", "MOOC", "MC99000101"));
    }

}