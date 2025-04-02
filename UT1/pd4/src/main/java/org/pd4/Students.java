package org.pd4;

public class Students {
    public static void main(String[] args) {
        String[] students = new String[10];
        String studentName = "Peter Parker";
        students[0] = studentName;
        studentName = null;

        System.out.println(students[0]);
        System.out.println(studentName);
        System.out.println("");

        for (String s : students) {
            System.out.println(s);
        }
    }
}
