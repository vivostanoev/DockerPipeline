import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class Base {

    @Rule
    public LoggerRule log = new LoggerRule();

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Before
    public void beforeTest() throws MalformedURLException {

        ChromeOptions option = new ChromeOptions();
        String urlToRemoteWD = "http://localhost:4444/wd/hub";

        RemoteWebDriver driver =new RemoteWebDriver(new URL(urlToRemoteWD), option);
        WebDriverRunner.setWebDriver(driver);

        Allure.step("Open a browser dialog");
        driver.get("https://www.demoblaze.com/");

    }

    @After
    public synchronized void afterTest()
    {
        WebDriverRunner.closeWindow();
        log.printf();
    }
}
