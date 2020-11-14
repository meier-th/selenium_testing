import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneralTest {
  private WebDriver driver;
  JavascriptExecutor js;

  @BeforeEach
  public void setUp() {
    driver = Util.getFirefoxDriver();
    js = (JavascriptExecutor) driver;
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void viewVideo() {
    driver.get("https://www.youtube.com/results?search_query=do+you+remember+altair");
    driver.findElement(By.xpath("//img[contains(@src,\'https://i.ytimg.com/vi/86BAr0Ei6RA/hq720.jpg?sqp=-oaymwEZCOgCEMoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLDRb2FfXpSGYhPOe-EOSQZ9_5cpNw\')]")).click();
    Util.waitFor(driver, "/html/body/ytd-app/div/ytd-page-manager/ytd-watch-flexy/div[4]/div[1]/div/div[1]/div/div/div/ytd-player/div/div/div[1]/video");
    assertTrue(driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-watch-flexy/div[4]/div[1]/div/div[1]/div/div/div/ytd-player/div/div/div[1]/video")).isDisplayed());
  }

  @Test
  public void resize() {
    driver.get("https://www.youtube.com/watch?v=86BAr0Ei6RA");
    driver.manage().window().setSize(new Dimension(1920, 1080));
    assertTrue(driver.findElement(By.xpath("//*[@id=\"primary\"]")).getSize().width > 1070);
    driver.manage().window().setSize(new Dimension(1600, 800));
    int width = driver.findElement(By.xpath("//*[@id=\"primary\"]")).getSize().width;
    assertTrue(width > 850 && width < 950);
    driver.manage().window().setSize(new Dimension(1280, 720));
    width = driver.findElement(By.xpath("//*[@id=\"primary\"]")).getSize().width;
    assertTrue(width > 650 && width < 820);
    driver.manage().window().setSize(new Dimension(950, 700));
    width = driver.findElement(By.xpath("//*[@id=\"primary\"]")).getSize().width;
    assertTrue(width > 880 && width < 950);
  }

  @Test
  public void searchVideo() {
    driver.get("https://www.youtube.com");
    driver.findElement(By.xpath("//input[@id=\'search\']")).click();
    driver.findElement(By.xpath("//input[@id=\'search\']")).sendKeys("do you remember altair");
    driver.findElement(By.xpath("//input[@id=\'search\']")).sendKeys(Keys.ENTER);
    Util.waitFor(driver, "//*[@id=\"dismissable\"]");
    assertTrue(driver.findElement(By.xpath("//*[@id=\"dismissable\"]")).isDisplayed());
  }

}
