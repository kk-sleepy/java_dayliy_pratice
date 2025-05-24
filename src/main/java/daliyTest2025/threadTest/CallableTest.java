package daliyTest2025.threadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTest ct = new CallableTest();
        FutureTask<Integer> f = new FutureTask<>(ct);
        Thread t1 = new Thread(f);
        t1.start();
        System.out.println(f.get());
    }
}
