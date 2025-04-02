package org.pd7;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String s = "1";
        while (!s.equals("1000")) {
            s += "0";
        }
        System.out.println(s);
    }
}