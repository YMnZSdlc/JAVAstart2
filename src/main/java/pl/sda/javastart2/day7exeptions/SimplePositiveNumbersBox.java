package pl.sda.javastart2.day7exeptions;

import com.google.common.collect.ObjectArrays;

public class SimplePositiveNumbersBox<T extends Number> {
    private T[] numbers; //niezmienna wielkość tablicy

    public SimplePositiveNumbersBox(T[] numbers) {
        this.numbers = numbers;
    }

    //kostruktor z gwiazdką *
    public SimplePositiveNumbersBox(Class<T> tClass, int size) {
        this.numbers = ObjectArrays.newArray(tClass, size);
//        numbers = ObjectArrays.newArray(tClass, size); //to samo tylko bez this bo w tym przypadku nie jest konieczny
    }


    public void setValue(int index, T value) throws OutOfBoxExeption {
        if (value.doubleValue() < 0) {
            throw new NegativeNumberExeption("Ujemna liczba!");
        }
        if (index < 0 || index >= numbers.length) {
            throw new OutOfBoxExeption("Nie ma takiego indexu");
        }
        numbers[index] = value;
    }

    public T getValue(int index) throws OutOfBoxExeption {
        if (index < 0 || index >= numbers.length) {
            throw new OutOfBoxExeption("Nie ma takiego indexu");
        }
        return numbers[index];
    }
}
