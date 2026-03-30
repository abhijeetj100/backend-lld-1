package org.scaler.DesignPatterns.PrototypeAndRegistry;

public class Client {
    static void doSomething(Student s){
//        Student st2 = new Student(s);
        Student st2 = s.copy(); // Runtime Polymorphism
    }

    public static void fillRegistry(StudentRegistry stR){
        Student st = new Student();
        st.batch = "Test";
        st.name = "ScalerStudent";
        stR.register("Student", st);

        IntelligentStudent ist = new IntelligentStudent();
        stR.register("IntelligentStudent", ist);

    }

    public static void main(String[] args) {
//        Student st = new Student();
//        st.batch = "Test";
//        st.name="ScalerStudent";
//
////        doSomething(st); // creates a Student type object
//
//        IntelligentStudent ist = new IntelligentStudent();
//        doSomething(ist); // still creates a Student type object, not an IntelligentStudent type object


        StudentRegistry stR = new StudentRegistry();
        fillRegistry(stR);

        Student ist = stR.get("IntelligentStudent"); // will return IntelligentStudent type



    }
}
