package qatestlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import qatestlab.model.Product;

public class ProductPage extends ShopAllProductsPage {
    private By addToCartButton = By.cssSelector("button.btn-primary");
    private By cartLink = By.cssSelector("a.btn-primary");
    //Finding the productName and the productPrice before adding to the cart
    protected Product product;
    private By productName = By.className("h1");
    private By productPrice = By.className("current-price");
    //Finding the productQuantity before making the order
    private By productMoreDetails = By.cssSelector(".nav-item:nth-child(2) > a");
    private By productQuantity = By.cssSelector(".product-quantities span");

    @Test(dependsOnMethods = "clickRandomProduct")
    public void doProductPage() {
        saveProductBeforeOrder();
        clickAddAndGoToCart();
    }

    public void saveProductBeforeOrder() {
        product = new Product();
        product.setName(getProductName());
        product.setQuantity(getProductQuantity());
        product.setPrice(getProductPrice());
    }

    public void clickAddAndGoToCart() {
        clickAddToCartButton();
        clickGoToCartLink();
    }

    public void clickAddToCartButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton)).click();
    }

    public void clickGoToCartLink() {wait.until(ExpectedConditions.visibilityOfElementLocated(cartLink)).click();}

    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }

    public String getProductQuantity() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productMoreDetails)).click();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantity)).getText().split(" ")[0];
    }

    public String getProductPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice)).findElement(By.tagName("span")).getText().split(" ")[0];
    }
}
