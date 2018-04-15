package pl.sda.javastart2.day5enums;

public class Person implements Comparable<Person>{
    private Integer pesel;
    private String name;

    public Person(Integer pesel, String name) {
        this.pesel = pesel;
        this.name = name;
    }

    @Override
    public int compareTo (Person o){
        return pesel.compareTo(o.getPesel());
    }


    public Integer getPesel() {
        return pesel;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pesel=" + pesel +
                ", name='" + name + '\'' +
                '}';
    }
}
