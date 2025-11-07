package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.PIMPage;

public class PIMStepDefinition {
    PIMPage pimPage = new PIMPage();


    @Then("User navigate to PIM Page")
    public void user_nvigate_pimpage(){
        pimPage.openPIM();
    }

    @Then("User verify the PIM Page Header")
    public void user_verify_pimpage(){
        pimPage.openPIM();
    }

    @And("user clicks on Add Employee")
    public void user_clicks_on_add_employee() {
        pimPage.clickAddEmployee();
    }
    @When("user enters first name {string} and last name {string}")
    public void user_enters_first_name_and_last_name(String string1, String string2) {
        pimPage.addFName(string1);
        pimPage.addLName(string2);
    }
    @When("user sets employeeid {string}")
    public void user_sets_employeeid(String string) {
        pimPage.setEmployeeID(string);
    }
    @When("user uploads photo {string}")
    public void user_uploads_photo(String string) {
        pimPage.uploadPhoto(string);
    }
    @When("user clicks on Save button")
    public void user_clicks_on_save_button() throws InterruptedException {
        Thread.sleep(3000);
        pimPage.clickSave();
    }
    @Then("Successful employee creation toast should be visible")
    public void successful_employee_creation_toast_should_be_visible() {
        String successMessage = pimPage.getSuccessToast();
        if(successMessage.contains("Successfully")){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }


    }

}
