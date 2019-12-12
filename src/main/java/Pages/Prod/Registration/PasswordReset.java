package Pages.Prod.Registration;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PasswordReset extends Page {
    public PasswordReset(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open(String host) { driver.get(host);}

    @FindBy(css = ".lost_reset_password")
    WebElement lostPaswwordForm;
    /**Go to Password Reset page*/
    public void userOpensPasswordResetPage(){
        open(bxn+"/account/password-reset");
        userConfirmsAgeModal();
    }
    /**Is Password Reset form present*/
    public boolean isResetPasswordFormPresent(){
        wait.until(ExpectedConditions.visibilityOf(lostPaswwordForm));
        return lostPaswwordForm.isDisplayed();
    }
}
