import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class FeedbackTest {
  private WebDriver driver;
  JavascriptExecutor js;

  @BeforeEach
  public void setUp() throws MalformedURLException {
    //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new FirefoxOptions());
    driver = Util.getFirefoxDriver();
    js = (JavascriptExecutor) driver;
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void subscribe() {
    login();
    // 2 | click | xpath=//div[@id='subscribe-button']/ytd-subscribe-button-renderer/paper-button/yt-formatted-string | 
    driver.findElement(By.xpath("//div[@id=\'subscribe-button\']/ytd-subscribe-button-renderer/paper-button/yt-formatted-string")).click();
    // 3 | click | xpath=(//button[@id='button']/yt-icon)[13] | 
    driver.findElement(By.xpath("(//button[@id=\'button\']/yt-icon)[13]")).click();
    // 4 | click | xpath=//paper-listbox[@id='items']/ytd-menu-service-item-renderer/paper-item/yt-formatted-string | 
    driver.findElement(By.xpath("//paper-listbox[@id=\'items\']/ytd-menu-service-item-renderer/paper-item/yt-formatted-string")).click();
    // 5 | click | xpath=(//button[@id='button']/yt-icon)[13] | 
    driver.findElement(By.xpath("(//button[@id=\'button\']/yt-icon)[13]")).click();
    // 6 | click | xpath=//paper-listbox[@id='items']/ytd-menu-service-item-renderer[2]/paper-item/yt-formatted-string | 
    driver.findElement(By.xpath("//paper-listbox[@id=\'items\']/ytd-menu-service-item-renderer[2]/paper-item/yt-formatted-string")).click();
    // 7 | click | xpath=(//button[@id='button']/yt-icon)[13] | 
    driver.findElement(By.xpath("(//button[@id=\'button\']/yt-icon)[13]")).click();
    // 8 | click | xpath=//paper-listbox[@id='items']/ytd-menu-service-item-renderer[3]/paper-item | 
    driver.findElement(By.xpath("//paper-listbox[@id=\'items\']/ytd-menu-service-item-renderer[3]/paper-item")).click();
    // 9 | click | xpath=//div[@id='subscribe-button']/ytd-subscribe-button-renderer/paper-button/yt-formatted-string | 
    driver.findElement(By.xpath("//div[@id=\'subscribe-button\']/ytd-subscribe-button-renderer/paper-button/yt-formatted-string")).click();
    // 10 | click | xpath=(//yt-formatted-string[@id='text'])[78] | 
    driver.findElement(By.xpath("(//yt-formatted-string[@id=\'text\'])[78]")).click();
  }

  @Test
  public void likesanddislikes() {
    login();
    // Test name: likes and dislikes
    // Step # | name | target | value
    // 1 | open | https://www.youtube.com/watch?v=86BAr0Ei6RA | 
    driver.get("https://www.youtube.com/watch?v=86BAr0Ei6RA");
    // 2 | runScript | window.scrollTo(0,294) | 
    js.executeScript("window.scrollTo(0,294)");
    // 3 | click | xpath=(//yt-formatted-string[@id='text'])[2] | 
    driver.findElement(By.xpath("(//yt-formatted-string[@id=\'text\'])[2]")).click();
    // 4 | click | xpath=(//yt-formatted-string[@id='text'])[3] | 
    driver.findElement(By.xpath("(//yt-formatted-string[@id=\'text\'])[3]")).click();
    // 5 | click | xpath=(//button[@id='button']/yt-icon)[9] | 
    driver.findElement(By.xpath("(//button[@id=\'button\']/yt-icon)[9]")).click();
    // 6 | click | xpath=(//button[@id='button']/yt-icon)[8] | 
    driver.findElement(By.xpath("(//button[@id=\'button\']/yt-icon)[8]")).click();
    // 7 | click | xpath=(//button[@id='button']/yt-icon)[8] | 
    driver.findElement(By.xpath("(//button[@id=\'button\']/yt-icon)[8]")).click();
  }
  @Test
  public void replylikeanddislikecomment() {
    login();
    // Test name: reply, like and dislike comment
    // Step # | name | target | value
    // 1 | open | https://www.youtube.com/watch?v=86BAr0Ei6RA | 
    driver.get("https://www.youtube.com/watch?v=86BAr0Ei6RA");
    // 2 | runScript | window.scrollTo(0,628) | 
    js.executeScript("window.scrollTo(0,628)");
    // 3 | click | xpath=(//button[@id='button']/yt-icon)[14] | 
    driver.findElement(By.xpath("(//button[@id=\'button\']/yt-icon)[14]")).click();
    // 4 | click | xpath=(//button[@id='button']/yt-icon)[15] | 
    driver.findElement(By.xpath("(//button[@id=\'button\']/yt-icon)[15]")).click();
    // 5 | click | xpath=(//button[@id='button']/yt-icon)[15] | 
    driver.findElement(By.xpath("(//button[@id=\'button\']/yt-icon)[15]")).click();
    // 6 | click | xpath=(//button[@id='button']/yt-icon)[14] | 
    driver.findElement(By.xpath("(//button[@id=\'button\']/yt-icon)[14]")).click();
    // 7 | click | xpath=(//button[@id='button']/yt-icon)[14] | 
    driver.findElement(By.xpath("(//button[@id=\'button\']/yt-icon)[14]")).click();
    // 8 | click | xpath=(//yt-formatted-string[@id='text'])[7] | 
    driver.findElement(By.xpath("(//yt-formatted-string[@id=\'text\'])[7]")).click();
    // 9 | click | xpath=//div[@id='contenteditable-root'] | 
    driver.findElement(By.xpath("//div[@id=\'contenteditable-root\']")).click();
    // 10 | editContent | xpath=//div[@id='contenteditable-root'] | some test cancelled reply
    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'contenteditable-root\']"));
      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = 'some test cancelled reply'}", element);
    }
    // 11 | click | xpath=(//yt-formatted-string[@id='text'])[8] | 
    driver.findElement(By.xpath("(//yt-formatted-string[@id=\'text\'])[8]")).click();
    // 12 | click | xpath=(//yt-formatted-string[@id='text'])[7] | 
    driver.findElement(By.xpath("(//yt-formatted-string[@id=\'text\'])[7]")).click();
    // 13 | click | xpath=//div[@id='contenteditable-root'] | 
    driver.findElement(By.xpath("//div[@id=\'contenteditable-root\']")).click();
    // 14 | editContent | xpath=//div[@id='contenteditable-root'] | some test reply
    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'contenteditable-root\']"));
      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = 'some test reply'}", element);
    }
    // 15 | click | xpath=(//paper-button[@id='button'])[4] | 
    driver.findElement(By.xpath("(//paper-button[@id=\'button\'])[4]")).click();
  }
  @Test
  public void comment() {
    login();
    // 10 | runScript | window.scrollTo(0,655) | 
    js.executeScript("window.scrollTo(0,655)");
    // 11 | click | xpath=//div[@id='simple-box']/ytd-comment-simplebox-renderer | 
    driver.findElement(By.xpath("//div[@id=\'simple-box\']/ytd-comment-simplebox-renderer")).click();
    // 12 | editContent | id=contenteditable-root | comment_c
    {
      WebElement element = driver.findElement(By.id("contenteditable-root"));
      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = 'comment_c'}", element);
    }
    // 13 | click | css=#cancel-button #text | 
    driver.findElement(By.cssSelector("#cancel-button #text")).click();
    // 14 | click | xpath=//*[@id="placeholder-area"] | 
    driver.findElement(By.xpath("//*[@id=\"placeholder-area\"]")).click();
    // 15 | editContent | id=contenteditable-root | comment
    {
      WebElement element = driver.findElement(By.id("contenteditable-root"));
      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = 'comment'}", element);
    }
    // 16 | click | xpath=(//yt-formatted-string[@id='text'])[8] | 
    driver.findElement(By.xpath("(//yt-formatted-string[@id=\'text\'])[8]")).click();

    editComment();
    deleteComment();
  }

  private void editComment() {
    // 3 | mouseOver | xpath=(//button[@id='button']/yt-icon)[16] |
    {
      WebElement element = driver.findElement(By.xpath("(//button[@id=\'button\']/yt-icon)[16]"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 4 | click | xpath=(//button[@id='button']/yt-icon)[16] |
    driver.findElement(By.xpath("(//button[@id=\'button\']/yt-icon)[16]")).click();
    // 5 | mouseOut | xpath=(//button[@id='button']/yt-icon)[16] |
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    // 6 | click | xpath=//paper-listbox[@id='items']/ytd-menu-navigation-item-renderer/a/paper-item |
    driver.findElement(By.xpath("//paper-listbox[@id=\'items\']/ytd-menu-navigation-item-renderer/a/paper-item")).click();
    // 7 | mouseOver | xpath=(//button[@id='button'])[16] |
    {
      WebElement element = driver.findElement(By.xpath("(//button[@id=\'button\'])[16]"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 8 | click | xpath=//div[@id='contenteditable-root'] |
    driver.findElement(By.xpath("//div[@id=\'contenteditable-root\']")).click();
    // 9 | editContent | xpath=//div[@id='contenteditable-root'] | comment cancel edit
    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'contenteditable-root\']"));
      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = 'comment cancel edit'}", element);
    }
    // 10 | click | xpath=(//yt-formatted-string[@id='text'])[8] |
    driver.findElement(By.xpath("(//yt-formatted-string[@id=\'text\'])[8]")).click();
    // 11 | mouseOver | xpath=(//button[@id='button']/yt-icon)[16] |
    {
      WebElement element = driver.findElement(By.xpath("(//button[@id=\'button\']/yt-icon)[16]"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 12 | click | xpath=(//button[@id='button']/yt-icon)[16] |
    driver.findElement(By.xpath("(//button[@id=\'button\']/yt-icon)[16]")).click();
    // 13 | mouseOut | xpath=(//button[@id='button']/yt-icon)[16] |
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    // 14 | click | xpath=//paper-listbox[@id='items']/ytd-menu-navigation-item-renderer/a/paper-item/yt-formatted-string |
    driver.findElement(By.xpath("//paper-listbox[@id=\'items\']/ytd-menu-navigation-item-renderer/a/paper-item/yt-formatted-string")).click();
    // 15 | mouseOver | xpath=(//button[@id='button'])[16] |
    {
      WebElement element = driver.findElement(By.xpath("(//button[@id=\'button\'])[16]"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 16 | click | xpath=//div[@id='contenteditable-root'] |
    driver.findElement(By.xpath("//div[@id=\'contenteditable-root\']")).click();
    // 17 | editContent | xpath=//div[@id='contenteditable-root'] | comment edited
    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'contenteditable-root\']"));
      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = 'comment edited'}", element);
    }
    // 18 | click | xpath=(//yt-formatted-string[@id='text'])[9] |
    driver.findElement(By.xpath("(//yt-formatted-string[@id=\'text\'])[9]")).click();
  }

  private void deleteComment() {
    {
      WebElement element = driver.findElement(By.xpath("(//button[@id=\'button\']/yt-icon)[16]"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 4 | click | xpath=(//button[@id='button']/yt-icon)[16] | 
    driver.findElement(By.xpath("(//button[@id=\'button\']/yt-icon)[16]")).click();
    // 5 | mouseOut | xpath=(//button[@id='button']/yt-icon)[16] | 
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    // 6 | click | xpath=//paper-listbox[@id='items']/ytd-menu-navigation-item-renderer[2]/a/paper-item/yt-formatted-string | 
    driver.findElement(By.xpath("//paper-listbox[@id=\'items\']/ytd-menu-navigation-item-renderer[2]/a/paper-item/yt-formatted-string")).click();
    // 7 | mouseOver | xpath=(//button[@id='button'])[16] | 
    {
      WebElement element = driver.findElement(By.xpath("(//button[@id=\'button\'])[16]"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 8 | click | xpath=(//paper-button[@id='button'])[51] | 
    driver.findElement(By.xpath("(//paper-button[@id=\'button\'])[51]")).click();
  }

  private void login() {
    driver.get("https://www.youtube.com/watch?v=86BAr0Ei6RA");
    new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[3]/div[2]/ytd-button-renderer")));
    driver.findElement(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[3]/div[2]/ytd-button-renderer")).click();
    //driver.findElement(By.xpath("//div[@id=\'view_container\']/div/div/div[2]/div/div/div/form/span/section/div/div/div/div/ul/li[3]/div")).click();
    driver.findElement(By.xpath("//input[@id=\'identifierId\']")).click();
    driver.findElement(By.xpath("//input[@id=\'identifierId\']")).sendKeys("meier.d.th@gmail.com");
    driver.findElement(By.xpath("//div[@id=\'identifierNext\']/div/button/div[2]")).click();
    new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(
            By.xpath("//input[@name=\'password\']")));
    driver.findElement(By.xpath("//input[@name=\'password\']")).click();
    driver.findElement(By.xpath("//input[@name=\'password\']")).sendKeys("");
    driver.findElement(By.xpath("//div[@id=\'passwordNext\']/div/button/div[2]")).click();
  }

}
