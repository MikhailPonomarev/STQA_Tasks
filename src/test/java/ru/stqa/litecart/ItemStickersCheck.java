package ru.stqa.litecart;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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


    @Test
    public void createCustomerUser() {
        driver.findElement(By.cssSelector(".category-1")).click();
        List<WebElement> products = driver.findElements(By.cssSelector(".product"));

        for (int i = 0; i < products.size(); i++) {
            products = driver.findElements(By.cssSelector(".product"));
            products.get(i).click();
            List<WebElement> stickers = driver.findElements(By.cssSelector(".images-wrapper a > [class*=sticker]"));
            if (stickers.size() == 1)
                driver.findElement(By.cssSelector(".category-1")).click();
        }
    }
}

