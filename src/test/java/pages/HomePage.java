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

    @FindBy(css = "#root div.product-container > div:nth-child(2) > a")
    private List<WebElement> results;

    @FindBy(css = ".next-pagination-pages > :nth-child(3)")
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
        try {
            getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
        }
        catch (ElementClickInterceptedException e){
            System.out.println("The element has been intercepted. It will retry.");
            getDriver().findElement(By.tagName("body")).click();
        }
    }

    public void searchOnSearchBar(String phoneBrand){
        isElementPresent("popUp");
        isElementPresent("subscriptionPopUp");
        isElementIntercepted(searchBar);
        searchBar.sendKeys(phoneBrand);
        searchBar.submit();
    }

    public void clickNextResultsPage(){
        scrollToBottomOfPage();
        getWait().until(ExpectedConditions.elementToBeClickable(nextPage)).click();
    }

    public List<WebElement> getResults(){
        return getWait().until(ExpectedConditions.visibilityOfAllElements(results));
    }

    public ProductPage clickSecondCard(List<WebElement> webElementList){
        isElementIntercepted(webElementList.get(1));
        return new ProductPage(this.getDriver());
    }
}
