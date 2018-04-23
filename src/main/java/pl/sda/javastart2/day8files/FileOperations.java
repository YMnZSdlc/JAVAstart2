package pl.sda.javastart2.day8files;

import com.google.common.collect.Lists;
import com.google.common.io.Files;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileOperations {

    private static String filePath = "c:\\projekt\\pan.txt";

    public static void main(String[] args) {
//        rewriterFilesFromOneToAnotherNewWay();
//        readFileWithBuffereReader();
        countWords();
//        splitLine();

    }

    private static void splitLine() {
        String invocation = "    Litwo! Ojczyzno moja! ty jesteś jak zdrowie:";
        String[] splitteBySpacebar = invocation.split(" ");
        System.out.println(Arrays.toString(splitteBySpacebar));
        String[] splitteByS = invocation.split("\\s+");
        System.out.println(Arrays.toString(splitteByS));
        String[] splitteByNonWords = invocation.split("[^\\p{L}]+");
        System.out.println(Arrays.toString(splitteByNonWords));
    }

    private static void countWords() {
        File file = Paths.get(filePath).toFile();
        try {
            List<String> words = Lists.newArrayList();
            List<String> lines = Files.readLines(file, Charset.forName("UNICODE"));
            for (String line : lines) {
                if (StringUtils.isBlank(line)) {
                    continue;
                }
                words.addAll(Arrays.asList(line.split("[^\\p{L}]+")));
            }
            Map<String,Long> wordCountMap = words.stream()
                    .filter(e->StringUtils.isNoneBlank(e))
                    .collect(Collectors.groupingBy(e->e,Collectors.counting()));
            System.out.println(wordCountMap);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFileWithBuffereReader() {
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void rewriterFilesFromOneToAnotherNewWay() {
        try (FileInputStream fileInputStream
                     = new FileInputStream(filePath);
             FileOutputStream fileOutputStream
                     = new FileOutputStream(filePath.replace("pan.txt", "pan-kopia.txt"));) {
            int b;
            while ((b = fileInputStream.read()) != -1) {
                fileOutputStream.write(b);
            }

        } catch (IOException e) { //cach musi być zawsze, nie można go zostawić pustego
            e.printStackTrace();
        }
    }


}
