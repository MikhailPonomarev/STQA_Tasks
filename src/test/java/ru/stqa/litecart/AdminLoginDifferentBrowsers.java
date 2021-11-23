package ru.stqa.litecart;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AdminLoginDifferentBrowsers {
    private WebDriver driver;


    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void LoginFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.cssSelector("[data-type='text']")).sendKeys("admin");
        driver.findElement(By.cssSelector("[data-type='password']")).sendKeys("admin");
        driver.findElement(By.cssSelector("[type='submit']")).click();
    }

    @Test
    public void LoginEdge() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.cssSelector("[data-type='text']")).sendKeys("admin");
        driver.findElement(By.cssSelector("[data-type='password']")).sendKeys("admin");
        driver.findElement(By.cssSelector("[type='submit']")).click();
    }
}
