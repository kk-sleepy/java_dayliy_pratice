package daliyTest2025.threadTest;

public class Thread1 extends Thread{
    @Override
    public void run() {
        System.out.println(123);
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread1();
        thread1.start();
        thread1.start();
    }
}
