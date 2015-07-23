package com.example.felixamoruwa.statisticsapplication.model;

/**
 * Created by felixamoruwa on 7/15/15.
 */
public class Student {

    private int studentId;
    private int q1;
    private int q2;
    private int q3;
    private int q4;
    private int q5;

    public Student(int studentId) {
        this.studentId = studentId;
    }

    public Student(int studentId, int q1, int q2, int q3, int q4, int q5) {
        this.studentId = studentId;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getQ1() {
        return q1;
    }

    public void setQ1(int q1) {
        this.q1 = q1;
    }

    public int getQ2() {
        return q2;
    }

    public void setQ2(int q2) {
        this.q2 = q2;
    }

    public int getQ3() {
        return q3;
    }

    public void setQ3(int q3) {
        this.q3 = q3;
    }

    public int getQ4() {
        return q4;
    }

    public void setQ4(int q4) {
        this.q4 = q4;
    }

    public int getQ5() {
        return q5;
    }

    public void setQ5(int q5) {
        this.q5 = q5;
    }

    public int[] getScores() {
        return new int[] {q1,q2,q3,q4,q5};
    }

    public String toStringDisplay() {
        final StringBuffer sb = new StringBuffer("");
        sb.append(studentId);
        sb.append("    ").append(q1);
        sb.append("    ").append(q2);
        sb.append("    ").append(q3);
        sb.append("    ").append(q4);
        sb.append("    ").append(q5);
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("studentId=").append(studentId);
        sb.append(", q1=").append(q1);
        sb.append(", q2=").append(q2);
        sb.append(", q3=").append(q3);
        sb.append(", q4=").append(q4);
        sb.append(", q5=").append(q5);
        sb.append('}');
        return sb.toString();
    }
}
