import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WatchingVideoTest {
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
  public void captions() {
    driver.get("https://www.youtube.com/watch?v=86BAr0Ei6RA");
    // 2 | click | xpath=//div[@id='movie_player']/div[24]/div[2]/div[2]/button[2] | 
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div[2]/div[2]/button[2]")).click();
    // 3 | click | xpath=//div[@id='movie_player']/div[4]/div | 
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[4]/div")).click();
  }

  @Test
  public void changeQuality() {
    driver.get("https://www.youtube.com/watch?v=86BAr0Ei6RA");
    // 2 | click | xpath=//div[@id='movie_player']/div[4]/button | 
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[4]/button")).click();
    // 3 | click | xpath=//div[@id='movie_player']/div[24]/div[2]/div[2]/button[3] | 
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div[2]/div[2]/button[3]")).click();
    // 4 | click | xpath=//div[@id='ytp-id-17']/div/div/div[4]/div[2] | 
    driver.findElement(By.xpath("//div[@id=\'ytp-id-17\']/div/div/div[4]/div[2]")).click();
    // 5 | click | xpath=//div[@id='ytp-id-17']/div/div[2]/div/div/div/span | 
    driver.findElement(By.xpath("//div[@id=\'ytp-id-17\']/div/div[2]/div/div/div/span")).click();
    // 6 | click | xpath=//div[@id='movie_player']/div[24]/div[2]/div[2]/button[3] | 
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div[2]/div[2]/button[3]")).click();
    // 7 | click | xpath=//div[@id='ytp-id-17']/div/div/div[4]/div[3]/div/span | 
    driver.findElement(By.xpath("//div[@id=\'ytp-id-17\']/div/div/div[4]/div[3]/div/span")).click();
    // 8 | click | xpath=//div[@id='ytp-id-17']/div/div[2]/div[4]/div | 
    driver.findElement(By.xpath("//div[@id=\'ytp-id-17\']/div/div[2]/div[4]/div")).click();
    // 9 | click | xpath=//div[@id='movie_player']/div/video | 
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div/video")).click();
    // 10 | click | xpath=//div[@id='movie_player']/div[24]/div[2]/div[2]/button[3] | 
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div[2]/div[2]/button[3]")).click();
  }

  @Test
  public void pauseAndScrolling() {
    driver.get("https://www.youtube.com/watch?v=86BAr0Ei6RA");
    // 2 | click | xpath=//div[@id='movie_player']/div[24]/div[2]/div/button | 
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div[2]/div/button")).click();
    // 3 | click | xpath=//div[@id='movie_player']/div[24]/div[2]/div/button | 
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div[2]/div/button")).click();
    // 4 | mouseDown | xpath=//div[@id='movie_player']/div[24]/div/div/div/div/div | 
    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div/div/div/div/div"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    // 5 | mouseUp | xpath=//div[@id='movie_player']/div[24]/div/div/div[6]/div/div | 
    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div/div/div[6]/div/div"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    // 6 | click | xpath=//div[@id='movie_player']/div[24]/div/div | 
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div/div")).click();
    // 7 | mouseDown | xpath=//div[@id='movie_player']/div[24]/div/div/div[3] | 
    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div/div/div[3]"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    // 8 | mouseUp | xpath=//div[@id='movie_player']/div[24]/div/div/div[6]/div/div | 
    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div/div/div[6]/div/div"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    // 9 | click | xpath=//div[@id='movie_player']/div[24]/div/div | 
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div/div")).click();
    // 10 | click | xpath=//div[@id='movie_player']/div[24]/div[2]/div/button | 
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div[2]/div/button")).click();
    // 11 | mouseDown | xpath=//div[@id='movie_player']/div[24]/div/div/div[3] | 
    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div/div/div[3]"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    // 12 | mouseUp | xpath=//div[@id='movie_player']/div[24]/div/div/div[6]/div/div | 
    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div/div/div[6]/div/div"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    // 13 | click | xpath=//div[@id='movie_player']/div[24]/div/div | 
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div/div")).click();
    // 14 | click | xpath=//div[@id='movie_player']/div/video | 
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div/video")).click();
  }

  @Test
  public void viewVideo() {
    driver.get("https://www.youtube.com/results?search_query=do+you+remember+altair");
    // 2 | click | xpath=//img[contains(@src,'https://i.ytimg.com/vi/86BAr0Ei6RA/hq720.jpg?sqp=-oaymwEZCOgCEMoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLDRb2FfXpSGYhPOe-EOSQZ9_5cpNw')] | 
    driver.findElement(By.xpath("//img[contains(@src,\'https://i.ytimg.com/vi/86BAr0Ei6RA/hq720.jpg?sqp=-oaymwEZCOgCEMoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLDRb2FfXpSGYhPOe-EOSQZ9_5cpNw\')]")).click();
  }

  @Test
  public void viewModes() {
    driver.get("https://www.youtube.com/watch?v=86BAr0Ei6RA");
    driver.findElement(By.cssSelector(".ytp-size-button")).click();
    driver.findElement(By.cssSelector(".ytp-size-button")).click();
    driver.findElement(By.cssSelector(".ytp-fullscreen-button")).click();
    driver.findElement(By.cssSelector(".ytp-fullscreen-button")).click();
  }

  @Test
  public void searchVideo() {
    driver.get("https://www.youtube.com");
    driver.findElement(By.xpath("//input[@id=\'search\']")).click();
    driver.findElement(By.xpath("//input[@id=\'search\']")).sendKeys("do you remember altair");
    driver.findElement(By.xpath("//input[@id=\'search\']")).sendKeys(Keys.ENTER);
  }

  @Test
  public void settingsMenu() {
    driver.get("https://www.youtube.com/watch?v=86BAr0Ei6RA");
    // 2 | click | xpath=//div[@id='movie_player']/div[24]/div[2]/div[2]/button[3] | 
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div[2]/div[2]/button[3]")).click();
    // 3 | click | xpath=//div[@id='ytp-id-17']/div/div/div[2]/div[3] | 
    driver.findElement(By.xpath("//div[@id=\'ytp-id-17\']/div/div/div[2]/div[3]")).click();
    // 4 | click | xpath=//div[@id='ytp-id-17']/div/div/button[2] | 
    driver.findElement(By.xpath("//div[@id=\'ytp-id-17\']/div/div/button[2]")).click();
    // 5 | click | xpath=//div[@id='ytp-id-17']/div/div/div[4]/div[2] | 
    driver.findElement(By.xpath("//div[@id=\'ytp-id-17\']/div/div/div[4]/div[2]")).click();
    // 6 | click | xpath=//div[@id='ytp-id-17']/div/div/button | 
    driver.findElement(By.xpath("//div[@id=\'ytp-id-17\']/div/div/button")).click();
    // 7 | click | xpath=//div[@id='ytp-id-17']/div/div/div[3]/div[2]/div/span | 
    driver.findElement(By.xpath("//div[@id=\'ytp-id-17\']/div/div/div[3]/div[2]/div/span")).click();
    // 8 | click | xpath=//div[@id='ytp-id-17']/div/div/button[2] | 
    driver.findElement(By.xpath("//div[@id=\'ytp-id-17\']/div/div/button[2]")).click();
    // 9 | click | xpath=//div[@id='movie_player']/div[24]/div[2]/div[2]/button[3] | 
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div[2]/div[2]/button[3]")).click();
  }

}
