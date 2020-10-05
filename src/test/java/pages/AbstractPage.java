package pages;

import helpers.DriverSetUp;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage extends PageObject {

    protected WebDriverWait wait = new WebDriverWait(new DriverSetUp().getWebDriver(), 20);
    public void openApplication() {
        setDriver(new DriverSetUp().getWebDriver());
    }
}
