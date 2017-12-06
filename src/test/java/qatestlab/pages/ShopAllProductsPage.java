package qatestlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import java.util.List;

public class ShopAllProductsPage extends ShopMainPage {
    private By products = By.className("product-title");
    private By link = By.tagName("a");
    private By searchInput = By.className("ui-autocomplete-input");
    private By searchButton = By.cssSelector("#search_widget > form > button");

    @Test(dependsOnMethods = "doShopMainPage")
    public void clickRandomProduct() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(products));
        List<WebElement> webElementList = driver.findElements(products);
        webElementList.get((int)(Math.random()*webElementList.size())).findElement(link).click();
    }

    public void searchProduct(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton)).click();
    }
}
