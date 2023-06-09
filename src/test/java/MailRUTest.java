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
public class MailRUTest {
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

    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void mailRU() {
    driver.get("https://mail.ru/");
    driver.manage().window().setSize(new Dimension(2576, 1408));
    driver.findElement(By.xpath("//main[@id=\'grid\']/div[2]/div[2]/div/a")).click();

    assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.urlMatches("https://mail.ru*")));
  }
}
