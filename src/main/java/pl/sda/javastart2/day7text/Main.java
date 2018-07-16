package pl.sda.javastart2.day7text;

public class Main{
    public static void main(String[] args){
        System.out.print("Spoko");
        spin("Hello World!!!");
    }

    public static void spin(String str){
        for (int i=0; i<100; i++){
            System.out.println(str);
        }
    }
}