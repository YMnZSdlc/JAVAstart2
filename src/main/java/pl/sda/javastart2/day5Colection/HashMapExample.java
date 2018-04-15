package pl.sda.javastart2.day5Colection;

import com.sun.javafx.collections.MappingChange;
import pl.sda.javastart2.day5enums.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args) {
        basicMapOperations();
    }

    private static void basicMapOperations() {
        Person ania = new Person(123, "Ania");
        Person ola = new Person(234, "Ola");
        Person tomek1 = new Person(345, "Tomek");
        Person tomek2 = new Person(456, "Tomek");

        Map<Integer, Person> peopleByPesel = new HashMap<>();

        peopleByPesel.put(ania.getPesel(),ania);
        peopleByPesel.put(ola.getPesel(),ola);
        peopleByPesel.put(tomek1.getPesel(),tomek1);
        peopleByPesel.put(tomek2.getPesel(),tomek2);

        System.out.println(peopleByPesel);

        Map<String, Person> peopleByName = new HashMap<>();
        peopleByName.put(ania.getName(), ania);
        peopleByName.put(ola.getName(), ola);
        peopleByName.put(tomek1.getName(), tomek1);
        peopleByName.put(tomek2.getName(), tomek2);

        System.out.println(peopleByName); //tylko 3 wartośći

        properWayOfAddingPeople(ania);
        properWayOfAddingPeople(ania);
        properWayOfAddingPeople(ola);
        properWayOfAddingPeople(tomek1);
        properWayOfAddingPeople(tomek2);

    }

    private static void properWayOfAddingPeople(Person person) {
        Map<String, List<Person>> mapisko = new HashMap<>();
        if (mapisko.containsKey(person.getName())){
            List<Person> people = mapisko.get(person.getName());
            people.add(person);
        }else{
            List<Person>people=new ArrayList<>();
            people.add(person);
            mapisko.put(person.getName(),people);
        }
        System.out.println(mapisko); //tylko 3 wartości
    }
}
