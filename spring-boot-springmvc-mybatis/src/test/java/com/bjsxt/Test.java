package com.bjsxt;

/**
 * @author lvyelanshan
 * @create 2019-11-20 8:42
 */
public class Test {

    StringBuilder str = new StringBuilder("good");

    char [] ch={'a','b','c'};
    int[] arr={1,2,3};

    public static void main(String[] args) {
        Test ex=new Test();

        //string类有重写toString方法所以，打印的是字符串而不是地址
        System.out.println(ex.str);
        //输出流System.out是PrintStream对象，PrintStream有多个重载的println方法
        //其中一个就是public void println(char[] x)
        //直接打印字符数组的话，不像int[]等其他数组，它会直接调用这个方法来打印，因而可以打印出数组内容，而不是地址。
        System.out.println(ex.ch);
        //打印整型数组的时候调用的是重载的方法public void println(Object x),所以打印的是对象
        System.out.println(ex.arr);

        ex.change(ex.str, ex.ch);
        System.out.println("方法后的String："+ex.str);
        System.out.println("方法后的ch："+ex.ch);
        System.out.print(ex.str+"and");
        System.out.print(ex.ch);
    }
    public void change(StringBuilder s,char sh[]){
        System.out.println(s);
        //这里的s相当于形参，原本的s是指向“good”这里将这个副本s指向了"test ok"
        System.out.println("方法体内的str:"+s);
        //这里的sh也是形参，将原本的ch[]的引用传递给sh[],指向的是堆中的同一堆空间
        sh[0]='g';
    }
}
