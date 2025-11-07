package utils;

import factory.DriverFactory;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.time.Duration;
import java.util.Set;

public class ActionHelper {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private JavascriptExecutor js;
    private Logger log;

    public ActionHelper() {
        this.driver = DriverFactory.getDriver();
        this.wait =  new WebDriverWait(driver, Duration.ofSeconds(30));
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
        this.log = LogManager.getLogger(ActionHelper.class);
    }


   /* *********************
     Basic Operation
    ************************/

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

    public void jsClick(By locator){
        try{
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            js.executeScript("arguments[0].click();", element);
            log.info("Clicked via JS : {}",locator);
        } catch (Exception e) {
            log.error("JS click failed for element : {}",locator,e);
        }
    }

    public void jsScrollToTop(){
        try{
            js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
            log.info("Scrolled to top of page");
        } catch (Exception e) {
            log.error("Failed to scroll to top of the page");
        }
    }

    /*****************
    Dropdown Handling
    ******************/


    public void selectByVisibleText(By locator, String value){
        try{
            WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            new Select(dropdown).selectByVisibleText(value);
            log.info("Selected '{}' from dropdown: {} ",value,locator);
        } catch (Exception e) {
            log.error("Failed to select dropdown by visible text to element: " +locator,e);
            throw e;
        }
    }

    public void selectByValue(By locator, String value){
        try{
            WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            new Select(dropdown).selectByValue(value);
            log.info("Selected '{}' from dropdown: {} ",value,locator);
        } catch (Exception e) {
            log.error("Failed to select dropdown by value to element: " +locator,e);
            throw e;
        }
    }

    public void selectByIndex(By locator, int index){
        try{
            WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            new Select(dropdown).selectByIndex(index);
            log.info("Selected '{}' from dropdown: {} ",index,locator);
        } catch (Exception e) {
            log.error("Failed to select dropdown by visible text to element: " +locator,e);
            throw e;
        }
    }

    /********************
    Advance Mouse Actions
     *********************/

    public void hoverElement(By locator){
      try{
          WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
          actions.moveToElement(element).perform();
          log.info("Hovered on element: {}", locator);
      }catch (Exception e){
          log.error("Failed to Hover to element: " +locator,e);
          throw e;
      }
    }

    public void hoverElementAndClick(By locator){
        try{
            WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            actions.moveToElement(element).click().build().perform();
            log.info("Hovered on element and click on: {}", locator);
        }catch (Exception e){
            log.error("Failed to Hover to element and click: " +locator,e);
            throw e;
        }
    }

    public void doubleClick(By locator){
        try{
            WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            actions.doubleClick(element).perform();
            log.info("Double clicked on element: {}", locator);
        }catch (Exception e){
            log.error("Failed to Double Click to element: " +locator,e);
            throw e;
        }
    }

    public void rightClick(By locator){
        try{
            WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            actions.contextClick(element).perform();
            log.info("Right clicked on element: {}", locator);
        }catch (Exception e){
            log.error("Failed to Right Clicked to element: " +locator,e);
            throw e;
        }
    }

    public void dragAndDrop(By source, By target){
        try{
           WebElement src =  wait.until(ExpectedConditions.visibilityOfElementLocated(source));
           WebElement tgt =  wait.until(ExpectedConditions.visibilityOfElementLocated(target));
           actions.dragAndDrop(src,tgt).perform();
           log.info("Drageed element {} to {} ", source,target);
        }catch (Exception e){
            log.error("Failed to DragAndDrop from source {} to target {}: ",source,target,e);
            throw e;
        }
    }


    /**************
 *  Alert Handling
 *  ****************/


    public void acceptAlert(){
        try{
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            log.info("Accepting alert: {}",alert.getText());
            alert.accept();
        }catch (Exception e){
            log.warn("No alert to accept");
        }
    }

    public void dismissAlert(){
        try{
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            log.info("Dismissing alert: {}",alert.getText());
            alert.dismiss();
        }catch (Exception e){
            log.warn("No alert to dismiss");
        }
    }

    public String getAlertText(){
        try{
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            log.info("Alert text : {}",alert.getText());
            return alert.getText();
        }catch (Exception e){
            log.warn("No alert present");
            return null;
        }
        }


    /*******************
     Windows/Tab Actions
     ******************** */


    public void switchTOWindowByTitle(String title) {
        try {
            Set<String> handles = driver.getWindowHandles();
            for (String handle : handles) {
                driver.switchTo().window(handle);
                if (driver.getTitle().contains(title)) {
                    log.info("Switched to window: {}", title);
                    return;
                }
            }
        } catch (Exception ex) {
           log.warn("No window found with title");
        }
    }

    public void switchToNewTab() {
        try {
           String current = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
               if (!handle.equals(current)){
                   driver.switchTo().window(handle);
                   log.info("Switching to new tab");
                   return;
               }
            }
        } catch (Exception ex) {
            log.warn("Failed to switch to new Tab");
        }
    }

   /* Wait Utils*/

    public void waitForVisibility(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForInvisibility(By locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void fluentWait(By locator, int timeoutSeconds){
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(driver -> driver.findElement(locator));
        log.info("Fluent wait complete for element: {} ",locator);
    }

    /*****************
    Screenshot Utility
    *******************/
    @Attachment(value = "Failed Screenshot", type = "image/png")
    public String takeScreenshot(String fileName){
        try{
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String dest = System.getProperty("user.dir")+ "/screenshots/"+ fileName + ".png";
            FileHandler.createDir(new File("screenshots"));
            FileHandler.copy(src,new File(dest));
            log.info("Screenshot captured: {} ",dest);
            return dest;
        } catch (Exception e) {
           log.error("Screenshot capture failed",e);
           return null;
        }
    }

    public void pressEnter(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
        log.info("Pressed ENTER on element: {}",locator);
    }

    public void clearText(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        log.info("Cleared text for element: {}", locator);
    }

    public void clearUsingBackSpace(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String value = element.getText();
        while(value.isBlank()){
        element.sendKeys(Keys.BACK_SPACE);
        value = element.getText();
        }
        log.info("Cleared text for element: {}", locator);
    }

    public boolean verifyTextEquals(By locator, String expectedText){
        String actual = getText(locator);
        boolean match = actual.trim().equalsIgnoreCase(expectedText.trim());
        log.info("Verifying text match | Expected : {} | Actual: {}",expectedText,actual);
        return match;
    }

    public void uploadFile(By locator, String filePath){
       WebElement element =  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
       element.sendKeys(filePath);
       log.info("Uploaded file: {} ",filePath);
    }

    public void refreshPage(){
        driver.navigate().refresh();
        log.info("Page refreshed");
    }

    public void back(){
        driver.navigate().back();
        log.info("Navigated Back");
    }

    public void forward(){
        driver.navigate().forward();
        log.info("Navigated Forward");
    }
}
