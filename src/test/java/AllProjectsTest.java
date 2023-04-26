// Generated by Selenium IDE
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class AllProjectsTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @BeforeAll
  public static void setup() {
    String value_name = System.getenv("DRIVER");
    if (value_name.equals("firefox")) {
      WebDriverManager.firefoxdriver().setup();
    } else {
      WebDriverManager.chromedriver().setup();
    }
  }

  @BeforeEach
  public void setUp() {
    String value_name = System.getenv("DRIVER");

    if (value_name.equals("firefox")) {
      driver = new FirefoxDriver();
    } else {
      driver = new ChromeDriver();
    }

    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  public String waitForWindow(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Set<String> whNow = driver.getWindowHandles();
    Set<String> whThen = (Set<String>) vars.get("window_handles");
    if (whNow.size() > whThen.size()) {
      whNow.removeAll(whThen);
    }
    return whNow.iterator().next();
  }
  @Test
  public void allProjects() {
    driver.get("https://mail.ru/");
    driver.manage().window().setSize(new Dimension(2576, 1408));
    driver.findElement(By.xpath("//div[@id=\'ph-whiteline\']/div/div/div")).click();
    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'ph-whiteline\']/div/div[2]/div/section[2]/div/div/div/div[2]/a[7]"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    vars.put("window_handles", driver.getWindowHandles());
    driver.findElement(By.xpath("//div[2]/div[2]/a/span")).click();
    vars.put("win7881", waitForWindow(2000));
    driver.switchTo().window(vars.get("win7881").toString());

    assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.urlMatches("https://vk.company*")));
  }
}
