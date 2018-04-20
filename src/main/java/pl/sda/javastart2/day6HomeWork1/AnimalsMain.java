package pl.sda.javastart2.day6HomeWork1;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import static com.sun.jmx.snmp.ThreadContext.contains;

public class AnimalsMain {
    public static void main(String[] args) {

        String[] animals = new String[]{"cat", "dog ", "mouse", "rat", "pig",
                "rabbit", "hamster", " ", "parrot", "cat", "", "dog", "cat",
                "  pig", "dog"};


//        ArrayToListNoTabLoop(animals);
//        ArrayToListNoTabStringOrderLoop(animals);
//        ArrayToListNoTabStringOrderNoDuplicateLoop(animals);
//        ArrayToListNoTabNoDuplicateLoop(animals);
//        ArrayToSetArrayOrderNoDuplicateLoop(animals);
//        findElementInArrayToListLoop(animals);

//        ArrayToListNoTabStream (animals);
//        ArrayToListNoTabStringOrderStream(animals);
//        ArrayToListNoTabStringOrderNoDuplicateStream(animals);
//        ArrayToListNoTabNoDuplicateStream(animals);
//        ArrayToSetArrayOrderNoDuplicateStream(animals);
//        LastMethodFormTaskStram(animals);

        printArray(animals);
//        System.out.println(ArrayToListNoTabArrayOrderLoop(animals));
//        System.out.println(ArrayToListNoTabStringOrderLoop(animals));
//        System.out.println(ArrayToListNoTabStringOrderNoDuplicateLoop(animals));
//        System.out.println(ArrayToListNoTabNoDuplicateLoop(animals));
//        System.out.println(ArrayToSetArrayOrderNoDuplicateLoop(animals));
//        System.out.println("Ile jest dog: "+ howManyElementInArrayToListLoop(animals, "dog"));
//        System.out.println("Ile jest cat: "+ howManyElementInArrayToListLoop(animals, "cat"));
//        System.out.println("Ile jest pig: "+ howManyElementInArrayToListLoop(animals, "pig"));
//        System.out.println("Ile jest rabbit: "+ howManyElementInArrayToListLoop(animals, "rabbit"));
//        System.out.println("Ile jest olifant: "+ howManyElementInArrayToListLoop(animals, "olifant"));
        System.out.println(ArrayToListNoTabArrayOrderStream(animals));
        System.out.println(ArrayToListNoTabStringOrderStream(animals));
        System.out.println(ArrayToListNoTabStringOrderNoDuplicateStream(animals));
        System.out.println(ArrayToListNoTabNoDuplicateStream(animals));
        System.out.println(ArrayToSetArrayOrderNoDuplicateStream(animals));

    }

    private static void printArray(String[] animals) {
        int i = 1;
        System.out.println("Tablica \"animals\":");
        for (String animal : animals) {
            System.out.print((i == 1 ? "[" : "") + animal + (i < animals.length ? ", " : "]\n"));
            i++;
        }
    }

    private static List<String> ArrayToListNoTabArrayOrderStream(String[] animalsArray) {
        List<String> result = Arrays.stream(animalsArray)
                .map(e -> e.replaceAll("[- ]", ""))
                .filter(e -> !e.equals(""))
                .collect(Collectors.toList());
        return result;
    }

    private static List<String> ArrayToListNoTabStringOrderStream(String[] animalsArray) {
        List<String> result = Arrays.stream(animalsArray)
                .map(e -> e.replaceAll("[- ]", ""))
                .filter(e -> !e.equals(""))
                .sorted()
                .collect(Collectors.toList());
        return result;
    }

    private static List<String> ArrayToListNoTabStringOrderNoDuplicateStream(String[] animalsArray) {
        List<String> result = Arrays.stream(animalsArray)
                .map(e -> e.replaceAll("[- ]", ""))
                .filter(e -> !e.equals(""))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        return result;
    }

    private static List<String> ArrayToListNoTabNoDuplicateStream(String[] animalsArray) {
        List<String> result = Arrays.stream(animalsArray)
                .map(e -> e.replaceAll("[- ]", ""))
                .filter(e -> !e.equals(""))
                .distinct()
                .collect(Collectors.toList());
        return result;
    }

    private static Set<String> ArrayToSetArrayOrderNoDuplicateStream(String[] animalsArray) {
        Set<String> result = new LinkedHashSet<>();
        result = Arrays.stream(animalsArray)
                .map(e -> e.replaceAll("[- ]", ""))
                .filter(e -> !e.equals(""))
                .distinct()
                .collect(Collectors.toSet());
        return result;
    }


    private static List<String> ArrayToListNoTabArrayOrderLoop(String[] animalsArray) {
        List<String> result = new ArrayList<>();
        for (String animal : animalsArray) {
            if (animal.trim().length() >= 1) {
                result.add(animal.trim());
            }
        }
        return result;
    }

    private static List<String> ArrayToListNoTabStringOrderLoop(String[] animalsArray) {
        List<String> result = new ArrayList<>();
        result = ArrayToListNoTabArrayOrderLoop(animalsArray);
        Collections.sort(result);
        return result;
    }

    private static List<String> ArrayToListNoTabStringOrderNoDuplicateLoop(String[] animalsArray) {
        List<String> result = new ArrayList<>();
        result = ArrayToListNoTabNoDuplicateLoop(animalsArray);
        Collections.sort(result);
        return result;
    }

    private static List<String> ArrayToListNoTabNoDuplicateLoop(String[] animalsArray) {
        List<String> result = new ArrayList<>();
        for (String animal : animalsArray) {
            if (animal.trim().length() >= 1) {
                if (!result.contains(animal.trim())) {
                    result.add(animal.trim());
                }
            }
        }
        return result;
    }

    private static Set<String> ArrayToSetArrayOrderNoDuplicateLoop(String[] animalsArray) {
        Set<String> result = new LinkedHashSet<>();
        for (String animal : animalsArray) {
            if (animal.trim().length() >= 1) {
                result.add(animal.trim());
            }
        }
        return result;
    }

    private static int howManyElementInArrayToListLoop(String[] animals, String stringToCount) {
        List<String> result = new ArrayList<>();
        result = ArrayToListNoTabArrayOrderLoop(animals);
        int howMany = 0;
        for (String s : result) {
            if (s.equals(stringToCount)) {
                howMany += 1;
            }
        }
        return howMany;
    }
}
