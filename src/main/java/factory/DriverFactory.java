package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();


    public static WebDriver initDriver() {
        String browser = ConfigReader.getBrowser();
        boolean headless = ConfigReader.isHeadless();

        if(browser.isEmpty() || browser == null){
            browser = "firefox"; //Default value
        }

        if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            if(headless){
                options.addArguments("--headless=new");
            }
            options.addArguments("--no-sandbox","-disable-dev-shm-usgae");
            WebDriver driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getImplicitWait()));
            tlDriver.set(driver);
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if(headless){
                options.addArguments("--headless=new");
            }
            options.addArguments("--no-sandbox","-disable-dev-shm-usgae");
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getImplicitWait()));
            tlDriver.set(driver);
        }else {
            throw new RuntimeException("Only Chrome and Firefox are configured in this starter.");
        }

        return null;
    }

    public static WebDriver getDriver() { return tlDriver.get(); }

    public static void quitDriver(){
        if (tlDriver.get() != null){
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }

}
