package genericityclass.classType;

import java.util.ArrayList;
import java.util.List;

public class RunClassType {
    public static void main(String[] args) {

    }

    /**
     * 测试上边界通配符(只读模式)
     * 只能传入其的子类或者本身
     */
    public static void test1(){
       List<? extends Fruit> fruits = new ArrayList<Apple>();//正常
//       List<? extends Fruit> fruits = new ArrayList<Food>();//错误
//       只读模式
//        fruits.add(new Apple());
        Fruit fruit = fruits.get(0);
    }

    /**
     * 测试下边界（只写模式）
     *可以传入父类或者本身
     */
    public static void test2(){
//        List<? super Fruit> fruits = new ArrayList<Apple>();//错误
       List<? super Fruit> fruits = new ArrayList<Food>();//正常
//只写模式
        fruits.add(new Apple());
//        Fruit fruit = fruits.get(0);
    }

}
