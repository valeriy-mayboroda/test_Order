package qatestlab.pages;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import qatestlab.event.EventHandlerInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class BasePageInstance {
    protected EventFiringWebDriver driver;
    protected WebDriverWait wait;

    public WebDriver getDriver(String browser) {
        DesiredCapabilities desiredCapabilities;
        if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
            return new FirefoxDriver();
        }
        if (browser.equals("ie")) {
            desiredCapabilities = DesiredCapabilities.internetExplorer();
            desiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            desiredCapabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
            desiredCapabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
            desiredCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
            desiredCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
            return new InternetExplorerDriver(desiredCapabilities);
        }
        if (browser.equals("chromeMobile")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
            Map<String, String> mobileEmulator = new HashMap<>();
            mobileEmulator.put("deviceName", "iPhone 6");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulator);
            return new ChromeDriver(chromeOptions);
        }
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        return new ChromeDriver();
    }

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        WebDriver webDriver = getDriver(browser);
        driver = new EventFiringWebDriver(webDriver);
        driver.register(new EventHandlerInstance());
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Reporter.setEscapeHtml(false);
    }

    @AfterTest
    public void closeDriver() {
        if (driver != null)
            driver.quit();
    }

    @BeforeClass
    public void setWait(){wait = new WebDriverWait(driver, 15);}

    @AfterClass
    public void closeDriverWait() {
        if (wait != null)
            wait = null;
    }

    public void log(String message) {Reporter.log(message + "<br/>");}
}