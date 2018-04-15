package pl.sda.javastart2.day5enums;

import java.util.Arrays;

public class EnumExampleMain {
    public static void main(String[] args) {
        Car blackCar = new Car(ColourEnum.BLACK);
        Car whiteCar = new Car(ColourEnum.WHITE);
        Car anotherBlackCar = new Car(ColourEnum.BLACK);

        Car nextCar = null;
        for (ColourEnum elementOfColourEnum : ColourEnum.values()){
            if (elementOfColourEnum.getNumberValue()==0){
                nextCar = new Car(elementOfColourEnum);
                break;
            }
        }
        System.out.println("Nasteępny samochód: " +nextCar);


        System.out.println(blackCar.equals(anotherBlackCar));
        System.out.println(blackCar.equals(whiteCar));

        ColourEnum[] values = ColourEnum.values();
        System.out.println(Arrays.toString((values)));
    }


}
