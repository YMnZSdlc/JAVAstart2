package pl.sda.javastart2.day6HomeWork1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericHomeTest {

    @Test
    void shouldSummarizedInt() {
        List<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
        integerArrayList.add(2);
        integerArrayList.add(3);

        Double sum = GenericHome.sumValueElementsInList(integerArrayList);
        assert  sum == 6;

    }
}