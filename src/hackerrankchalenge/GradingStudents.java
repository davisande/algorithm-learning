package hackerrankchalenge;

import java.util.List;
import java.util.stream.Collectors;

public class GradingStudents {

    public static void main(String[] args) {
        List<Integer> grades = List.of(73, 67, 38, 33);
        gradingStudents(grades).forEach(System.out::println);
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        return grades.stream()
                .map(GradingStudents::roundGrade)
                .collect(Collectors.toList());
    }

    private static int roundGrade(int grade) {
        if (grade < 38) {
            return grade;
        }

        int gradeRounded = grade;
        while(gradeRounded % 5 != 0) {
            gradeRounded++;
        }

        int difference = gradeRounded - grade;
        if(difference < 3) {
            return gradeRounded;
        }

        return grade;
    }
}
