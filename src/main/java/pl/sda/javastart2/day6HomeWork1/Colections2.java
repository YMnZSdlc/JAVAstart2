package pl.sda.javastart2.day6HomeWork1;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

public class Colections2 {
    public static void main(String[] args) {
        giveMeNameAndSurnameList();
        giveMeNameAndSurnameListWithStream();

    }

    private static Map<Double, List<Customer>> sallaryWithCustomerList() {
        List<Customer> customers = giveMeCustomers();
        Map<Double, List<Customer>> map = new HashMap<>();
        for (Customer customer : customers) {
            if (map.containsKey(customer.getSalary())) {
                List<Customer> customerInsideMap = map.get(customer.getSalary());
                customerInsideMap.add(customer);
            } else {
//                List<Customer> newList = new ArrayList<>(); //stary sposób deklaracji
//                newList.add(customer);                        //też dobry ale dłuższy
                map.put(customer.getSalary(), Lists.newArrayList(customer));// nowy sposób
                // deklaracji z użyciem biblioteki Guawa -> Lists
            }
        }
        return map;
    }

    private static List<String> giveMeNameAndSurnameListWithStream() {
        return giveMeCustomers().stream()
                .map(e -> e.getName().trim() + " " + e.getSurName().trim())
                .collect(Collectors.toList());
    }

    private static List<String> giveMeNameAndSurnameList() {
        List<Customer> customers = giveMeCustomers();
//        List<String> result = new ArrayList<>();
        List<String> result = Lists.newArrayList(); //alternatywny sposó tworzenia lisy
        for (Customer customer : customers) {
            String nameWithSurname = customer.getName().trim()
                    + " " + customer.getSurName().trim();
            result.add(nameWithSurname);
        }
        return result;
    }

    private static List<Customer> giveMeCustomers() {
        Customer[] people = new Customer[]{
                new Customer("Anna", "Nowak   ", 33, "1200"),
                new Customer("Beata", "Kowalska", 22, "1200"),
                new Customer("Marek", " Nowak", 25, "1250"),
                new Customer("Adam", "Twardowski", 33, "1100"),
                new Customer("Monika  ", "Kos", 25, "2500"),
                new Customer("Adam ", "Rudy", 45, "3333"),
                new Customer("Marek", "Rudy", 15, 2210),
                new Customer("Adam", "Madej", 15, 3333)
        };
        return Arrays.asList(people);
    }


}
