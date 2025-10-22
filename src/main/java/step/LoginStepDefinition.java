package step;

import factory.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginStepDefinition {
    private LoginPage loginPage = new LoginPage();
    private DashboardPage dashboardPage = new DashboardPage();


    @Given("User opens application")
    public void user_opens_application(){
        loginPage.open(ConfigReader.getBaseURL());
    }

    @When("User logs in the username {string} and password {string}")
    public void do_login(String user, String pass){
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
        loginPage.clickLogin();
    }

    @Then("Dashbard should be visible")
    public void verify_dashboard(){
        Assert.assertTrue(dashboardPage.isDashBoardVisible(),"Dashboard not visible");
    }
}
