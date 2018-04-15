package pl.sda.javastart2.day5Colection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListVsSet {

    public static void main(String[] args) {
        removeAllCompare();
    }

    private static void removeAllCompare() {
        setRemoveList();
        listRemoveSet();

        checkIfCollectionContains();

    }

    private static void checkIfCollectionContains() {
        Set<Book> booksSet = new HashSet<>();
        int howManyBooks = 100_000;
        for (int i = 0; i < howManyBooks; i++) {
            booksSet.add(new Book(i));
        }
        List<Book> booksList = new ArrayList();

        for (int i = 0; i < howManyBooks; i++) {
            booksList.add(new Book(i));
        }

        long start = System.currentTimeMillis();
        booksList.contains(new Book(howManyBooks));
        long finish = System.currentTimeMillis();
        long start2 = System.currentTimeMillis();
        booksSet.contains(new Book(howManyBooks));
        long finish2 = System.currentTimeMillis();

        System.out.println("List" + (finish - start) + " Set: " + (finish2 - start2));
    }

    private static void listRemoveSet() {
        Set<Book> booksSet = new HashSet<>();
        int howManyBooks = 100_000;
        for (int i = 0; i < howManyBooks; i++) {
            booksSet.add(new Book(i));
        }
        List<Book> booksList = new ArrayList();

        for (int i = 0; i < howManyBooks; i++) {
            booksList.add(new Book(i));
        }

        long start = System.currentTimeMillis();
        booksList.removeAll(booksSet);
        long finish = System.currentTimeMillis();
        System.out.println("booksList.removeAll(booksSet)"
                + (finish - start));
    }

    private static void setRemoveList() {
        Set<Book> booksSet = new HashSet<>();
        int howManyBooks = 100_000;
        for (int i = 0; i < howManyBooks; i++) {
            booksSet.add(new Book(i));
        }
        List<Book> booksList = new ArrayList();

        for (int i = 0; i < howManyBooks; i++) {
            booksList.add(new Book(i));
        }

        long start = System.currentTimeMillis();
        booksSet.removeAll(booksList);
        long finish = System.currentTimeMillis();
        System.out.println("booksSet.removeAll(booksList)"
                + (finish - start));
    }
}
