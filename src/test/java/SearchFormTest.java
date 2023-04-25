import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchFormTest {
    private WebDriver driver;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testSearchEmptyForm() {
        driver.get("https://mail.ru");

        assertThrows(ElementClickInterceptedException.class, () -> {
            WebElement button = driver.findElement(By.xpath("//button[@class='search-arrow__button']"));
            button.click();
        });

        driver.quit();
    }

    @Test
    public void testSearchFormText() {
        driver.get("https://mail.ru");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='search-arrow__frame']")));
        WebElement searchForm = driver.findElement(By.xpath("//input[contains(@aria-label, 'Запрос')]"));

        searchForm.sendKeys("aksjdhfaksdjhfaksjdhf");
        driver.switchTo().defaultContent();

        WebElement button = driver.findElement(By.xpath("//button[@class='search-arrow__button']"));
        button.click();

        assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlMatches("https://mail.ru/search*")));

        driver.quit();
    }
}
