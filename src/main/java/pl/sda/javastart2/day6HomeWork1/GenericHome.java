package pl.sda.javastart2.day6HomeWork1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericHome {
    public static void main(String[] args) {

        List<Double> listDouble = new ArrayList<>();
        listDouble.add(5.656D);


        sumValueElementsInList(listDouble);


    }

    public static <T extends Number> Double sumValueElementsInList(List<T> list) {
        Double result = 0D;
        for (T t : list) {
            result += t.doubleValue();
        }
        return result;
    }



}
