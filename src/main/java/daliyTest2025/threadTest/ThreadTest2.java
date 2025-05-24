package daliyTest2025.threadTest;

public class ThreadTest2 extends Thread {
    @Override
    public void run() {
        while(true){
            boolean isInterrupt = currentThread().isInterrupted();
            if(isInterrupt){
                System.out.println("线程被打断");
                break;
            }
        }
        System.out.println(1111);
    }

    public static void main(String[] args) {
        Thread t1 = new ThreadTest2();
        t1.start();
        t1.interrupt();
    }
}
