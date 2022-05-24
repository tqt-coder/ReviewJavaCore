package Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamStudy {
    public static void main(String[] args) {

        // method: forEach(), map(), flagMap(), filter(),limit(), collect() => toList(), join()
        // stastic: count, sum, max, min, average
        // 3 class: IntSummaryStastics, LongSummaryStastics, DoubleSummaryStatics
        List<Integer> arrList =  Arrays.asList(1,2,5,3,4,3,-100);
        arrList.stream().sorted().forEach(System.out::println);

        // practice Stastic

        DoubleSummaryStatistics doubleSummaryStatistics = arrList.stream().mapToDouble(x -> x).summaryStatistics();
        System.out.println("The min number is: "+ doubleSummaryStatistics.getMin());
        System.out.println("The max number is: " + doubleSummaryStatistics.getMax());

    }
}
