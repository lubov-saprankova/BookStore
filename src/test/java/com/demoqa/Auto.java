package com.demoqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Auto {
    @Test
    public void findByIdTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/books");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement clickLogin = driver.findElement(By.id("login"));
        clickLogin.click();

        WebElement userNameInputField = driver.findElement(By.id("userName"));
        userNameInputField.sendKeys("LubaSapr");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("26012023Sa@");
        WebElement submitLogin = driver.findElement(By.id("login"));
        submitLogin.click();

        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.close();

    }


}

