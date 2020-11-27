import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.core.IsEqual;
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
        log.addLog("openBrowser - Click menu item Laptop");
        Allure.step("Click menu item 'Laptops'");
        $(withText("Laptops")).click();
        log.addLog("openBrowser - Select a MacBook air");
        $(withText("MacBook air")).click();
    }


    @Test
    @DisplayName("Test expected failure")
    public void openBrowserAndFailTest()
    {
            log.addLog("openBrowserAndFailTest- assert true true");
            Allure.step("I want to fail the test");
            errorCollector.checkThat(false, IsEqual.equalTo(true));
            log.addLog("openBrowserAndFailTest - second test finished");
    }

    @Test
    @DisplayName("Test expected failure")
    public void testWithchOnlyPrintInConsole()
    {
        log.addLog("testWithchOnlyPrintInConsole - first print");
        log.addLog("testWithchOnlyPrintInConsole - second print");
        log.addLog("testWithchOnlyPrintInConsole - third print");
    }
}
