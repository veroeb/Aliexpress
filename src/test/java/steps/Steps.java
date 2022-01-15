package steps;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class Steps {
    private static WebDriver driver;

    @Given("I access Aliexpress webpage")
    public void accessAliexpressWebpage() {
        /**
         * Access the Aliexpress webpage
         */
        driver = DriverFactory.getDriver();
        new HomePage(driver).getUrl("https://aliexpress.com/");
    }
    @When("I search for {string} with the search bar")
    public void searchWithSearchBar(String phoneBrand) {
        /**
         * Search a product in the search bar
         */
        new HomePage(driver).searchWithSearchBar(phoneBrand);
    }
    @Then("I can see all results")
    public void seeResults() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click on the next search results page")
    public void clickNextResultsPage() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click on the second card")
    public void clickSecondCard() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I can verify that there's at least one item available")
    public void verifyOneItemAvailable() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
