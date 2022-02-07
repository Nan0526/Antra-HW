package Day5;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureExample {
    public List<Integer> calculate (List<Integer> list) {
        List<Integer> res = list.stream().map(n -> CompletableFuture.supplyAsync(() -> getNumber(n)))
                .map(CompletableFuture -> CompletableFuture.thenApply(i -> 2 * i))
                .map(t->t.join()).collect(Collectors.toList());
        return res;
    }

    private int getNumber(int n) {
        return n * n;
    }

    public static void main(String[] args) {
        CompletableFutureExample cFuture = new CompletableFutureExample();
        List<Integer> list = Arrays.asList(1, 4, 5, 9);
        List<Integer> demo = cFuture.calculate(list);
        System.out.print(demo);
    }
}
