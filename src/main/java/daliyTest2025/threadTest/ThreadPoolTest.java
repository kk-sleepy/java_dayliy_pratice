package daliyTest2025.threadTest;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest implements Runnable{
    @Override
    public void run() {
        System.out.println("Woc,nmd!");
    }

    public static void main(String[] args) {
        ExecutorService tp = Executors.newFixedThreadPool(3);
        tp.submit(new ThreadPoolTest());
        tp.shutdown();
    }
}
