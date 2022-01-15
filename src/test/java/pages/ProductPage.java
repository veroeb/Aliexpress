package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    //==============LOCATORS==================
    @FindBy(css = ".product-quantity-tip span span")
    private WebElement quantity;
    //========================================

    public ProductPage(WebDriver driver) {
        super(driver);
    }
}
