package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PIMPage extends TestBase{

    private By pimMenu = By.xpath("//a[contains(@href,'/pim/viewPim')]");
    private By pimPageHeader = By.xpath("//h6");
    private By addButton = By.xpath("//button[text()=' Add ']");
    private By firstName = By.name("firstName");
    private By middleName = By.name("middleName");
    private By lastName = By.name("lastName");
    private By employeeID = By.xpath("//label[text()='Employee Id']/../following-sibling::div/input");
    private By photoUploadBtn = By.xpath("//input[@type='file']");
    private By createLoginDetailToggle = By.xpath("//div[@class='oxd-switch-wrapper']");
    private By usernameField = By.xpath("//label[text()='Username']/../following-sibling::div");
    private By passwordField = By.xpath("//label[text()='Password']/../following-sibling::div");
    private By cnfrmPasswordField = By.xpath("//label[text()='Confirm Password']/../following-sibling::div");
    private By cancelButton = By.xpath("//button[text()=' Cancel ']");
    private By saveButton = By.xpath("//div[@class='oxd-form-actions']/button[2]");
    private By toastMessage = By.xpath("//div[contains(@id,'oxd-toaster')]");

    //Search Locators:
    private By searchEmployeeByName = By.xpath("//label[text()='Employee Name']/../following-sibling::div");
    private By searchEmployeeByID  =  By.xpath("//label[text()='Employee Id']/../following-sibling::div");

    @Step("Open PIM Module")
    public void openPIM(){
        action.waitAndClick(pimMenu);
    }

    @Step("Validation of PIM Page")
    public void verifyPimPage(){
        Assert.assertEquals(action.getText(pimPageHeader),"PIM");
    }

    @Step("Click on Add Employee")
    public void clickAddEmployee(){
        action.waitAndClick(addButton);
    }

    @Step("Enter firstName: {0}")
    public void addFName(String fName ){
        action.waitAndSendKeys(firstName,fName);
    }

    @Step("Enter middleName: {0}")
    public void addMName(String mName ){
        action.waitAndSendKeys(middleName,mName);
    }

    @Step("Enter lastName: {0}")
    public void addLName(String lName ){
        action.waitAndSendKeys(lastName,lName);
    }

    @Step("Set Employee id : {0}")
    public void setEmployeeID(String id ){
//        action.clearUsingBackSpace(employeeID);
        action.waitAndSendKeys(employeeID,id);
    }


    @Step("Upload Photo : {0}")
    public void uploadPhoto(String fullPath ){
        action.waitAndSendKeys(photoUploadBtn,fullPath);
    }

    @Step("Activate Credential Creation")
    public void setCredentials(String userName, String password , String confirmPassword){
        action.waitAndSendKeys(usernameField,userName);
        action.waitAndSendKeys(passwordField,password);
        action.waitAndSendKeys(cnfrmPasswordField,confirmPassword);
    }

    @Step("Click on Save Button")
    public void clickSave(){
        action.waitAndClick(saveButton);
    }

    @Step("Get success toast text")
    public String getSuccessToast(){
       return action.getText(toastMessage);
    }

    @Step("Search employee by name: {0}")
    public void searchByName(String fullName){
    action.waitAndSendKeys(searchEmployeeByName,fullName);
    }
    @Step("Search employee by id: {0}")
    public void searchByEmpID(String id){
        action.waitAndSendKeys(searchEmployeeByID,id);
    }

}
