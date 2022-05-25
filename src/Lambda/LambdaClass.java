package Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaClass {
    public static void main(String[] args) {
        List<Integer> arrList = Arrays.asList(1,2,3,4,7,5,0);

       // arrList.forEach(x-> System.out.println(x));

        Consumer<Integer> method = n -> System.out.println(n);
        arrList.forEach(method);

        //interface

        StringFunction concatString = (x) -> x + "!! ##";

        StringFunction ask = (x) -> x + "123";

        formatString("hello ",concatString );
        formatString("hello ",ask );

    }
    public static void formatString(String str, StringFunction format){
        String result = format.run(str);
        System.out.println(result);

    }
}
