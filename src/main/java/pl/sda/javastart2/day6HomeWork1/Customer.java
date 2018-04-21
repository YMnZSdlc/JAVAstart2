package pl.sda.javastart2.day6HomeWork1;


public class Customer {
    private static int counter = 1;

    private int id;
    private String name;
    private String surName;
    private int age;
    private int salary;


    public Customer(String name, String surName, int age, String salary) {
        this(name, surName, age, Integer.parseInt(salary));
//        this.id = counter++;
//        this.name = name;
//        this.surName = surName;
//        this.age = age;
//        this.salary =Integer.parseInt(salary); //"3000" zmieni na liczbę 3000
    }

    public Customer(String name, String surName, int age, int salary) {
        this.id = counter++;
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}