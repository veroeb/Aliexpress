package pages;

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

    public void searchOnSearchBar(String phoneBrand){
        getWait().until(ExpectedConditions.elementToBeClickable(searchBar)).click();
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
        getWait().until(ExpectedConditions.elementToBeClickable(webElementList.get(1))).click();
        return new ProductPage(this.getDriver());
    }
}
