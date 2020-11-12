import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {

    public static void waitFor(WebDriver driver, String xpath) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(
                By.xpath(xpath)));
    }

    public static WebDriver getFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "/home/thom/selenium_grid/geckodriver");
        return new FirefoxDriver();
    }

}