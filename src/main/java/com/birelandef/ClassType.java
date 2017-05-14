package com.birelandef;

/**
 * Created by sophie on 14/05/17.
 */
public enum ClassType {
    N("N"),
    E("E"),
    D("D"),
    C("C"),
    B("B"),
    A("A"),
    M("M"),
    I("I");
    private String className;

    ClassType(String className) {
        this.className = className;
    }

    public String getClassName(){return className;}

}
