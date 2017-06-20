package com.test;

import com.szutic.course.Api;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {

    private Api api = new Api();

    @Test
    public void testXqhs() throws IOException {
        System.out.println(api.fetchXQHs());
    }

    @Test
    public void testKkdws() throws IOException {
        System.out.println(api.fetchKKDWs("20161"));
    }

    @Test
    public void testCourses() throws IOException {
        System.out.println(api.fetchCourses("20161", "MOOC"));
    }

    @Test
    public void testStudents() throws IOException {
        System.out.println(api.fetchStudents("20161", "MOOC", "MC99000101"));
    }

}