package pages;

import org.openqa.selenium.By;

public class DashboardPage extends TestBase {
    private By header = By.xpath("//h6[text()='Dashboard']");

    public boolean isDashBoardVisible(){
        return action.isDisplayed(header);
    }
}
