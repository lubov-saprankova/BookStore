package com.demoqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthTest {   static WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.manage().window(). maximize() ;
        driver.get("https://demoqa.com/login");
    }

    //"Авторизация на сайте "https://demoqa.com/books/login"
    // 1. Ввести логин
    // 2. Ввести пароль
    // 3. код 200

    @Test
    void authTestPositive() throws InterruptedException {


        driver.findElement(By.xpath(" //*[@id='userName']")).sendKeys("LubaSapr");

        driver.findElement(By.xpath(" //*[@id='password']")).sendKeys("26012023Sa@");
        driver.findElement(By.xpath("//*[@id='login']")).click();
        Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='searchBox']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id='searchBox']")).isDisplayed());
    }
    //"Авторизация на сайте "https://demoqa.com/books/login"
    // 1. Ввести невалидный логин
    // 2. проверить ответ по неправильному логину
    @Test
    void authTestNegative() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("LubaSa");

        driver.findElement(By.xpath(" //*[@id='password']")).sendKeys("26012023Sa@");
        driver.findElement(By.xpath("//*[@id='userName-value']")).click();
        Thread.sleep(1000);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='name']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id='name']")).isDisplayed());
    }
    //"Авторизация на сайте "https://demoqa.com/books"
    // 1. Проверка граничного значения, логин оставить пустым
    // 2. Ввести пароль
    // 3. проверить успешность авторизации по появлению заголовка "Books"
    @Test
    void authTestKorner() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("");

        driver.findElement(By.xpath(" //*[@id='password']")).sendKeys("26012023Sa@");
        driver.findElement(By.xpath("//*[@id='userName-value']")).click();
        Thread.sleep(1000);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='searchBox']]")));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id='searchBox']")).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}

