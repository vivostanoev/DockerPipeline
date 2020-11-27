import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import java.util.HashMap;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class Base {

    @Rule
    public LoggerRule log = new LoggerRule();

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Before
    public void beforeTest() {
        Allure.step("Open a browser dialog");
        open("https://www.demoblaze.com/");

    }

    @After
    public synchronized void afterTest()
    {
        WebDriverRunner.closeWindow();
        log.printf();
    }
}
