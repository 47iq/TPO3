// Generated by Selenium IDE

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
public class BlackWhiteTest {
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
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void testThemeSwitch() {
    driver.get("https://mail.ru/");

    // Настройка светлой/темной тем
    driver.findElement(By.xpath("//div[2]/div")).click();

    // Светлая тема
    driver.findElement(By.xpath("//label/div")).click();

    if (driver instanceof ChromeDriver) {
      Assertions.assertEquals(driver.findElement(By.xpath("/html/body")).getCssValue("background-color"), "rgba(255, 255, 255, 1)");
    } else {
      Assertions.assertEquals(driver.findElement(By.xpath("/html/body")).getCssValue("background-color"), "rgb(255, 255, 255)");
    }

    // Настройка светлой/темной тем
    driver.findElement(By.xpath("//div[@id='ph-whiteline']/div/div[2]/div")).click();

    // Темная тема
    driver.findElement(By.xpath("//div[@id='ph-whiteline']/div/div[2]/div[2]/div/div/ul/li[2]/label/div")).click();

    if (driver instanceof ChromeDriver) {
      Assertions.assertEquals(driver.findElement(By.xpath("/html/body")).getCssValue("background-color"), "rgba(25, 25, 26, 1)");
    } else {
      Assertions.assertEquals(driver.findElement(By.xpath("/html/body")).getCssValue("background-color"), "rgb(25, 25, 26)");
    }
  }
}
