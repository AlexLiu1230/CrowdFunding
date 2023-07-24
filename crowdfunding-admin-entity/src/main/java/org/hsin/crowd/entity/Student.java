package org.hsin.crowd.entity;

import java.util.List;
import java.util.Map;

/**
 * ClassName: Student
 * Package: org.hsin.crowd.entity
 * Description:
 *
 * @Author YuHsin Liu
 * @Create 2023/7/24 4:18 PM
 * @Version 1.0
 */
public class Student {

    private Integer studentId;
    private String studentName;
    private Address studentAddress;
    private List<Subject> subjectList;
    private Map<String, String> map;

    public Student() {
    }

    public Student(Integer studentId, String studentName, Address studentAddress, List<Subject> subjectList, Map<String, String> map) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.subjectList = subjectList;
        this.map = map;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentAddress=" + studentAddress +
                ", subjectList=" + subjectList +
                ", map=" + map +
                '}';
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Address getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(Address studentAddress) {
        this.studentAddress = studentAddress;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
