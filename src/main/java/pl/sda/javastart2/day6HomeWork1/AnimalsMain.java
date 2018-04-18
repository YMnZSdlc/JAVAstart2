package pl.sda.javastart2.day6HomeWork1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnimalsMain {
    public static void main(String[] args) {

        String[] animals = new String[]{"cat", "dog ", "mouse", "rat", "pig",
                "rabbit", "hamster", " ", "parrot", "cat", "", "dog", "cat",
                "  pig", "dog"};


        ArrayToListNoTabLoop(animals);
        ArrayToListNoTabStringOrderLoop(animals);
//        ArrayToListNoTabStringOrderNoDuplicateLoop(animals);
//        ArrayToListNoTabNoDuplicateLoop(animals);
//        ArrayToSetArrayOrderNoDuplicateLoop(animals);
//        LastMethodFormTaskLoop(animals);
//
//        ArrayToListNoTabStream (animals);
//        ArrayToListNoTabStringOrderStream(animals);
//        ArrayToListNoTabStringOrderNoDuplicateStream(animals);
//        ArrayToListNoTabNoDuplicateStream(animals);
//        ArrayToSetArrayOrderNoDuplicateStream(animals);
//        LastMethodFormTaskStram(animals);

        printArray(animals);
        System.out.println(ArrayToListNoTabLoop(animals));


    }

    private static List<String> ArrayToListNoTabStringOrderLoop(String[] animals) {
        List <String> orderResult = new ArrayList<>();
        return(ArrayToListNoTabLoop(animals));

    }

    private static List<String> ArrayToListNoTabLoop(String[] animalsArray) {
        List<String> result = new ArrayList<>();
        for (String animal : animalsArray) {
            if (animal.trim().length() >= 1) {
                result.add(animal.trim());
            }
        }
        return result;
    }

    private static void printArray(String[] animals) {
        int i = 1;
        System.out.println("Tablica \"animals\":");
        for (String animal : animals) {
            System.out.print((i == 1 ? "[" : "") + animal + (i < animals.length ? ", " : "]\n"));
            i++;
        }
    }
}
