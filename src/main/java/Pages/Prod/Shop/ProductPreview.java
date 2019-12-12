package Pages.Prod.Shop;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPreview extends Page {
    public ProductPreview(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open(String host) {}

    @FindBy(css = ".green_link")
    WebElement b_GoToTheProductPage;
    @FindBy(css = ".ajax_prev_buy")
    WebElement b_AddToCart;
    /**Click on Go To The product button from product preview*/
    public void clickOnGoToTheProductPageButton(){
    clickOn(b_GoToTheProductPage);
    }
    /**Click on Add To Cart button from product preview*/
    public void clickOnAddToCartButton(){
    clickOn(b_AddToCart);
    }
}
