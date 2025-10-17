package pages;

import factory.ConfigReader;
import org.openqa.selenium.WebDriver;
import utils.ActionHelper;

public class TestBase {
    protected ActionHelper action;

    public TestBase(){
        this.action = new ActionHelper();
    }
}
