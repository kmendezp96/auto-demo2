package pages;

import org.awaitility.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class DashboardPage extends AbstractPage {

    @FindBy(xpath = "//span[contains(@id,'filter_company')]")
    private WebElement companyDropDown;
    @FindBy(xpath = "//*[@title='Course participation']/..//td[contains(text(),'Enrollments')]//b")
    private WebElement courseParticipationEnrollments;

    private final String companyDropDownOptionXpath = "//ul[contains(@id,'filter_company')]//li[contains(text(),'%s')]";

    public void applyCompanyFilter(String company) {
        await().atMost(30, TimeUnit.SECONDS)
                .pollInterval(Duration.ONE_SECOND)
                .until(() ->  {
                    try {
                        companyDropDown.click();
                        getDriver().findElement(
                                By.xpath(String.format(companyDropDownOptionXpath, company)))
                                .click();
                        return true;
                    } catch (NoSuchElementException | ElementNotInteractableException e){
                        return false;
                    }
                });
    }

    public int getCourseParticipationEnrollments(){
        return Integer.parseInt(courseParticipationEnrollments.getText().trim());
    }
}
