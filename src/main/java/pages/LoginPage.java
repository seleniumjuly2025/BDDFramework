package pages;

import org.openqa.selenium.By;

public class LoginPage extends TestBase {

    private By username = By.name("username");
    private By password = By.name("password");
    private By loginBtn = By.name("//button[@type='submit']");
    private By logo = By.xpath("//img[@alt='company-branding']");

    public void open(String url){
        action.navigateTOUrl(url);
    }
    public void enterUsername(String user){
        action.waitAndSendKeys(username,user);
    }
    public void enterPassword(String pass){
        action.waitAndSendKeys(password,pass);
    }
    public void clickLogin(){
        action.waitAndClick(loginBtn);
    }
    public boolean isLogoVisible(){
        return action.isDisplayed(logo);
    }
}
