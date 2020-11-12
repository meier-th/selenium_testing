import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

public class ChannelsInteractionTest {
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
  public void channelview() {
    driver.get("https://www.youtube.com/user/gordonramsay");
    driver.findElement(By.xpath("//div[@id=\'tabsContent\']/paper-tab[2]/div")).click();
    driver.findElement(By.xpath("//div[@id=\'tabsContent\']/paper-tab[3]/div")).click();
    driver.findElement(By.xpath("//div[@id=\'tabsContent\']/paper-tab[4]/div")).click();
    driver.findElement(By.xpath("//div[@id=\'tabsContent\']/paper-tab[5]/div")).click();
    driver.findElement(By.xpath("//div[@id=\'tabsContent\']/paper-tab[6]")).click();
    driver.findElement(By.xpath("//div[@id=\'tabsContent\']/paper-tab[1]/div")).click();
  }
}
