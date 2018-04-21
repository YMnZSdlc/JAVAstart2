package pl.sda.javastart2.day7exeptions;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class TryWithResourcesExample {

    private static final Logger LOGGER =
            Logger.getLogger(TryWithResourcesExample.class.getSimpleName());

    static {
        try {
            LOGGER.addHandler(new FileHandler("c:\\logs.txt"));
        } catch (IOException e) {
            System.out.println("przykro");
        }
    }

    public static void main(String[] args) {
//        LOGGER.addHandler();
        tryWithResourcesOldWay();
        tryWithResourcesNewWay();
    }

    private static void tryWithResourcesNewWay() {
        try (MyResource myResource = new MyResource()) {
            myResource.doSomeWorl("Odczyt danych");
        } catch (Exception e) {
            LOGGER.severe("Odczyt danych po nowemu exeption");
        }
    }

    private static void tryWithResourcesOldWay() {
        MyResource myResource = new MyResource();
        try {
            myResource.doSomeWorl("Odczyt danych");
        } catch (Exception e) {
            System.out.println("Błąd przy wykonaniu zadania");
        } finally {
            try {
                myResource.close();
            } catch (Exception e) {
                System.out.println("Błąd przy zamykaniu");
            }
        }
        myResource.close();
    }


}
