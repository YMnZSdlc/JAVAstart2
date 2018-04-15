package pl.sda.javastart2.day6Generics2;

import org.omg.CORBA.Object;

import java.util.Arrays;
import java.util.List;

public class GenericsUtils {
    public static List fromArrayToList(java.lang.Object[] array){
        return Arrays.asList(array);
    }

    public static <T> List<T> fromArrayToLIstWithGenerics(T[]array){
        return Arrays.asList(array);
    }
}
