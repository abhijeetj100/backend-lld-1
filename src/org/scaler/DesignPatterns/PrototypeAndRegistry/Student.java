package org.scaler.DesignPatterns.PrototypeAndRegistry;

public class Student implements Prototype<Student>{
    private int id;
    String name;
    String batch;

    Student(){}

    Student(Student st){
        this.id = st.id;
        this.name = st.name;
        this.batch = st.batch;
    }

    @Override
    public Student copy(){
        return new Student(this);
    }
}
