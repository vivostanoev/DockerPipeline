import org.junit.runners.model.RunnerScheduler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ParallelScheduler implements RunnerScheduler {

    ExecutorService executor;

    public ParallelScheduler(ExecutorService service)
    {
        this.executor = service;
    }


    @Override
    public void schedule(Runnable childStatement) {
        executor.submit(childStatement);
    }

    @Override
    public void finished() {
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException exc) {
            throw new RuntimeException(exc);
        }
    }
}
