import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Util {

    public static void waitFor(WebDriver driver, String xpath) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(
                By.xpath(xpath)));
    }

    public static void waitForPresence(WebDriver driver, String xpath) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(xpath)));
    }

    public static WebDriver getFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        return new FirefoxDriver();
    }

    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        return new ChromeDriver();
    }

    public static WebDriver getGridEnvFirefoxDriver() throws MalformedURLException {
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new FirefoxOptions());
    }

    public static WebDriver getGridEnvChromeDriver() throws MalformedURLException {
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new ChromeOptions());
    }

}