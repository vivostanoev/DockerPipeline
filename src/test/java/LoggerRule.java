import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoggerRule extends TestWatcher {

    private HashMap<String, List<String>> logs;
    private Description description;


    @Override
    public Statement apply(Statement base, Description description) {
        logs = new HashMap<String, List<String>>();
        this.description = description;
        logs.put(description.getDisplayName(), new ArrayList<String>());
        return base;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        printf();
        super.failed(e, description);
    }

    public void addLog(String testLog)
    {
        logs.get(description.getDisplayName()).add(testLog);
    }

    @Override
    protected void finished(Description description) {
        printf();
    }

    public void printf()
    {
        logs.get(description.getDisplayName()).forEach(e -> System.out.println(e));
    }
}
