package helpers;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverSetUp {
    private static WebDriver webDriver;
    @Before
    public static void setupSuite() {
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
