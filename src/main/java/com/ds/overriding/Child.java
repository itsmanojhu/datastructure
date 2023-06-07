package com.ds.overriding;

import java.nio.file.FileAlreadyExistsException;

public class Child extends Parent{
    public Child() {
        System.out.println("Child C");
    }
    public Double methodA() throws FileAlreadyExistsException {
        System.out.println("Child");
        return 2.0;
    }
}
