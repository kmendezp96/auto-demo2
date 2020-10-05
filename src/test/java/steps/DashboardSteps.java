package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.CoreMatchers;
import pages.DashboardPage;
import pages.LoginPage;

import static org.junit.Assert.assertThat;

public class DashboardSteps {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Given("^a manager is logged$")
    public void aManagerIsLogged() {
        loginPage.openApplication();
        loginPage.login("manager","Iomaddemo#123");
    }

    @When("^the manager filters by \"([^\"]*)\" company$")
    public void theManagerFiltersByCompany(String company) {
        dashboardPage.openApplication();
        dashboardPage.applyCompanyFilter(company);
    }

    @Then("^the course enrollment should be greater than (\\d+)$")
    public void theCourseEnrollmentShouldBeGreaterThan(int minimumEnrollment) {
        assertThat("Enrollment should be greater than "+minimumEnrollment,
                dashboardPage.getCourseParticipationEnrollments()>minimumEnrollment,
                CoreMatchers.is(true));

    }
}
