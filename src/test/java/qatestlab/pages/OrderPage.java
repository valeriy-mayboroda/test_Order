package qatestlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import qatestlab.model.Person;

/**
 * Created by val on 04.12.2017.
 */
public class OrderPage extends CartPage {
    protected Person person;
    private By personalForm = By.id("checkout-personal-information-step");
    private By firstNameInput= By.name("firstname");
    private By lastNameInput = By.name("lastname");
    private By emailInput = By.name("email");
    private By continuePersonalButton = By.name("continue");

    private By addressForm = By.id("checkout-addresses-step");
    private By addressInput = By.name("address1");
    private By postInput = By.name("postcode");
    private By cityInput = By.name("city");
    private By continueAddressButton = By.name("confirm-addresses");

    private By deliveryForm = By.id("checkout-delivery-step");
    private By continueDeliveryButton = By.name("confirmDeliveryOption");

    private By paymentForm = By.id("checkout-payment-step");
    private By paymentType = By.cssSelector("#payment-option-1");
    private By permitCheckbox = By.cssSelector("#conditions_to_approve\\[terms-and-conditions\\]");
    private By continueFinishButton = By.cssSelector("div.ps-shown-by-js > button:nth-child(1)");

    @Test(dependsOnMethods = "checkQuantityAndClickOrder")
    public void fillPersonalDetails() {
        person = Person.initPerson();
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalForm));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
        driver.findElement(personalForm).findElement(firstNameInput).sendKeys(person.getFirstName());
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput));
        driver.findElement(personalForm).findElement(lastNameInput).sendKeys(person.getLastName());
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        driver.findElement(personalForm).findElement(emailInput).sendKeys(person.getEmail());
        wait.until(ExpectedConditions.visibilityOfElementLocated(continuePersonalButton));
        driver.findElement(personalForm).findElement(continuePersonalButton).click();
    }
    @Test(dependsOnMethods = "fillPersonalDetails")
    public void fillAddressDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressForm));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressInput));
        driver.findElement(addressForm).findElement(addressInput).sendKeys(person.getAddress());
        wait.until(ExpectedConditions.visibilityOfElementLocated(postInput));
        driver.findElement(addressForm).findElement(postInput).sendKeys(person.getPostAddress());
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityInput));
        driver.findElement(addressForm).findElement(cityInput).sendKeys(person.getCity());
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueAddressButton));
        driver.findElement(addressForm).findElement(continueAddressButton).click();
    }
    @Test(dependsOnMethods = "fillAddressDetails")
    public void fillDeliveryDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryForm));
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueDeliveryButton));
        driver.findElement(deliveryForm).findElement(continueDeliveryButton).click();
    }
    @Test(dependsOnMethods = "fillDeliveryDetails")
    public void fillPaymentDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentForm));
        driver.findElement(paymentType).click();
        driver.findElement(permitCheckbox).click();
        driver.findElement(continueFinishButton).click();
    }
}
