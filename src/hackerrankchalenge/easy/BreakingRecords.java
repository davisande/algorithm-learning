package hackerrankchalenge.easy;

import java.util.List;

public class BreakingRecords {

    public static void main(String[] args) {
        List<Integer> scores = List.of(10, 5, 20, 20, 4, 5, 2, 25, 1);
        System.out.println(breakingRecords(scores));

        scores = List.of(3, 4, 21, 36, 10, 28, 35, 5, 24, 42);
        System.out.println(breakingRecords(scores));
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int bestScore = 0;
        int worstScore = 0;
        int countBestScore = 0;
        int countWorstScore = 0;

        for (int i = 0; i < scores.size(); i++) {
            int playScore = scores.get(i);
            if(i == 0) {
                bestScore = playScore;
                worstScore = playScore;
                continue;
            }

            if (scores.get(i) > bestScore) {
                bestScore = playScore;
                countBestScore++;
            }

            if (scores.get(i) < worstScore) {
                worstScore = playScore;
                countWorstScore++;
            }
        }

        return List.of(countBestScore, countWorstScore);
    }

}
