import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

@RunWith(Parallelized.class)
public class OpenBrowserTests extends Base{

    @Test
    @DisplayName("Test Opening browser dialog")
    public void openBrowser() throws Exception
    {
        Allure.step("Click menu item 'Laptops'");
        $(withText("Laptops")).click();
        $(withText("MacBook air")).click();
    }


    @Test
    @DisplayName("Test expected failure")
    public void openBrowserAndFailTest()
    {
        Allure.step("I want to fail the test");
        Assert.assertTrue(true);
    }
}
