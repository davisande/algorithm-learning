package algorithmsperformance.dynamicprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveItem {

    public static void main (String[] args) {
        Integer array[]= {3,4,5,11,3,4};

        List<Integer> withDupe = Arrays.asList(array);
        List<Integer> withoutDupe = withDupe.stream().distinct().collect(Collectors.toList());
        System.out.println("List without duplicates: " + withoutDupe);

        Set<Integer> numbers = Set.copyOf(withDupe);
        System.out.println("List without duplicates: " + numbers);
    }
}
