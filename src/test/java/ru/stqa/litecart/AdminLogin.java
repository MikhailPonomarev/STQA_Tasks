package ru.stqa.litecart;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminLogin {
    private WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUpChromeDriver() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void shouldLoginToAdminPage() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.cssSelector("[data-type='text']")).sendKeys("admin");
        driver.findElement(By.cssSelector("[data-type='password']")).sendKeys("admin");
        driver.findElement(By.cssSelector("[type='submit']")).click();
    }
}
