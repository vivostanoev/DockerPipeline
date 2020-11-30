import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.Parameterized;
import org.junit.runners.model.RunnerScheduler;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Parallelized  extends BlockJUnit4ClassRunner {

    public Parallelized(Class<?> klass) throws Throwable {
        super(klass);
        setScheduler(new ParallelScheduler(Executors.newFixedThreadPool(1)));
    }

}
