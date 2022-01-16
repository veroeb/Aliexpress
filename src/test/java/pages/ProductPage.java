package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage{
    //==============LOCATORS==================
    @FindBy(css = ".product-quantity-tip span span")
    private WebElement quantity;
    //========================================

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public int verifyOneItemAvailable(){
        /**
         * Verifies that there's at least one item available
         */
        switchTabs();
        String productQuantityText =  getWait().until(ExpectedConditions.visibilityOf(quantity)).getText();
        return Integer.parseInt(productQuantityText.replaceAll("[^0-9]", ""));
    }
}
