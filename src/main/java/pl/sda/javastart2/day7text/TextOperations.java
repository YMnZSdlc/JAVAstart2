package pl.sda.javastart2.day7text;

import org.apache.commons.lang3.ArrayUtils;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class TextOperations {
    public static void main(String[] args) {
        int iterations = 150_000;
//        classicContact("abc", iterations);
//        builderConcat("abc", iterations);
        isAnagram("kaJak", "\"kkaaj\"");
        isPalindrom("Marzena pokazała Zakopane z ram");
    }

    private static void isPalindrom(String text) {
        text = text.replaceAll("\\W", "").toLowerCase();

        char[] original = text.toCharArray();
        char[] mirror = text.toCharArray();
        ArrayUtils.reverse(mirror);

        boolean result = Arrays.equals(original, mirror);
        System.out.println(result);
    }

    private static void isAnagram(String text, String anagram) {
        text = text.replaceAll("\\W", "").toLowerCase();
        anagram = anagram.replaceAll("\\W", "").toLowerCase();

        char[] charsText = text.toCharArray();
        char[] charsAnagram = anagram.toCharArray();

        Arrays.sort(charsText);
        Arrays.sort(charsAnagram);

        boolean result = Arrays.equals(charsText, charsAnagram);
        System.out.println(result);
    }

    private static void builderConcat(String text, int iterations) {
        Instant start = Instant.now();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        System.out.println(Duration.between(start, Instant.now()));
    }

    private static void classicContact(String text, int iterations) {
        Instant start = Instant.now();

        String result = "";
        for (int i = 0; i < iterations; i++) {
            result = result + text;
        }
        System.out.println(Duration.between(start, Instant.now()));
    }
}
