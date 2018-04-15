package pl.sda.javastart2.day6Generics2;

public class Box <T> {

    private T value;

    public T getValue() {
        return value;
    }

    public Box(T value) {
        this.value = value;
    }


}
