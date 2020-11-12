import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

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
  }
  @Test
  public void resize() {
    driver.get("https://www.youtube.com/watch?v=86BAr0Ei6RA");
    driver.manage().window().setSize(new Dimension(1920, 1080));
    driver.manage().window().setSize(new Dimension(1600, 800));
    driver.manage().window().setSize(new Dimension(1280, 720));
    driver.manage().window().setSize(new Dimension(1000, 700));
  }
  @Test
  public void searchVideo() {
    driver.get("https://www.youtube.com/watch?v=86BAr0Ei6RA/");
    driver.findElement(By.xpath("//input[@id=\'search\']")).click();
    driver.findElement(By.xpath("//input[@id=\'search\']")).sendKeys("do you remember altair");
    driver.findElement(By.xpath("//input[@id=\'search\']")).sendKeys(Keys.ENTER);
  }
}
