package qatestlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ShopMainPage extends BasePageInstance {
    private By allProductsLink = By.className("all-product-link");
    private By mobileVersion = By.id("_mobile_logo");
    private By desktopVersion = By.id("_desktop_cart");

    //Scrypt A
    @Test
    @Parameters("browser")
    public void checkBrowserVersion (String browser) {
        openShopUrl("http://prestashop-automation.qatestlab.com.ua/ru/");
        if (browser.equals("chromeMobile")) {
            Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(mobileVersion)).isDisplayed());
        }
        else {
            Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(desktopVersion)).isDisplayed());
        }
    }

    //Scrypt B
    @Test
    @Parameters({"shopUrl"})
    public void doShopMainPage(String url) {
        openShopUrl(url);
        clickAllProductsLink();
    }

    public void openShopUrl(String url) {driver.get(url);}

    public void clickAllProductsLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsLink)).click();
    }
}