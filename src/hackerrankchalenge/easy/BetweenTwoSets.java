package hackerrankchalenge.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BetweenTwoSets {

    public static void main(String []args) {
        int result = getTotalX(List.of(2, 6), List.of(24, 36));
        System.out.println(result);

        result = getTotalX(List.of(2, 4), List.of(16, 32, 96));
        System.out.println(result);
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int sizeListA = a.size();
        int sizeListB = b.size();
        int lastNumberA = a.get(sizeListA - 1);
        int lastNumberB = b.get(sizeListB - 1);

        List<Integer> dividendsList = IntStream.rangeClosed(lastNumberA, lastNumberB)
                .boxed()
                .filter(number -> {
                    long amountFactorsA = a.stream()
                            .map(element -> number % element)
                            .filter(Integer.valueOf(0)::equals)
                            .count();

                    return sizeListA == amountFactorsA;
                })
                .collect(Collectors.toList());

        Long result = dividendsList.stream()
                .filter(number -> {
                    long amountFactorsB = b.stream()
                            .map(element -> element % number)
                            .filter(Integer.valueOf(0)::equals)
                            .count();

                    return sizeListB == amountFactorsB;
                }).count();

        return result.intValue();
    }
}
