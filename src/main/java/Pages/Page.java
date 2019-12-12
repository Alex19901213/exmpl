package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public abstract class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Random random;
    protected Actions action;
    protected JavascriptExecutor js;



    public String bxn = "https://www.budexpressnow.ca";

    public abstract void open(String host);


    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5, 200);
        random = new Random();
    }

    public void userConfirmsAgeModal(){
        try
        {
            driver.findElement(By.cssSelector(".confirm-age-modal")).click();
        }
        catch (NoSuchElementException x)
        {}
        catch
        (ElementClickInterceptedException e)
        {}
        try
        {
            driver.findElement(By.cssSelector(".button.confirm-age-modal-btn-yes")).click();
        }
        catch (NoSuchElementException x)
        {}
    }

    protected void type(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (WebDriverException e) {
            System.out.println("WebdriverException. Element: " + element + " dont clickable, or visible. URL: " + getUrl());
        }
    }

    protected void clickOn(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void hideElement(WebElement element) {
        if (element != null) {
            String script2 = "arguments[0].setAttribute('style', 'display:none')";
            js.executeScript(script2, element);
        }
    }

    protected boolean isVisible(WebElement element) {

        Dimension dimension = element.getSize();
        return dimension.getHeight() > 0 && dimension.getWidth() > 0;
    }

    protected boolean isElementPresent(WebElement webElement) {
        try {
            webElement.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isElementClickable(WebElement element) {
        WebDriverWait waitClick = new WebDriverWait(driver, 2, 200);
        try {
            waitClick.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected String getUrl() {
        return driver.getCurrentUrl();
    }

}
