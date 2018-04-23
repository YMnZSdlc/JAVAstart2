package pl.sda.javastart2.day8concurrency;

public class Bank {
    private static int balance = 1000;

    public static int operations;

    public synchronized static void withdraw(int howMuch) {
        balance = balance - howMuch;
        System.out.println(Thread.currentThread().getName()
                + " Stan konta po wypłacie: " + balance);
    }

    public synchronized static void giveBack(int howMuch) {
        balance = balance + howMuch;
        System.out.println(Thread.currentThread().getName()
                + " Stan konta po wpłacie: " + balance);
        operations++;
    }
}
