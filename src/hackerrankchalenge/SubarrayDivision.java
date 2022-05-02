package hackerrankchalenge;

import java.util.List;
import java.util.stream.IntStream;

public class SubarrayDivision {

    public static void main(String[] args) {
        List<Integer> s = List.of(1, 2, 1, 3, 2);
        int d = 3;
        int m = 2;
        System.out.println(birthday(s, d, m));

        s = List.of(1, 1, 1, 1, 1, 1);
        System.out.println(birthday(s, d, m));

        s = List.of(4);
        d = 4;
        m = 1;
        System.out.println(birthday(s, d, m));
    }

    public static int birthday(List<Integer> s, int d, int m) {
        int waysDivision = 0;
        int squares = s.size();

        if (squares < m) {
            return waysDivision;
        }

        for (int i = 0; i < squares; i++) {
            if (i < (m - 1)) {
                continue;
            }

            int firstIndexSubList = i - (m - 1);
            int amountSquares = IntStream.rangeClosed(firstIndexSubList, i)
                    .parallel()
                    .map(s::get)
                    .sum();

            if (amountSquares == d) {
                waysDivision++;
            }
        }

        return waysDivision;
    }

}
