package Tests;

import Basic.BasicCase;
import Pages.Prod.Registration.Login;
import Pages.Prod.Shop.Categories;
import Pages.Prod.Shop.ProductPreview;
import Pages.Prod.Shopping.Cart;
import Pages.Prod.Shopping.Checkout;
import Utilits.User;
import io.qameta.allure.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("https://www.budexpressnow.ca")
@Feature("Cart/Checkout page")
public class Shopping extends BasicCase {
    private User user = new User();
    private Cart crt;
    private Login lgn;
    private Categories cat;
    private ProductPreview prw;
    private Checkout chk;


    @BeforeClass
    @Override
    public void set_Up() {
        lgn = PageFactory.initElements(getDriver(), Pages.Prod.Registration.Login.class);
        cat = PageFactory.initElements(getDriver(), Categories.class);
        prw = PageFactory.initElements(getDriver(), ProductPreview.class);
        crt = PageFactory.initElements(getDriver(), Cart.class);
        chk = PageFactory.initElements(getDriver(), Checkout.class);


        LoginAsUser:
        lgn.userOpensAccountPage();
        lgn.userEntersEmail(user.customerEmail);
        lgn.userEntersPassword(user.customerPasswrd);
        lgn.userClicksOnLogInButton();
        CleanTheCart:
        crt.userNavigatesToCart();
        crt.cleanTheCart();
    }

    @Test()
    @Story("Are main elements visible on the cart page?.")
    @Severity(SeverityLevel.CRITICAL)
    public void AddProductToCart(){
        cat.userNavigatesToCannabis();
        cat.userChooseRandomProductWithCalculatorFromList();
        prw.clickOnAddToCartButton();
    }

    @Test()
    @Story("Are main elements visible on the checkout page?.")
    @Severity(SeverityLevel.CRITICAL)
    public void CartMainElementsPresence(){
        Given:
        crt.userNavigatesToCart();
        When:

        Then:
        Assert.assertTrue(crt.isBuyingFormPresent());
        Assert.assertTrue(crt.isCartFilled());
    }

    @Test()
    @Story("Are main elements visible on the checkout reset page?.")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckoutMainElementsPresence(){
        Given:
        chk.userNavigatesToCheckoutPage();
        When:

        Then:
        Assert.assertTrue(chk.isAdressBookPresent());
        Assert.assertTrue(chk.isContinuePaymentButtonAvalable());
    }


}
