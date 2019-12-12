package Tests;

import Basic.BasicCase;
import Pages.Prod.Shop.Categories;
import Pages.Prod.Shop.Product;
import Pages.Prod.Shop.ProductPreview;
import io.qameta.allure.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("https://www.budexpressnow.ca")
@Feature("Shop(Categories) page")
public class Shop extends BasicCase {
    private Categories cat;
    private ProductPreview prw;
    private Product prdct;

    @BeforeClass
    @Override
    public void set_Up() {
        cat = PageFactory.initElements(getDriver(), Categories.class);
        prw = PageFactory.initElements(getDriver(), ProductPreview.class);
        prdct = PageFactory.initElements(getDriver(), Product.class);
    }

    @Story("Presence of main elements on products with calculator.")
    @Severity(SeverityLevel.CRITICAL)
    @Test()
    public void ProductWithCalculatorPageTest(){
        Given:
        cat.userNavigatesToCannabis();

        When:
        cat.userChooseRandomProductWithCalculatorFromList();
        prw.clickOnGoToTheProductPageButton();

        Then:
        Assert.assertTrue(prdct.productImageShouldBeVisible());
        Assert.assertTrue(prdct.productTitleShouldBePresent());
        Assert.assertTrue(prdct.productTagsShouldBePresent());
        Assert.assertTrue(prdct.productPriceWrapShouldBePresent());
        Assert.assertTrue(prdct.productVariationsShouldBeVisible());
        Assert.assertTrue(prdct.productDescriptionShouldBePresent());
        Assert.assertTrue(prdct.productAdditionalInformationShouldBePresent());
        Assert.assertTrue(prdct.relatedProductsShouldBeVisible());
    }

    @Story("Presence of main elements on simple products.")
    @Severity(SeverityLevel.CRITICAL)
    @Test()
    public void SimpleProductPageTest(){
        Given:
        cat.userNavigatesToEdibles();

        When:
        cat.userChooseRandomSimpleProductFromList();
        prw.clickOnGoToTheProductPageButton();

        Then:
        Assert.assertTrue(prdct.productImageShouldBeVisible());
        Assert.assertTrue(prdct.productTitleShouldBePresent());
        Assert.assertTrue(prdct.productPriceWrapShouldBePresent());
        Assert.assertTrue(prdct.productDescriptionShouldBePresent());
        Assert.assertTrue(prdct.relatedProductsShouldBeVisible());
    }

    @Story("Presence of main elements on variable products.")
    @Severity(SeverityLevel.CRITICAL)
    @Test()
    public void VariableProductPageTest(){
        Given:
        cat.userNavigatesToVapes();

        When:
        cat.userChooseRandomVariableProductFromList();
        prw.clickOnGoToTheProductPageButton();

        Then:
        Assert.assertTrue(prdct.productImageShouldBeVisible());
        Assert.assertTrue(prdct.productTitleShouldBePresent());
        Assert.assertTrue(prdct.productVariationsBlockShouldBePresent());
        Assert.assertTrue(prdct.productPriceWrapShouldBePresent());
        Assert.assertTrue(prdct.productDescriptionShouldBePresent());
        Assert.assertTrue(prdct.relatedProductsShouldBeVisible());
    }

}