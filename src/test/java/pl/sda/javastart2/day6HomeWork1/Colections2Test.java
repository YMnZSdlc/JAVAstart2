package pl.sda.javastart2.day6HomeWork1;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Colections2Test {

    @Test
    void nameSalaryStatsTest() {
       Map<String,Map<Double,Integer>> nameSlaryStats = Colections2.nameSalaryStats();

       Map<Double,Integer> integerMap = nameSlaryStats.get("Adam");
       Integer counter = integerMap.get(3333.0);
       assert counter == 1;

    }
}