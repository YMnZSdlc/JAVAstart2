package pl.sda.javastart2.day6HomeWork1;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Colections1 {
    public static void main(String[] args) {
        giveMeNameAndSurnameList();
        giveMeNameAndSurnameListWithStream();


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
