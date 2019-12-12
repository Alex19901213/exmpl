package Pages.Prod.Shopping;

import Pages.Page;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Cart extends Page {
    public Cart(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open(String host) {
    driver.get(host);
    }

    @FindBy(css = ".cart_item")
    WebElement productInTheCart;
    @FindBy(css = ".um-form")
    WebElement buyingForm;
    @FindBy(css = ".empty_cart")
    WebElement emptyCart;
    @FindBy(css = ".remove")
    WebElement b_Remove;
    @FindBy(css = ".checkout-btn")
    WebElement b_Checkout;

    /**Navigating to Edibles category.*/
    public void userNavigatesToCart(){
        open(bxn+"/cart");
        userConfirmsAgeModal();
    }
    /**Cleaning the cart, if it got 1 product.*/
    public void cleanTheCart(){
        try
        {
            productInTheCart.isDisplayed();
            wait.until(ExpectedConditions.visibilityOf(b_Remove));
            clickOn(b_Remove);
        }
        catch (NoSuchElementException e)
        {
        }

    }

    /**Clicking on Checkout button from the cart page*/
    public void clickOnCheckoutButton(){
        clickOn(b_Checkout);
    }
    /**Test which tests a buying form presence in the cart page*/
    public boolean isBuyingFormPresent(){
        return buyingForm.isDisplayed();
    }
    /**Is the cart has at least a one product*/
    public boolean isCartFilled(){
        return productInTheCart.isDisplayed();
    }
    /**Is the cart filled*/
    public boolean isCartEmpty(){
        return emptyCart.isDisplayed();
    }



}
