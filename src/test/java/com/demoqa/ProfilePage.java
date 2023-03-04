package com.demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.awt.*;


@Test
public class ProfilePage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public ProfilePage(WebDriver driver, WebElement title) {
        Title = title;
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    /**
     * определение локатора меню пользователя
     */
    @FindBy(xpath = "//*[@id='app']/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[1]")
    private WebElement Title;
    /**
     * определение локатора кнопки выхода из аккаунта
     */
    @FindBy(xpath = "document.querySelector(\"#submit\")")
    private WebElement logoutBtn;


    public void userLogout() {
        logoutBtn.click(); }


    }

