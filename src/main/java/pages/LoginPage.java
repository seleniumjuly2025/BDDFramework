package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends TestBase {

    private By username = By.name("username");
    private By password = By.name("password");
    private By loginBtn = By.xpath("//button[@type='submit']");
    private By logo = By.xpath("//img[@alt='company-branding']");
    private By forgotLink = By.xpath("//div[contains(@class,'orangehrm-login-forgot')]/p");
    private By invalidMsg = By.xpath("//div[contains(@class,'content--error')]/p");
    private By invalidMsgField =  By.xpath("//span[text()='Required']");

    @Step("Opening URL: {0}")
    public void open(String url){
        action.navigateTOUrl(url);
    }
    @Step("Entering username: {0}")
    public void enterUsername(String user){
        action.waitAndSendKeys(username,user);
    }
    @Step("Entering password: {0}")
    public void enterPassword(String pass){
        action.waitAndSendKeys(password,pass);
    }
    @Step("Click on Login Button")
    public void clickLogin(){
        action.waitAndClick(loginBtn);
    }
    @Step("Check the Logo Visibility")
    public boolean isLogoVisible(){
        return action.isDisplayed(logo);
    }
    @Step("Check the Forgot Password Link Visibility")
    public boolean isForgetPasswordVisible(){
        return action.isDisplayed(forgotLink);
    }

    @Step("Validate the Error Message")
    public String getErrorMessage(){
        return action.getText(invalidMsg);
    }

    @Step("Validate the Error Message on Field")
    public String getErrorMessageOnField(){
        return action.getText(invalidMsgField);
    }
}
