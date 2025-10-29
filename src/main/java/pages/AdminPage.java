package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AdminPage extends TestBase{

    private By adminButtonLeftPane = By.xpath("//span[text()='Admin']//parent::a");
    private By adminPageHeader = By.xpath("//*[@class='oxd-topbar-header-breadcrumb']");
    private By searchUsername = By.xpath("//label[text()='Username']/../following-sibling::div");
    private By roleDropdown = By.xpath("//label[text()='User Role']/../following-sibling::div");
    private By employeeName = By.xpath("//label[text()='Employee Name']/../following-sibling::div");
    private By statusDropdown = By.xpath("//label[text()='Status']/../following-sibling::div");
    private By searchButton  = By.xpath("//button[@type='submit']");
    private By resetButton = By.xpath("//button[normalize-space()='Reset']");

    @Step("Click on Admin Left Pane Button")
    public void clickAdminLeftPane(){
        action.waitAndClick(adminButtonLeftPane);
    }



}
