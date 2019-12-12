package Pages.Prod.Shop;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product extends Page {
    public Product(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open(String host) {
    }

    @FindBy(css = ".zoom.slick-slide.slick-current.slick-active")
    WebElement productImage;
    @FindBy(css = ".product_title")
    WebElement productTitle;
    @FindBy(css = ".title__tags")
    WebElement productTags;
    @FindBy(css = ".price-wrap")
    WebElement productPriceWrap;
    @FindBy(css = ".variations_form")
    WebElement productVariations;
    @FindBy(css = ".woocommerce-Tabs-panel--description")
    WebElement productDescription;
    @FindBy(css = ".woocommerce-Tabs-panel--additional_information")
    WebElement productAdditionalInformation;
    @FindBy(css = ".woocommerce-Tabs-panel--reviews")
    WebElement productReviews;
    @FindBy(css = ".product-slider__related")
    WebElement relatedProducts;
    @FindBy(css = ".variations")
    WebElement variationsBlock;

    /**Test on visibility of product image.*/
    public boolean productImageShouldBeVisible(){
        return isVisible(productImage); }

    /**Test on existence of product title.*/
    public boolean productTitleShouldBePresent(){
        return isElementPresent(productTitle);
    }

    /**Test on existence of product tags.*/
    public boolean productTagsShouldBePresent(){
        return isElementPresent(productTags);
    }

    /**Test on existence of price wrapper of the product.*/
    public boolean productPriceWrapShouldBePresent(){
        return isElementPresent(productPriceWrap);
    }

    /**Test on visibility of Variations of the Products.*/
    public boolean productVariationsShouldBeVisible(){
        return isVisible(productVariations);
    }

    /**Test on existence of dropdown of variations*/
    public boolean productVariationsBlockShouldBePresent(){
        return  isElementPresent(variationsBlock);
    }

    /**Test on existence of product description.*/
    public boolean productDescriptionShouldBePresent(){
        return isElementPresent(productDescription);
    }

    /**Test on existence of additional information of the product.*/
    public boolean productAdditionalInformationShouldBePresent(){
        return isElementPresent(productAdditionalInformation);
    }

    /**Test on existence of Reviews.*/
    public boolean productReviewsShouldBePresent(){
        return isElementPresent(productReviews);
    }

    /**Test on visibility of the Related Products.*/
    public boolean relatedProductsShouldBeVisible(){
        return isVisible(relatedProducts);
    }

}
