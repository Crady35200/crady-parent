package com.crady;

/**
 * author:Crady
 * date:2019/1/29 10:09
 * desc:
 **/
public class Test {
    public static class Inner{


        public final static Test testInstance = new Test(3);
        static {
            System.out.println("TestInner Static!");
        }
    }

    public static Test getInstance(){
        return Inner.testInstance;
    }

    public Test(int i ) {
        System.out.println("Test " + i +" Construct! ");
    }

    static {
        System.out.println("Test Stataic");
    }
    public static Test testOut = new Test(1);


    public static void main(String args[]){
        Test t = new Test(2);
        Test.getInstance();
    }
}
