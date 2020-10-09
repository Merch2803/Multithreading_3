import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        OutputChars outputChars = new OutputChars();
        Thread threadA = new Thread(outputChars::outputA);
        Thread threadB = new Thread(outputChars::outputB);
        Thread threadC = new Thread(outputChars::outputC);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(threadA);
        executorService.submit(threadB);
        executorService.submit(threadC);

        executorService.shutdown();
    }
}
