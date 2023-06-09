import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewsRedirectTest {

    private WebDriver driver;

    @BeforeAll
    public static void setup() {
        String value_name = System.getenv("DRIVER");
        if (value_name != null && value_name.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
        } else {
            WebDriverManager.chromedriver().setup();
        }
    }

    @BeforeEach
    public void setupDriver() {
        String value_name = System.getenv("DRIVER");

        if (value_name != null && value_name.equals("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @Test
    public void testNewsRedirect() {
        driver.get("https://mail.ru");
        driver.findElement(
                By.xpath("//div[@data-testid='news-tabs']" +
                        "/a[@data-testid='news-tabs-tab-item-main']")).click();


        ArrayList<String> multiWindow = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(multiWindow.get(1));
        assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlMatches("https://news.mail.ru*")));

    }


}
