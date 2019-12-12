package Pages.Prod.Shopping;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout extends Page {
    public Checkout(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open(String host) {
    driver.get(host);
    }

    @FindBy(css = ".address-book__checkout")
    WebElement addressBook;
    @FindBy(css = ".next-step-btn")
    WebElement b_ContinueToPayment;
    /**Navigating to Checkout page*/
    public void userNavigatesToCheckoutPage(){
        open(bxn+"/checkout");
    }
    /**Is the address book present on the checkout page?*/
    public boolean isAdressBookPresent(){
        return addressBook.isDisplayed();
    }
    /**Is the Continue Payment button avaleble on the checkout page*/
    public boolean isContinuePaymentButtonAvalable(){
        return b_ContinueToPayment.isDisplayed();
    }
}
