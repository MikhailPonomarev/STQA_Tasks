package ru.stqa.litecart;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class ItemStickersCheck {
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
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("[data-type='text']")).sendKeys("1@somemail.com");
        driver.findElement(By.cssSelector("[data-type='password']")).sendKeys("pass");
        driver.findElement(By.cssSelector("[name='login']")).click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    @Disabled
    @Test
    @DisplayName("Should ckeck all stickers on the products")
    public void stickersCheck() {
        List<WebElement> products = driver.findElements(By.cssSelector(".product"));
        List<WebElement> stickers;

        int i = 0;

        for (WebElement element : products) {
            stickers = element.findElements(By.cssSelector(".sticker"));
            if (stickers.size() == 1) {
                i++;
            }
        }
        Assertions.assertEquals(products.size(), i);
    }
}

