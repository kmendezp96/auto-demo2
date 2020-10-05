package pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://iomaddemo.learnerscript.com/login/index.php")
public class LoginPage extends AbstractPage {

    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "loginbtn")
    private WebElement loginButton;

    public void login(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @Override
    public void openApplication() {
        super.openApplication();
        open();
    }
}
