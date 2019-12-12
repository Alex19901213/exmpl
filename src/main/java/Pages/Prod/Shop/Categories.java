package Pages.Prod.Shop;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Categories extends Page {
    public Categories(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open(String host) {
    driver.get(host);
    }



    @FindAll({@FindBy(css = ".product-item__price")})
    List<WebElement> anyProduct;
    @FindAll({@FindBy(css = ".variation_price")})
    List<WebElement> variableProduct;
    @FindAll({@FindBy(css = ".calculator_price")})
    List<WebElement> productsWithCalculator;


    /**Navigating to Cannabis category.*/
    public void userNavigatesToCannabis() {
        open(bxn + "/product-category/cannabis/");
        userConfirmsAgeModal();
    }
    /**Navigating to Edibles category.*/
    public void userNavigatesToEdibles(){
        open(bxn+"/product-category/edibles/");
        userConfirmsAgeModal();
    }
    /**Navigating to Vapes category.*/
    public void userNavigatesToVapes(){
        open(bxn+"/product-category/vapes/");
        userConfirmsAgeModal();
    }

    /**Navigating to random single product.*/
    public void userChooseRandomSimpleProductFromList(){
        anyProduct.get(random.nextInt(anyProduct.size())).click();
    }
    /**Navigating to random product with calculator.*/
    public void userChooseRandomProductWithCalculatorFromList() {
        clickOn(productsWithCalculator.get(random.nextInt(productsWithCalculator.size())));
    }
    /**Navigating to random variable product.*/
    public void userChooseRandomVariableProductFromList(){
        variableProduct.get(random.nextInt(variableProduct.size())).click();
    }

}
