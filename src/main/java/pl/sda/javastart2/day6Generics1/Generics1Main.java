package pl.sda.javastart2.day6Generics1;

public class Generics1Main {
    public static void main(String[] args) {
        firstStepInGenerics();
        secondStepInGenerics();
    }

    private static void secondStepInGenerics() {
        FruitsBox fruitsBoxOfApples = new FruitsBox(new Apple());
        FruitsBox fruitsBoxOfOranges = new FruitsBox(new Orange());
        Fruits fruitApple = fruitsBoxOfApples.getFruit();
        Fruits fruitOrange = fruitsBoxOfOranges.getFruit();

    }

    private static void firstStepInGenerics() {
        OrangeBox orangeBox = new OrangeBox(new Orange());
        AppleBox appleBox = new AppleBox(new Apple());
    }
}
