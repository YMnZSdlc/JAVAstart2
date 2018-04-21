package pl.sda.javastart2.day5Colection;

import pl.sda.javastart2.day5enums.Person;

import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.stream.Collectors;

public class ArrayListExample {
    public static void main(String[] args) {
//        basicListOperaton();
//        doesContainAll();
//        sortList();

        legacyUseOfIteration();


    }
// stary sposób iteracji po kolekcji List
    private static void legacyUseOfIteration() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        System.out.println(arrayList);
        // stara metod
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
        //nowsza lepsza
        for (String s : arrayList) {
            System.out.println(s);
        }
        // najnowsza na strimach
        arrayList.stream()
                .forEach(e-> System.out.println(e));

    }

    private static void sortList() {
        ArrayList<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        list.add(3L);

        list.sort(Comparator.naturalOrder());

        Collections.sort(list);

        System.out.println(list);

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(100, "Ania"));
        people.add(new Person(400, "Tomek"));
        people.add(new Person(200, "Marta"));
        people.add(new Person(300, "Adam"));

        Collections.sort(people);
        System.out.println(people);

        String result = people.stream()
//                .sorted(Comparator.comparing(Person::getPesel)) //inny sposób sortowania po pesel
                .sorted((a, b) -> a.getPesel().compareTo(b.getPesel())) //strumień ludzi z podaniem przepisu na porównanie pesel
                .map(e -> e.getName()) //zmiana typu z Person na String ale już imiona
                .collect(Collectors.joining(", "));
        System.out.println(result);

//        Wszystko co implementuje Collection umożliwia korzystanie ze stream. Stream to otwarcie potoku danych.
        List<Integer> pesels =
                people.stream() //strumień ludzi z listy people
                        .filter(person -> !person.getName().equals("Adam"))
                        .sorted((firstPerson, secondPerson) -> firstPerson.getName().compareTo(secondPerson.getName()))
                        .map(person -> person.getPesel()) //zmiana typu (opcjonalna) na String
                        .collect(Collectors.toList()); //collect czyli zbieranie do listy toList przy pomocy Collectors
        System.out.println(pesels);     //collect jest funkcją kończącą strima, są też inne jak foreach


    }

    private static void doesContainAll() {
        ArrayList<String> firstList = new ArrayList<>();
        firstList.add("1");
        firstList.add("2");
        firstList.add("3");

        ArrayList<String> secondList = new ArrayList<>();
        secondList.add("1");
        secondList.add("2");

        System.out.println(firstList.containsAll(secondList));

        secondList.add("3");

        System.out.println(firstList.containsAll(secondList));

        secondList.add("4");

        System.out.println(firstList.containsAll(secondList));
        System.out.println(secondList.containsAll(firstList));

        System.out.println("Pierwsza lista: " + firstList);
        System.out.println("Druga lista: " + secondList);

        Collections.swap(firstList, 1, 2);
        System.out.println("Pierwsza lista: " + firstList);
        System.out.println("Druga lista: " + secondList);

    }

    private static void basicListOperaton() {
        //        ArrayList<String> firstList = new ArrayList<>(); //niefajnie
        List<String> firstList = new ArrayList<>();

//        System.out.println("Is list empty? "+firstList.isEmpty());
//        System.out.println("List size: " + firstList.size());

        firstList.add("JAVA");
        firstList.add("C++");
        firstList.add("PERL");
        firstList.add("PYTHON");

//        System.out.println(firstList.toString());
//        System.out.println("Element at index 3: " + firstList.get(3));
//        System.out.println("Does contain PERL? " + firstList.contains("PERL"));
        firstList.add(1, "JAVASCRIPT");
//        System.out.println("After JAVASCRIPT added:" + firstList);

//        System.out.println("Is list empty? "+firstList.isEmpty());
//        System.out.println("List size: " + firstList.size());

        firstList.remove("JAVA");
        System.out.println("After \"JAVA\" remove: " + firstList);

        for (String obiekty : firstList) {
            System.out.println(obiekty);
        }

        firstList.stream().forEach(e -> System.out.println(e));
        //        |stream         |      |lambda             |

        for (String value : firstList) {
            boolean lastItem = firstList.indexOf(value) + 1 == firstList.size();
            System.out.print(value
                    + (lastItem ? "" : ", "));
        }

        System.out.println();

        String collect = firstList.stream().collect(Collectors.joining(", "));
        System.out.println(collect);
    }
}
