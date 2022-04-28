package algorithmsperformance.dynamicprogramming;

public class FibonacciRecursive {

    public int calculate(final int number) {
        if (number <= 1) {
            return number;
        }

        return calculate(number -1) + (number - 2);
    }

    public static void main(final String[] args) {
        final FibonacciRecursive fibonacciRecursive = new FibonacciRecursive();
        final var result = fibonacciRecursive.calculate(10);

        System.out.println(result);
    }
}
