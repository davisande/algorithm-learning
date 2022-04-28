package hackerrankchalenge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AppleOrange {

    public static void countApplesAndOrangesOptimized(int s, int t, int a, int b,
                                             List<Integer> apples, List<Integer> oranges) {
        Long numberApplesLandHouse = getFruitsHouseRegionOptimized(s, t, a, apples);
        Long numberOrangesLandHouse = getFruitsHouseRegionOptimized(s, t, b, oranges);

        System.out.println(numberApplesLandHouse);
        System.out.println(numberOrangesLandHouse);
    }

    private static long getFruitsHouseRegionOptimized(int s, int t, int treePosition,
                                                      List<Integer> fruitsPositions) {
        return fruitsPositions.stream()
                .map(distance -> treePosition + distance)
                .filter(landLocal -> landLocal >= s && landLocal <= t)
                .count();
    }

    public static void countApplesAndOranges(int s, int t, int a, int b,
                                             List<Integer> apples, List<Integer> oranges) {
        List<Integer> applesLands = calculateFruitLands(a, apples);

        List<Integer> orangesLands = calculateFruitLands(b, oranges);

        List<Integer> houseRegion = IntStream.rangeClosed(s, t)
                .boxed()
                .collect(Collectors.toList());

        Long numberApplesLandHouse = getFruitsHouseRegion(houseRegion, applesLands);
        Long numberOrangesLandHouse = getFruitsHouseRegion(houseRegion, orangesLands);

        System.out.println(numberApplesLandHouse);
        System.out.println(numberOrangesLandHouse);
    }

    private static List<Integer> calculateFruitLands(int treeLocalization, List<Integer> fruitLocalization) {
        return fruitLocalization.stream()
                .map(distance -> treeLocalization + distance)
                .collect(Collectors.toList());
    }

    private static long getFruitsHouseRegion(List<Integer> houseRegion, List<Integer> fruitsLands) {
        return fruitsLands.stream()
                .filter(houseRegion::contains)
                .count();
    }

}
