package com.haiyu.test;




/**
 * @Title: TestS
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/19 15:31
 */
public class TestS {

    /**
     *
     * static块随着类的加载而加载，但是只加载一次，
     * 是一种介于构造方法和普通方法之间的一种应用。
     */
    static {
        System.out.println("ok");
    }

    /**
     * static修饰的属性称为静态属性或者是类属性
     * static只能修饰成员属性，不能修饰局部属性。
     * static修饰的属性能够在同一个类的对象间共享。
     * static修饰的属性随着类的加载而加载，可以用类名直接访问。
     */
    static int num = 0;
    public TestS(){
        num++;
        System.out.println(num);
    }

    //定义static方法
    /**
     * static方法可以通过类的名字直接访问。
     * static方法无this，也就是说在static方法中不能使用this关键字。
     * static方法不能被非static方法覆盖。
     * static方法不能直接访问外部非static方法或属性。
     */
    public static void paint(){
        System.out.println("test");
    }

    //定义static内部类
    /**
     *static可以修饰内部类，使用static修饰的内部类自动升级为顶级类，
     * 可以直接创建对象并可以在其内部定义static方法
     */
    public static class Inner{
        //static内部类定义static方法
        public static void paint(){
            System.out.println("Inner");
        }
    }

    public static void main(String[] args) {
        TestS s = new TestS();
        TestS s1 = new TestS();
        System.out.println(TestS.num);
        TestS.paint();
        TestS.Inner.paint();
    }

}
