package hackerrankchalenge;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class BillDivision {

    public static void main(String[] args) {
        List<Integer> bill = List.of(3, 10, 2, 9);

        bonAppetit(bill, 1, 12);
        bonAppetit(bill, 1, 7);
    }

    public static void bonAppetit(final List<Integer> bill, final int k, final int b) {
        final int amountBoth = IntStream.range(0, bill.size())
                .filter(i -> i != k)
                .map(bill::get)
                .sum();

        final String response = Optional.of(amountBoth)
                .map(amountEachOne -> amountEachOne / 2)
                .map(amountEachOne -> b - amountEachOne)
                .filter(diffAnnaPortion -> diffAnnaPortion != 0)
                .map(Object::toString)
                .orElse("Bon Appetit");

        System.out.println(response);
    }

}
