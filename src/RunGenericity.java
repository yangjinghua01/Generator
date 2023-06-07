import genericityclass.Generic;
import genericityinterface.Generator;
import method.Method;

import java.util.ArrayList;

/**
 * java泛型
 * Java 泛型（generics）是 JDK 5 中引入的一个新特性, 泛型提供了编译时类型安全检测机制，该机制允许程序员在编译时检测到非法的类型。泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。Java的泛型是伪泛型，这是因为Java在编译期间，所有的泛型信息都会被擦掉，这也就是通常所说类型擦除 。泛型一般有三种使用方式:泛型类、泛型接口、泛型方法。在实例化泛型类时，必须指定T的具体类型。
 *
 * 类型擦除（java泛型的实现方法）
 * 概念
 * Java的泛型基本上都是在编译器这个层次上实现的，在生成的字节码中是不包含泛型中的类型信息的，使用泛型的时候加上类型参数，在编译器编译的时候会去掉，这个过程成为类型擦除。如在代码中定义List和List等类型，在编译后都会变成List，JVM看到的只是List，而由泛型附加的类型信息对JVM是看不到的。Java编译器会在编译时尽可能的发现可能出错的地方，但是仍然无法在运行时刻出现的类型转换异常的情况，类型擦除也是Java的泛型与C++模板机制实现方式之间的重要区别。
 *
 * 类型擦除例子
 * 1、原始类型相等
 * 定义两个ArrayList数组，不过一个是ArrayList泛型类型的，只能存储字符串；一个是ArrayList泛型类型的，只能存储整数，最后，我们通过list1对象和list2对象的getClass()方法获取他们的类的信息，最后发现结果为true。说明泛型类型String和Integer都被擦除掉了，只剩下原始类型。
 * 2、通过反射添加其他类型元素
 * 在程序中定义了一个ArrayList泛型类型实例化为Integer对象，如果直接调用add()方法，那么只能存储整数数据，不过当我们利用反射调用add()方法的时候，却可以存储字符串，这说明了Integer泛型实例在编译之后被擦除掉了，只保留了原始类型。
 *
 * 原始类型
 * 原始类型 就是擦除去了泛型信息，最后在字节码中的类型变量的真正类型，无论何时定义一个泛型，相应的原始类型都会被自动提供，类型变量擦除，并使用其限定类型（无限定的变量用Object）替换。
 *
 * 泛型变量的类型
 * 在调用泛型方法时，可以指定泛型，也可以不指定泛型。
 *
 * 在不指定泛型的情况下，泛型变量的类型为该方法中的几种类型的同一父类的最小级，直到Object
 * 在指定泛型的情况下，该方法的几种类型必须是该泛型的实例的类型或者其子类
 */
public class RunGenericity {
    public static void main(String[] args) {
//        实例化泛型类
        Generic<String> generic = new Generic<>("2122");
//泛型方法
        Integer[] intarr ={1,2,2};
        String[] strarr = {"a","s","b"};
        Method.printArray(intarr);
        Method.printArray(strarr);

        /**不指定泛型的时候*/
        int i = add(1, 2); //这两个参数都是Integer，所以T为Integer类型
        Number f = add(1, 1.2); //这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Number
        Object o = add(1, "asd"); //这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Object

        /**指定泛型的时候*/
        int a = RunGenericity.<Integer>add(1, 2); //指定了Integer，所以只能为Integer类型或者其子类
        int b = RunGenericity.<Integer>add(1, 2.2); //编译错误，指定了Integer，不能为Float
        Number c = RunGenericity.<Number>add(1, 2.2); //指定为Number，所以可以为Integer和Float


//        类型擦除
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("abc");
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(123);
        System.out.println(list1.getClass() == list2.getClass());// ------>这段代码执行为Ture


    }
    //这是一个简单的泛型方法
    public static <T> T add(T x,T y){
        return y;
    }
}
//        实现泛型接口不指定类型
class GeneratorImpl<T> implements Generator<T>{

    @Override
    public T method() {
        return null;
    }
}
//实现泛型接口指定类型
class GeneratorImpl1 implements Generator<String>{

    @Override
    public String method() {
        return "111";
    }
}