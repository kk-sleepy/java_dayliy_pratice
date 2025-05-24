package daliyTest2025.threadTest;

public class NotifyTest {
    private static Object num = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized (num){
                System.out.println(Thread.currentThread().getName() + "waiting...");
//                try {
//                    num.wait(800L);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                System.out.println(Thread.currentThread().getName() + "awake");
            }
        },"t1");
        Thread t2 = new Thread(()->{
            synchronized (num){
                System.out.println(Thread.currentThread().getName() + "waiting...");
//                try {
//                    num.wait(2000L);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                System.out.println(Thread.currentThread().getName() + "awake");
            }
        },"t2");
        t2.start();
        t1.start();
        Thread.sleep(0L);
        synchronized (num){
            System.out.println(3);
        }
    }
}
