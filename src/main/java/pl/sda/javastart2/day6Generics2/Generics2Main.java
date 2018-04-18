package pl.sda.javastart2.day6Generics2;

import pl.sda.javastart2.day5enums.Person;
import pl.sda.javastart2.day6Generics1.Apple;
import pl.sda.javastart2.day6Generics1.Orange;

import java.util.List;

public class Generics2Main {
    public static void main(String[] args) {
        firstGenericExample();
        secondGenericExample();

        utilsExample();
    }

    private static void secondGenericExample() {
    }

    private static void firstGenericExample() {
    }

    private static void utilsExample() {
        Long[] longsArray = {1L, 2L};
        List list = GenericsUtils.fromArrayToList(longsArray);
        Object o = list.get(0);

        List<Long> longs = GenericsUtils.fromArrayToLIstWithGenerics(longsArray);

    }
}
