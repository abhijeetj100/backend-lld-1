package org.scaler.IntroToOops;

public class Student {
    private String name;
    int age;
    protected double psp;
    public String batch;

    static int noOfStudents = 0;

    public Student(){
        noOfStudents++;
    }

    static void PrintCount(){
        System.out.println(noOfStudents);
    }

    static {
        noOfStudents++;
        System.out.println("Static block called");
    }

    {
        System.out.println("Non static block");
    }

    // Empty Constructor
//    public Student(){
//        name="Abhijeet";
//        age=25;
//        psp=20;
//        batch="xyz";
//    }

//    public Student(String name2, int a, double b, String c){
//        name = name2;
//        age = a;
//        psp = b;
//        batch = c;
//    }

    void print(){
        System.out.println("Name "+name);
    }

    void setName(String name2){
        name = name2;
    }

    String getName(){
        return name;
    }
}
