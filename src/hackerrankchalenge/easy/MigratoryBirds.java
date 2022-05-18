package hackerrankchalenge.easy;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MigratoryBirds {

    public static void main(String[] args) {
        List<Integer> arr = List.of(1, 4, 4, 4, 5, 3);
        System.out.println(migratoryBirds(arr));

        arr = List.of(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4);
        System.out.println(migratoryBirds(arr));
    }

    public static int migratoryBirds(List<Integer> arr) {
        Map<Object, Long> groupedSightings = arr.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        int maxSightings = groupedSightings.values().stream()
                .mapToInt(Math::toIntExact)
                .max()
                .orElse(0);

        return groupedSightings.entrySet().stream()
                .filter(e -> Math.toIntExact(e.getValue()) == maxSightings)
                .map(Map.Entry::getKey)
                .mapToInt(k -> (Integer) k)
                .min()
                .orElse(0);
    }


}
