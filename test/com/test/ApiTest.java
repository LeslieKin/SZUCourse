package com.test;

import com.szutic.course.Api;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {

  private Api api = new Api();

  @Test
  @Ignore
  public void testContext() throws IOException {
    System.out.println(api.fetchXQHs());
  }

  @Test
  @Ignore
  public void testKkdw() throws IOException {
    System.out.println(api.fetchKKDWs("20161"));
  }

  @Test
  @Ignore
  public void testCourse() throws IOException {
    System.out.println(api.fetchCourses("20161", "MOOC"));
  }

  @Test
  public void testStudent() throws IOException {
    System.out.println(api.fetchStudents("20161", "MOOC", "MC01001701"));
  }

}