package pl.sda.javastart2.day7exeptions;

public class MyResource implements AutoCloseable{

    public void doSomeWorl(String work){
        System.out.println("doing " + work);
        throw  new RuntimeException("Exeption during work");
    }

    public  void close(){
        System.out.println("Closing resource");
        throw new RuntimeException("Exeption close");
    }
}
