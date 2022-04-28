import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static void main(final String[] args) {
        var result = Result.gradingStudents(List.of(4, 73, 67, 38, 33));

        System.out.print(result);
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        return grades.stream()
                .filter(g -> g > 4)
                .map(Result::treatGrade)
                .collect(Collectors.toList());
    }

    private static Integer treatGrade(final Integer grade) {
        return Optional.of(grade)
                .filter(Result::shouldRound)
                .map(Result::round)
                .orElse(grade);
    }

    private static Boolean shouldRound(final Integer grade) {
        return Optional.ofNullable(grade)
                .filter(g -> g >= 38)
                .filter(g -> g % 5 != 0)
                .isPresent();
    }

    private static Integer round(final Integer grade) {
        int originalDifference = 0;
        Integer roundingGrade = grade;

        while (roundingGrade % 5 != 0) {
            originalDifference++;
            roundingGrade++;
        }

        return Optional.of(originalDifference)
                .filter(od -> od >= 3)
                .map(od -> grade)
                .orElse(roundingGrade);
    }
}
