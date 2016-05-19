package com.example.lxh.test;

/**
 * * 作者：lxh on 2016/5/5 11:33
 */
public class OuterClass {

    private String language = "en";
    private String region = "US";


    public class InnerClass {
        public void printOuterClassPrivateFields() {
            String fields = "language=" + language + ";region=" + region;
            System.out.println(fields);
        }
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.printOuterClassPrivateFields();
    }
}
