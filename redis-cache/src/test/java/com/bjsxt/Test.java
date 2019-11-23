package com.bjsxt;

/**
 * @author lvyelanshan
 * @create 2019-11-23 8:38
 */
public class Test {
    public static void main(String[] args) {
        String s = new String("leijianwei");
        String s2 = new String("leijianwei");
        String s3 = new String("leijianwei");
        System.out.println(s.getClass().getName() + "@" + Integer.toHexString(s.hashCode()));
        System.out.println(s2.getClass().getName() + "@" + Integer.toHexString(s2.hashCode()));
        System.out.println();




    }
}
