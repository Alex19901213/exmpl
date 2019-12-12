package Pages.Prod.Registration;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends Page {
    public Login(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open(String host) {
        driver.get(host);
    }

    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "username")
    WebElement email;
    @FindBy(css = ".woocommerce-form-login__submit")
    WebElement b_Login;
    @FindBy(css = ".profile_tab")
    WebElement accountIcon;
    @FindBy(className = "sign_up")
    WebElement signUp;
    @FindBy(className = "log_in")
    WebElement logIn;
    @FindBy(className = "lost_password")
    WebElement lostPassword;


    /**
     * Opens Log In page.
     * Confirms user age.
    */
    public void userOpensAccountPage(){
        open(bxn+"/account");
        userConfirmsAgeModal();
    }

    /**
     * Method which tests presence of Sign Up form on the page.
     */
    public boolean isSignUpFormPresent(){
    wait.until(ExpectedConditions.visibilityOf(signUp));
    return signUp.isDisplayed();
    }

    /**
     * Method which tests presence of Log In form on the page.
     */
    public boolean isLogInFormPresent(){
    wait.until(ExpectedConditions.visibilityOf(logIn));
    return logIn.isDisplayed();
    }

    /**
     * Method which tests presence of Lost Password link on the page.
     */
    public boolean isLostPasswordLinkPresent(){
    wait.until(ExpectedConditions.visibilityOf(lostPassword));
    return lostPassword.isDisplayed();
    }

    /**
     * Enters email in the email field.
     */
    public void userEntersEmail(String mail){
        type(email, mail);
    }

    /**
     * Enters password in the password field.
     */
    public void userEntersPassword(String pswrd){
        type(password, pswrd);
    }

    /**
     * Clicks on LogIn button.
     */
    public void userClicksOnLogInButton(){
    clickOn(b_Login);
    }

    /**
     * Condition to check successful of login.
     */
    public boolean isUserLoginSuccessful(){
        wait.until(ExpectedConditions.visibilityOf(accountIcon));
        return accountIcon.isDisplayed();
    }

}
