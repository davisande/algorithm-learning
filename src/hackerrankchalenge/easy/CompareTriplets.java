package hackerrankchalenge.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CompareTriplets {

    public static void main(String[] args) {
        List<Integer> annaTriplets = List.of(5, 6, 7);
        List<Integer> bobTriplets = List.of(3, 6, 10);
        System.out.println(compareTriplets(annaTriplets, bobTriplets));

        annaTriplets = List.of(17, 28, 30);
        bobTriplets = List.of(99, 16, 8);
        System.out.println(compareTriplets(annaTriplets, bobTriplets));
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        final List<Integer> points = new ArrayList<>() {{
            add(0);
            add(0);
        }};

        IntStream.rangeClosed(0, 2)
                .forEach(i -> {
                    int currentPoint;
                    if(a.get(i) > b.get(i)) {
                        currentPoint = points.get(0);
                        points.set(0, ++currentPoint);
                    } else if (a.get(i) < b.get(i)) {
                        currentPoint = points.get(1);
                        points.set(1, ++currentPoint);
                    }
                });

        return points;
    }

}
