package pl.sda.javastart2.day6Generics2;

public class GenericFruitBox<T> {

    private T value;

    public T getValue() {
        return value;
    }

    public GenericFruitBox(T value) {
        this.value = value;
    }


}
