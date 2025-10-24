package step;

import factory.ConfigReader;
import io.cucumber.java.en.And;
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

    @And("User clicks on Login Btn")
    public void clickOnLgnBtn(){
        loginPage.clickLogin();
    }

    @Then("Dashbard should be visible")
    public void verify_dashboard(){
        Assert.assertTrue(dashboardPage.isDashBoardVisible(),"Dashboard not visible");
    }

    @And("error message {string} should be displayed")
    public void errorMessage1(String expectedMsg){
        String actualMsg = loginPage.getErrorMessage();
        Assert.assertEquals(actualMsg.trim(),expectedMsg.trim());
    }

    @And("error message {string} should be displayed on field")
    public void errorMessage2(String expectedMsg){
        String actualMsg = loginPage.getErrorMessageOnField();
        Assert.assertEquals(actualMsg.trim(),expectedMsg.trim());
    }
}
