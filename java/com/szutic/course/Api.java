package com.szutic.course;

import com.szutic.model.Course;
import com.szutic.model.SZUStudent;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Api {

    private HttpClient client;

    public Api() {
        client = new HttpClient();
    }

    // 如果不在校内网，需要设置代理
    public Api(String studentNumber, String studentPassword) {
        client = new HttpClient();
        client.getHostConfiguration().setProxy("proxy.szu.edu.cn", 8080);
        client.getParams().setAuthenticationPreemptive(true);
        client.getState().setProxyCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials(studentNumber, studentPassword));
    }

    public List<String> fetchXQHs() throws IOException {
        String contentUrl = "http://192.168.2.229/newkc/content.asp";
        GetMethod contentMethod = new GetMethod(contentUrl);
        client.executeMethod(contentMethod);

        String html = new String(contentMethod.getResponseBody(), "GB2312");
        Document document = Jsoup.parse(html);
        Elements as = document.getElementsByTag("a");
        int size = null == as ? 0 : as.size();
        List<String> xqhs = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            String xqhUrl = as.get(i).attr("href");
            xqhs.add(xqhUrl.substring("akcjj0.asp?xqh=".length()));
        }
        return xqhs;
    }

    public List<String> fetchKKDWs(String xqh) throws IOException {
        String xqhUrl = "http://192.168.2.229/newkc/akcjj0.asp?xqh=" + xqh;
        GetMethod xqhMethod = new GetMethod(xqhUrl);
        client.executeMethod(xqhMethod);

        String kkdwUrl = "http://192.168.2.229/newkc/akechengdw.asp";
        GetMethod kkdwMethod = new GetMethod(kkdwUrl);
        client.executeMethod(kkdwMethod);

        String html = new String(kkdwMethod.getResponseBody(), "gb2312");
        Document document = Jsoup.parse(html);
        Elements options = document.getElementsByTag("option");
        return options.stream()
                .map(Element::text)
                .collect(Collectors.toList());
    }

    public List<Course> fetchCourses(String xqh, String kkdw) throws IOException {
        String xqhUrl = "http://192.168.2.229/newkc/akcjj0.asp?xqh=" + xqh;
        GetMethod xqhMethod = new GetMethod(xqhUrl);
        client.executeMethod(xqhMethod);

        String courseUrl = "http://192.168.2.229/newkc/kccx.asp?flag=kkdw";
        PostMethod courseMethod = new PostMethod(courseUrl);
        courseMethod.setRequestBody(new NameValuePair[]{
                new NameValuePair("bh", kkdw)
        });
        client.executeMethod(courseMethod);

        String html = new String(courseMethod.getResponseBody(), "gb2312");
        Document document = Jsoup.parse(html);
        Elements trs = document.getElementsByTag("tr");
        int size = null == trs ? 0 : trs.size();
        List<Course> courses = new ArrayList<>(size);
        for (int i = 1; i < size - 2 && null != trs; i++) {
            Course course = new Course();
            Element tr = trs.get(i);
            if (null == tr) {
                continue;
            }
            Elements tds = tr.getElementsByTag("td");
            if (null == tds) {
                continue;
            }
            course.setCourseNumber(tds.get(1).text());
            course.setCourseName(tds.get(2).text());
            course.setCourseCredit(tds.get(3).text());
            course.setCourseStudentNumber(tds.get(4).text());
            course.setCourseLimitNumber(tds.get(5).text());
            course.setKkdw(tds.get(6).text());
            course.setCourseType(tds.get(7).text());
            course.setCourseClass(tds.get(8).text());
            course.setCourseTeacher(tds.get(9).text());
            course.setCourseWeek(tds.get(10).text());
            course.setCourseTime(tds.get(11).text());
            course.setCourseLocation(tds.get(12).text());
            course.setCreditType(tds.get(13).text());
            course.setCourseDescription(tds.get(14).text());
            courses.add(course);
        }
        return courses;
    }

    public List<SZUStudent> fetchStudents(String xqh, String kkdw, String courseNumber) throws IOException {
        String xqhUrl = "http://192.168.2.229/newkc/akcjj0.asp?xqh=" + xqh;
        GetMethod xqhMethod = new GetMethod(xqhUrl);
        client.executeMethod(xqhMethod);

        String studentUrl = "http://192.168.2.229/newkc/kcxkrs.asp";
        GetMethod studentMethod = new GetMethod(studentUrl);
        studentMethod.setQueryString(new NameValuePair[]{
                new NameValuePair("ykch", courseNumber)
        });
        client.executeMethod(studentMethod);

        String html = new String(studentMethod.getResponseBody(), "gb2312");
        Document document = Jsoup.parse(html);
        Elements trs = document.getElementsByTag("tr");
        int size = null == trs ? 0 : trs.size();
        List<SZUStudent> students = new ArrayList<>(size);
        for (int i = 3; i < size; i++) {
            SZUStudent student = new SZUStudent();
            Element tr = trs.get(i);
            student.setStudentNumber(tr.child(1).text());
            student.setStudentName(tr.child(2).text());
            student.setStudentSex(tr.child(3).text());
            student.setStudentClass(tr.child(4).text());
            students.add(student);
        }
        return students;
    }
}