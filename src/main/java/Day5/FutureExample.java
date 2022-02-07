package Day5;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    //Use Executors' static factory method to create ExecutorService instance
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Integer> calculate(Integer input) {
        //Passing a callable as an argument in submit() method
        return executor.submit(() -> {
            Thread.sleep(1000);
            return 2 * input;
        });
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Future<Integer> future = new FutureExample().calculate(10);
        while(!future.isDone()) {
            System.out.println("Calculating..");
            Thread.sleep(3000);
        }

        System.out.println(future.get());

    }
}
