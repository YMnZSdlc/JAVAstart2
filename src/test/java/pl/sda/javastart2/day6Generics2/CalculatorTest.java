package pl.sda.javastart2.day6Generics2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void shouldAddCorrectly() {
        int sum = Calculator.add(1, 2);
        assert  sum ==3;
    }

    @Test
    void shouldAddCorrectlyNegativeNumbers() {
        int sum = Calculator.add(1, -2);
        assert  sum ==-1;
    }


}