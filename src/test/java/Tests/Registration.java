package Tests;

import Basic.BasicCase;
import Pages.Prod.Registration.Login;
import Pages.Prod.Registration.PasswordReset;
import Utilits.User;
import io.qameta.allure.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("https://www.budexpressnow.ca")
@Feature("Sign Up/Log In page")
public class Registration extends BasicCase {
    private User user = new User();
    private Login lgn;
    private PasswordReset pswd;

    @BeforeClass
    @Override
    public void set_Up() {
        lgn = PageFactory.initElements(getDriver(), Pages.Prod.Registration.Login.class);
        pswd = PageFactory.initElements(getDriver(), Pages.Prod.Registration.PasswordReset.class);
    }

    @Test(priority = 1)
    @Story("Are main elements visible on the login page?")
    @Severity(SeverityLevel.CRITICAL)
    public void LoginPageMainElementsPresence() throws Exception{
        Given:
        lgn.userOpensAccountPage();

        When:

        Then:
        Assert.assertTrue(lgn.isSignUpFormPresent());
        Assert.assertTrue(lgn.isLogInFormPresent());
        Assert.assertTrue(lgn.isLostPasswordLinkPresent());
    }

    @Test(priority = 1)
    @Story("Are main elements visible on the password reset page?")
    @Severity(SeverityLevel.CRITICAL)
    public void PasswordResetPageMainElementsPresence() throws Exception{
        Given:
        pswd.userOpensPasswordResetPage();

        When:

        Then:
        Assert.assertTrue(pswd.isResetPasswordFormPresent());
    }


    @Test(priority = 2)
    @Story("Trying to log in as user")
    @Severity(SeverityLevel.CRITICAL)
    public void IsLoginSuccesful(){
        Given:
        lgn.userOpensAccountPage();
        When:
        lgn.userEntersEmail(user.customerEmail);
        lgn.userEntersPassword(user.customerPasswrd);
        lgn.userClicksOnLogInButton();
        Then:
        Assert.assertTrue(lgn.isUserLoginSuccessful());
    }

}
