package pl.sda.javastart2.day5Colection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedList {
    private static List<Integer> arrayList = new ArrayList<>();
    private static List<Integer> linkedList = new LinkedList<>();


    public static void main(String[] args) {
        arrayListCompareToLinkedList();

    }

    private static void arrayListCompareToLinkedList() {
        int howManyTimes = 50_000;
        addAtEnd(howManyTimes, linkedList);
        addAtEnd(howManyTimes, arrayList);

        addAtStart(howManyTimes, linkedList);
        addAtStart(howManyTimes, arrayList);

        sumAllElementsUsedForEach(linkedList);
        sumAllElementsUsedForEach(arrayList);

        sumAllElementsUsedForI(linkedList);
        sumAllElementsUsedForI(arrayList);
    }

    private static void sumAllElementsUsedForI(List<Integer> list) {
        long start = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        long finish = System.currentTimeMillis();
        System.out.println("Wykonanie sumowania po indeksie z for i trwało: "
                + (finish - start)
                + "ms dla "
                + list.getClass().getSimpleName()
                + "Suma to: " + sum);
    }

    private static void sumAllElementsUsedForEach(List<Integer> list) {
        long start = System.currentTimeMillis();
        int sum = 0;
        for (Integer elementFormList : list) {
            sum += elementFormList;
        }
        long finish = System.currentTimeMillis();
        System.out.println("Wykonanie sumowania po indeksie z for each trwało: "
                + (finish - start)
                + "ms dla "
                + list.getClass().getSimpleName()
                + "Suma to: " + sum);

    }

    private static void addAtStart(int howManyTimes, List<Integer> list) {
        long start = System.currentTimeMillis();
        //czas liczony o  1 sycznia 1970r w milisekundach
        for (int i = 0; i < howManyTimes; i++) {
            list.add(0, i);
        }
        long finish = System.currentTimeMillis();
        System.out.println("Wykonanie wstawiania na początek trwało: "
                + (finish - start)
                + "ms dla "
                + list.getClass().getSimpleName());
    }


    private static void addAtEnd(int howManyTimes, List<Integer> list) {
        long start = System.currentTimeMillis();
        //czas liczony o  1 sycznia 1970r w milisekundach
        for (int i = 0; i < howManyTimes; i++) {
            list.add(i);
        }
        long finish = System.currentTimeMillis();
        System.out.println("Wykonanie wstawiania na koniec trwało: "
                + (finish - start)
                + "ms dla "
                + list.getClass().getSimpleName());
    }
}
