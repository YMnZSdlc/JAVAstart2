package pl.sda.javastart2.day7exeptions;

public class ExeptionsExample {
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3};

        SimplePositiveNumbersBox<Integer> positiveNumbersBox = new SimplePositiveNumbersBox<>(integers);
        try {
            Integer value = positiveNumbersBox.getValue(5);
        } catch (OutOfBoxExeption exc) {
            System.out.println(exc.getMessage());
        }

        try {
            positiveNumbersBox.setValue(6, -2);
        } catch (OutOfBoxExeption | RuntimeException x) {
            System.out.println(x.getMessage());
        }
        System.out.println("Koniec");

    }


    private static double divide(int x, int y) {
        return x / y;
    }

    private static double divideWitchStableResult(int x, int y) {
        try {
            System.out.println("Inside try");
            return x / y;
        } finally {
            System.out.println("Inside finally block");
            return -1; // nie umieszczaj return w finaly bo zawsze zwróci
        }
    }

    //varargs
    private static double divideManyTimes(int x, int... dividers) {
        double result = x;
        for (int divider : dividers) {
            result = x / divider;
        }
        return result;
    }


}
