import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.open;

public class Base {

    @Before
    public void beforeTest() {
        Allure.step("Open a browser dialog");
        open("https://www.demoblaze.com/");
    }

    @After
    public void afterTest()
    {
        WebDriverRunner.closeWindow();
    }
}
