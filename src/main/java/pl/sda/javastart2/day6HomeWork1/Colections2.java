package pl.sda.javastart2.day6HomeWork1;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;


import java.util.*;
import java.util.stream.Collectors;

public class Colections2 {
    public static void main(String[] args) {
//        giveMeNameAndSurnameList();
//        giveMeNameAndSurnameListWithStream();
//        SalaryStats();
//        nameSalaryStats();

        Map<String, Map<Double, Integer>> nameSalaryStats = nameSalaryStats();
        iterateOverMap(nameSalaryStats);
    }

    private static void iterateOverMap(Map<String, Map<Double, Integer>> nameSalaryStats) {
        for (String name : nameSalaryStats.keySet()) {
            System.out.println(name);
        }
        System.out.println("+------------------------------------------");
        for (Map<Double, Integer> integerMap : nameSalaryStats.values()) {
            System.out.println(integerMap);
        }

        System.out.println("+------------------------------------------");
        for (Map.Entry<String, Map<Double, Integer>> mapEntry : nameSalaryStats.entrySet()) {
            System.out.println(mapEntry);
        }
    }

    private static Map<Double, Integer> SalaryStats() {
        List<Customer> customers = giveMeCustomers();
        Map<Double, Integer> map = new HashMap<>();
        for (Customer customer : customers) {
            if (map.containsKey(customer.getSalary())) {
                Integer counter = map.get(customer.getSalary());
                map.replace(customer.getSalary(), counter + 1);
            } else {
                map.replace(customer.getSalary(), 1);
            }
        }
        return map;
    }

    protected static Map<String, Map<Double, Integer>> nameSalaryStats() {
        List<Customer> customers = giveMeCustomers();
        customers.stream().forEach(e -> e.setName(e.getSurName().trim()));
        Map<String, Map<Double, Integer>> resultMap = Maps.newHashMap();
        for (Customer customer : customers) {
            if (resultMap.containsKey(customer.getName())) {
                Map<Double, Integer> innerMap = resultMap.get(customer.getName());
                if (innerMap.containsKey(customer.getSalary())) {
                    Integer counter = innerMap.get(customer.getSalary());
                    innerMap.replace(customer.getSalary(), counter + 1);
                } else {
                    innerMap.put(customer.getSalary(), 1);
                }
            } else {
                Map<Double, Integer> newMap = Maps.newHashMap();
                newMap.put(customer.getSalary(), 1);
                resultMap.put(customer.getName(), newMap);
            }
        }
        return resultMap;
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
