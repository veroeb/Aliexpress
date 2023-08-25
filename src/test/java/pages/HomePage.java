package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage{
    //==============LOCATORS==================
    @FindBy(id = "search-key")
    private WebElement searchBar;

    @FindBy(css = "#card-list a.search-card-item")
    private List<WebElement> results;

    @FindBy(css = "li.next-next")
    private WebElement nextPage;
    //========================================

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void isElementPresent(String element){
        /**
         * Verifies if the element is present and closes it
         */
        List<WebElement> webElementList = null;
        if (element.equals("popUp"))
            webElementList = getDriver().findElements(By.cssSelector(".pop-content .pop-close-btn"));
        else if (element.equals("subscriptionPopUp"))
            webElementList = getDriver().findElements(By.cssSelector("iframe ~ div div ~ img"));
        if (!webElementList.isEmpty())
            webElementList.get(0).click();
    }

    public void isElementIntercepted(WebElement element){
        /**
         * If the element is intercepted, it will try to locate it again
         */
        try {
            getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
        }
        catch (ElementClickInterceptedException e){
            System.out.println("The element has been intercepted. It will retry.");
            getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
        }
    }

    public void searchOnSearchBar(String phoneBrand){
        /**
         * Searches a product in the search bar
         */
        isElementPresent("popUp");
        isElementPresent("subscriptionPopUp");
        isElementIntercepted(searchBar);
        searchBar.sendKeys(phoneBrand);
        searchBar.submit();
    }

    public void clickNextResultsPage(){
        /**
         * Clicks on the next page button to see more results
         */
        scrollToBottomOfPage();
        isElementIntercepted(nextPage);
//        getWait().until(ExpectedConditions.elementToBeClickable(nextPage)).click();
    }

    public List<WebElement> getResults(){
        /**
         * Gets all the results for the product
         */
        return getWait().until(ExpectedConditions.visibilityOfAllElements(results));
    }

    public ProductPage clickSecondCard(List<WebElement> webElementList){
        /**
         * Clicks on the second card of the results list
         */
        isElementIntercepted(webElementList.get(1));
        return new ProductPage(this.getDriver());
    }
}
