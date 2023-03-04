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

public class MyTest {
    static WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    void setupBrowser()  {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.manage().window(). maximize() ;
        driver.get("https://test-stand.gb.ru/login");

        driver.findElement(By.xpath("//input[contains(@type, 'text')]")).sendKeys("GB202301271f40");

        driver.findElement(By.xpath("//input[contains(@type, 'password')]")).sendKeys("f27eb83c60");
        driver.findElement(By.xpath("//span[contains(@class, 'mdc-button__label')]")).click();
        //  Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(@class, 'svelte-1e9zcmy')]")));
        Assertions.assertTrue(driver.findElement(By.xpath("//h1[contains(@class, 'svelte-1e9zcmy')]")).isDisplayed());
    }


    //"Переход на страницу с постами" со странице Авторизации
    //1. Навести кнопку мыши на пост
    //2. Выбрать пост и перейти на него
    //3. Убедиться, что верно перешли на раздел посты сравнив url
    @Test
    void goToPreviousNextPageTest() throws InterruptedException {
        driver.findElement(By.xpath("//a[.='Next Page']")).click();
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getCurrentUrl().contains("page=2"));
        driver.findElement(By.xpath("//a[.='Previous Page']")).click();
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getCurrentUrl().contains("page=1"));
    }
    @Test
    void ImgPostTest()  {
        Assertions.assertTrue(driver.findElement(By.xpath("//img[contains(@class, 'svelte-127jg4t')]")).isDisplayed());
    }
    @Test
    void NamePostTest() {
        Assertions.assertTrue(driver.findElement(By.xpath("//h2[contains(@class, 'svelte-127jg4t')]")).isDisplayed());
    }
    @Test
    void DescriptionPostTest()  {
        Assertions.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'description')]")).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}


