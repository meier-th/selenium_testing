import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChannelsInteractionTest {
  private WebDriver driver;
  JavascriptExecutor js;

  @BeforeEach
  public void setUp() throws MalformedURLException {
    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new FirefoxOptions());
    js = (JavascriptExecutor) driver;
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void channelView() {
    driver.get("https://www.youtube.com/user/gordonramsay");
    driver.findElement(By.xpath("//div[@id=\'tabsContent\']/paper-tab[2]/div")).click();
    driver.findElement(By.xpath("//div[@id=\'tabsContent\']/paper-tab[3]/div")).click();
    driver.findElement(By.xpath("//div[@id=\'tabsContent\']/paper-tab[4]/div")).click();
    driver.findElement(By.xpath("//div[@id=\'tabsContent\']/paper-tab[5]/div")).click();
    driver.findElement(By.xpath("//div[@id=\'tabsContent\']/paper-tab[6]/div")).click();
    driver.findElement(By.xpath("//div[@id=\'tabsContent\']/paper-tab[1]/div")).click();
  }
}
