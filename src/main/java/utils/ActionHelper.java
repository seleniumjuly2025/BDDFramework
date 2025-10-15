package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.WindowFocusListener;
import java.time.Duration;

public class ActionHelper {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private JavascriptExecutor js;

    private static final Logger log = LogManager.getLogger(ActionHelper.class);

    public ActionHelper(WebDriver driver) {
        this.driver = driver;
        this.wait =  new WebDriverWait(driver, Duration.ofSeconds(30));
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }

    public void navigateTOUrl(String url){
        log.info("Navigating to URL: " +url);
        driver.get(url);
    }

    public void waitAndClick(By locator){
        try {
            log.info("Wating for element to be clickable: " +locator);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            log.info("Clicked on element: " +locator);
        }catch (Exception e){
            log.error("Failed to click on element: " +locator,e);
            throw e;
        }
    }

    public void waitAndSendKeys(By locator, String text){
        try {
            log.info("Wating for element to be visible: " +locator);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(text);
            log.info("Sent keys to element: " +locator + " | Value : "+text);
        }catch (Exception e){
            log.error("Failed to send keys to element: " +locator,e);
            throw e;
        }
    }

    public String getText(By locator){
        try {
            String text = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
            log.info("Text retrieved from :" +locator + " : " +text);
            return text;
        }catch (Exception e){
            log.error("Failed to get text from element: " +locator,e);
            return null;
        }
    }

    public boolean isDisplayed(By locator){
        try {
            boolean visible = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
            log.info("Element displayed:" +locator + " : " +visible);
            return visible;
        }catch (Exception e){
            log.error("Element not visible: " +locator,e);
            return false;
        }
    }

    public void scrollIntoView(By locator){
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            js.executeScript("arguments[0].scrollIntoView(true);",element);
            log.info("Scrolled to element:" +locator);
        }catch (Exception e){
            log.error("Failed to Scrolled to element: " +locator,e);
            throw e;
        }
    }

}
