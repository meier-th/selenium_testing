import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WatchingvideoTest {
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
  public void captions() {
    driver.get("https://www.youtube.com/watch?v=86BAr0Ei6RA");
    driver.findElement(By.xpath("//div[@id=\'movie_player\']/div[24]/div[2]/div[2]/button[2]")).click();
  }
  @Test
  public void changequality() {
    driver.get("https://www.youtube.com/watch?v=86BAr0Ei6RA");
    driver.findElement(By.cssSelector(".ytp-settings-button")).click();
    driver.findElement(By.cssSelector(".ytp-menuitem:nth-child(4) > .ytp-menuitem-content")).click();
  }
  @Test
  public void pauseandscrolling() {
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
  public void viewmodes() {
    driver.get("https://www.youtube.com/watch?v=86BAr0Ei6RA");
    driver.findElement(By.cssSelector(".ytp-size-button")).click();
    driver.findElement(By.cssSelector(".ytp-size-button")).click();
    driver.findElement(By.cssSelector(".ytp-fullscreen-button")).click();
    driver.findElement(By.cssSelector(".ytp-fullscreen-button")).click();
  }
}
