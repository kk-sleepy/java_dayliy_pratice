package daliyTest2025.threadTest;

public class RunnalbeTest implements Runnable{
    @Override
    public void run() {
        System.out.println(111);
    }

    public static void main(String[] args) {
        RunnalbeTest t = new RunnalbeTest();
        Thread t1 = new Thread(t);
        t1.start();
    }
}
