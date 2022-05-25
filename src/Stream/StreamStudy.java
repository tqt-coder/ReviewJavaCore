package Stream;

import java.util.*;

public class StreamStudy {
    public static void main(String[] args) {

        // method: forEach(), map(), flagMap(), filter(),limit(), collect() => toList(), join()
        // stastic: count, sum, max, min, average
        // 3 class: IntSummaryStastics, LongSummaryStastics, DoubleSummaryStatics
        List<Integer> arrList = Arrays.asList(1, 2, 5, 3, 4, 3, -100);
        arrList.stream().sorted().forEach(System.out::println);

        List<Integer> integerList = new ArrayList<Integer>();
        Set<Integer> integerSet = new HashSet<>();

        arrList.stream().forEach(x -> {
            integerList.add(x);
            integerSet.add(x);
        });

        integerSet.forEach(x -> System.out.println(x));
        System.out.println(integerSet);
        System.out.println(integerList);


        // practice Stastic

        DoubleSummaryStatistics doubleSummaryStatistics = arrList.stream().mapToDouble(x -> x).summaryStatistics();
        Double doubleSummaryStatistics2 = arrList.stream().mapToDouble(x -> 3).sum();

        System.out.println("The min number is: " + doubleSummaryStatistics.getMin());
        System.out.println("The max number is: " + doubleSummaryStatistics.getMax());

//        arrList.stream().forEach(z -> {
//            z = z * z;
//        });

    }
}
