package ru.stqa.litecart;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class AdminSidebar {
    private WebDriver driver;
    public WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUpChromeDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.cssSelector("[data-type='text']")).sendKeys("admin");
        driver.findElement(By.cssSelector("[data-type='password']")).sendKeys("admin");
        driver.findElement(By.cssSelector("[type='submit']")).click();

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
    }


    @Test
    @DisplayName("Should click all Side Buttons and their Sub Categories")
    public void test() {
        List<WebElement> sideButtons = driver.findElements(By.cssSelector("[id='app-']"));

        for (int i = 0; i < sideButtons.size(); i++) {
            sideButtons = driver.findElements(By.cssSelector("[id='app-']"));
            sideButtons.get(i).click();
            String actualTagName = driver.findElement(By.tagName("h1")).getTagName();
            Assertions.assertEquals("h1", actualTagName);
            List <WebElement> subCategories = driver.findElements(By.cssSelector("[id*=doc]"));
            if (subCategories.size() > 0) {
                for (int j = 0; j < subCategories.size(); j++) {
                    subCategories = driver.findElements(By.cssSelector("[id*=doc]"));
                    subCategories.get(j).click();
                    String actualSubTagName = driver.findElement(By.tagName("h1")).getTagName();
                    Assertions.assertEquals("h1", actualSubTagName);
                }
            }
        }
        driver.findElement(By.cssSelector("[title='Logout']"));
    }
}
