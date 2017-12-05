package qatestlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ShopMainPage extends BasePageInstance {
    private By allProductsLink = By.className("all-product-link");
    //For site version checking
    private By browserVersionWebElement = By.className("container");
    private By mobileVersion = By.id("_mobile_cart");
    private By desktopVersion = By.id("_desktop_cart");

    @Parameters("browser")
    @Test
    public void checkBrowserVersion (String browser) {
        if (browser.equals("chromeMobile")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(browserVersionWebElement));
            Assert.assertTrue(driver.findElement(mobileVersion).isDisplayed());
        }
        else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(browserVersionWebElement));
            Assert.assertTrue(driver.findElement(desktopVersion).isDisplayed());
        }
    }

    @Test (dependsOnMethods = "checkBrowserVersion")
    @Parameters({"shopUrl"})
    public void doShopMainPage(String url) {
        openShopUrl(url);
        clickAllProductsLink();
    }

    public void openShopUrl(String url) {driver.get(url);}

    public void clickAllProductsLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsLink));
        driver.findElement(allProductsLink).click();
    }
}