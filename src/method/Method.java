package method;

public class Method {
    public static <E> void  printArray(E[] inputArray){
        for ( E element: inputArray) {
            System.out.println(element);
        }
        System.out.println();
    }
}
