import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.*;

public class WatchingVideoTest {
  private WebDriver driver;
  JavascriptExecutor js;

  @BeforeEach
  public void setUp() {
    driver = Util.getChromeDriver();
    js = (JavascriptExecutor) driver;
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void captions() {
    driver.get("https://www.youtube.com/watch?v=86BAr0Ei6RA");
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div[2]/div[2]/button[2]")).click();
    Util.waitFor(driver, "/html/body/ytd-app/div/ytd-page-manager/ytd-watch-flexy/div[4]/div[1]/div/div[1]/div/div/div/ytd-player/div/div/div[18]/span/span[1]/span");
    assertTrue(driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-watch-flexy/div[4]/div[1]/div/div[1]/div/div/div/ytd-player/div/div/div[18]/span/span[1]/span")).isDisplayed());
  }

  @Test
  public void changeQuality() {
    driver.get("https://www.youtube.com/watch?v=86BAr0Ei6RA");
    driver.findElement(By.cssSelector(".ytp-settings-button")).click();
    driver.findElement(By.cssSelector(".ytp-menuitem:nth-child(4) > .ytp-menuitem-content")).click();
    assertThrows(NoSuchElementException.class, () -> {driver.findElement(By.cssSelector(".ytp-settings-button.ytp-hd-quality-badge"));});
  }

  @Test
  public void pauseAndScrolling() {
    driver.get("https://www.youtube.com/watch?v=86BAr0Ei6RA");
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div[2]/div/button")).click();
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div[2]/div/button")).click();
    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div/div/div/div/div"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div/div/div[6]/div/div"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div/div")).click();
    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div/div/div[3]"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div/div/div[6]/div/div"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div/div")).click();
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div[2]/div/button")).click();
    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div/div/div[3]"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div/div/div[6]/div/div"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div/div")).click();
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div/video")).click();
  }

  @Test
  public void viewModes() {
    driver.get("https://www.youtube.com/watch?v=86BAr0Ei6RA");
    driver.findElement(By.cssSelector(".ytp-size-button")).click();
    Util.waitFor(driver, "//*[@id=\"movie_player\"]");
    assertTrue(driver.findElement(By.xpath("//*[@id=\"movie_player\"]")).isDisplayed());
    driver.findElement(By.cssSelector(".ytp-size-button")).click();
    int width = driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-watch-flexy/div[4]/div[1]/div/div[1]/div/div/div/ytd-player/div/div/div[1]/video")).getSize().width;
    assertTrue(width < 1000);
    driver.findElement(By.cssSelector(".ytp-fullscreen-button")).click();
    width = driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-watch-flexy/div[3]/div/ytd-player/div/div/div[1]/video")).getSize().width;
    assertTrue(width > 1300);
    driver.findElement(By.cssSelector(".ytp-fullscreen-button")).click();
  }
}
