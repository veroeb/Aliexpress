package steps;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductPage;

import java.util.List;

public class Steps {
    private static WebDriver driver;
    private HomePage homePage;
    private List<WebElement> results;
    private ProductPage productPage;

    @Given("I access Aliexpress webpage")
    public void accessAliexpressWebpage() {
        /**
         * Access the Aliexpress webpage
         */
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        homePage.getUrl("https://aliexpress.com/");
    }

    @When("I search for {string} on the search bar")
    public void searchOnSearchBar(String phoneBrand) {
        /**
         * Search a product in the search bar
         */
        homePage.searchOnSearchBar(phoneBrand);
    }

    @When("I click on the next search results page")
    public void clickNextResultsPage() {
        /**
         * Click on the next page button to see more results
         */
        homePage.clickNextResultsPage();
    }

    @Then("I can see all results")
    public void getResults() {
        /**
         * Get all the results for the product
         */
        results = homePage.getResults();
        Assert.assertFalse(results.isEmpty(), "There are no results");
    }

    @When("I click on the second card")
    public void clickSecondCard() {
        /**
         * Click on the second card of the results list
         */
        productPage = homePage.clickSecondCard(results);
    }

    @Then("I can verify that there's at least one item available")
    public void verifyOneItemAvailable() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
