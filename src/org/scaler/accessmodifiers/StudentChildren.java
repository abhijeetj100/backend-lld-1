package org.scaler.accessmodifiers;

import org.scaler.IntroToOops.Student;

public class StudentChildren extends Student {
    public void Test(){
        System.out.println(super.psp);
        System.out.println(psp); // keep on search every parent then its parent and so on


    }
}
