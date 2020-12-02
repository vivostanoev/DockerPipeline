package test.java.stepDefenition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginStepDefinition {

    @Given("^Loading the application$")
    public void loading_the_application()
    {
        open("https://www.demoblaze.com/");
    }

    @When("^Click menu item Laptops$")
    public void clickMenuItemLaptops()
    {
        $(withText("Laptops")).click();
    }


    @Then("^MacBook air is displayed$")
    public void checkMacBookAirIsDisplayed()
    {
        Assert.assertTrue($(withText("MacBook air")).isDisplayed());
    }
}
