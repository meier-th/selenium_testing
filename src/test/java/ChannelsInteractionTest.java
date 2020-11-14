import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChannelsInteractionTest {
  private WebDriver driver;
  JavascriptExecutor js;

  @BeforeEach
  public void setUp() {
    driver = Util.getFirefoxDriver();
    js = (JavascriptExecutor) driver;
    driver.get("https://www.youtube.com/user/gordonramsay");
    driver.manage().window().setSize(new Dimension(1920, 1080));
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void homeView() {
    assertTrue(driver.findElement(By.xpath("//*[@id=\"channel-header\"]")).isDisplayed());
    assertTrue(driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-browse/div[3]/ytd-c4-tabbed-header-renderer/app-header-layout/div/app-header/div[2]/div[1]")).isDisplayed());
  }

  @Test
  public void videosView() {
    driver.findElement(By.xpath("//div[@id=\'tabsContent\']/paper-tab[2]/div")).click();
    Util.waitFor(driver, "//*[@id=\"primary-items\"]");
    assertTrue(driver.findElement(By.xpath("//*[@id=\"primary-items\"]")).isDisplayed());
  }

  @Test
  public void playlistsView() {
    driver.findElement(By.xpath("//div[@id=\'tabsContent\']/paper-tab[3]/div")).click();
    assertTrue(driver.findElement(By.xpath("//*[@id=\"dismissable\"]")).isDisplayed());
  }

  @Test
  public void communityView() {
    driver.findElement(By.xpath("//div[@id=\'tabsContent\']/paper-tab[4]/div")).click();
    assertTrue(driver.findElement(By.xpath("//*[@id=\"contents\"]")).isDisplayed());
  }

  @Test
  public void channelsView() {
    driver.findElement(By.xpath("//div[@id=\'tabsContent\']/paper-tab[5]/div")).click();
    assertTrue(driver.findElement(By.xpath("//*[@id=\"primary\"]")).isDisplayed());
  }

  @Test
  public void aboutView() {
    driver.findElement(By.xpath("//div[@id=\'tabsContent\']/paper-tab[6]")).click();
    Util.waitFor(driver, "//*[@id=\"right-column\"]");
    assertTrue(driver.findElement(By.xpath("//*[@id=\"right-column\"]")).isDisplayed());
    assertTrue(driver.findElement(By.xpath("//*[@id=\"left-column\"]")).isDisplayed());
  }

  @Test
  public void backToHomeView() {
    driver.findElement(By.xpath("//div[@id=\'tabsContent\']/paper-tab[1]/div")).click();
    assertTrue(driver.findElement(By.xpath("//*[@id=\"channel-header\"]")).isDisplayed());
  }

}
