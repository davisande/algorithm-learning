package hackerrankchalenge.easy;

import java.util.List;
import java.util.stream.IntStream;

public class DivisibleSumPairs {

    public static void main(String[] args) {
        List<Integer> ar = List.of(1, 3, 2, 6, 1, 2);
        System.out.println(divisibleSumPairs(ar.size(), 3, ar));
    }

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        return IntStream.range(0, n)
                .map(i -> checkDivisiblePairs(i, n, k, ar))
                .sum();
    }

    public static int checkDivisiblePairs(int i, int n, int k, List<Integer> ar) {
        var num1 = ar.get(i);

        long result = IntStream.range((i + 1), n)
                .map(j -> num1 + ar.get(j))
                .filter(r -> r % k == 0)
                .count();

        return Math.toIntExact(result);
    }
}
