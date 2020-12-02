package test.java;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import test.java.LoggerRule;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class Base {

    @Rule
    public LoggerRule log = new LoggerRule();

    WebDriver driver;

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Before
    public void beforeTest() throws MalformedURLException {

        DesiredCapabilities dc = DesiredCapabilities.chrome();

        if (System.getProperty("browser").equals("firefox"))
            dc = DesiredCapabilities.firefox();

        String host = System.getProperty("seleniumHubHost");

        driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), dc);

        WebDriverRunner.setWebDriver(driver);

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
