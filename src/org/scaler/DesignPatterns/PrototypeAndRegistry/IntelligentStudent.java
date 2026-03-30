package org.scaler.DesignPatterns.PrototypeAndRegistry;

public class IntelligentStudent extends Student{
    int iq;

    IntelligentStudent(){}

    IntelligentStudent(IntelligentStudent is){
        super(is);
        this.iq = is.iq;
    }

    @Override
    public IntelligentStudent copy(){
        return new IntelligentStudent(this);
    }
}
