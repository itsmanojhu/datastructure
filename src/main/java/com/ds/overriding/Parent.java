package com.ds.overriding;

import java.io.IOException;

public class Parent {
    public Parent() {
        System.out.println("Parent C");
    }

    public Double methodA() throws IOException {
        System.out.println("Parent");
        return 1.0;
    }

    public static void main(String[] args)throws IOException {
        Parent p = new Child();
        System.out.println(p.methodA());
    }
}
/*public class Child extends Parent{
    public Double methodA(){
        System.out.println("Child");
        return 2.0;
    }
}*/

