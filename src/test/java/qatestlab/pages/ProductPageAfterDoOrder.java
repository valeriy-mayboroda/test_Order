package qatestlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.List;

/**
 * Created by val on 05.12.2017.
 */
public class ProductPageAfterDoOrder extends OrderFinishPage {

    @Test(dependsOnMethods = "checkOrderDetails")
    @Parameters({"shopUrl"})
    public void checking(String url){
        openShopUrl(url);
        clickAllProductsLink();
        searchProduct(product.getName());
        openProductAfterOrder();
        Assert.assertEquals(Integer.parseInt(getProductQuantity()), Integer.parseInt(product.getQuantity())-1);
    }

    public void openProductAfterOrder() {
        findProductAfterOrder(driver.findElements(By.tagName("a"))).click();
    }
    private WebElement findProductAfterOrder(List<WebElement> webElements) {
         for (WebElement webElement: webElements) {
             if (webElement.getText().toLowerCase().equals(product.getName().toLowerCase())) {
                 return webElement;
             }
         }
         return null;
    }
}
