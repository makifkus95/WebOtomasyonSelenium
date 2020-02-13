package com.akif.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static String email;
    private static String pass;
    WebDriver driver;
    By byEmail = By.id("email");
    By byPass = By.id("password");
    By byButton = By.id("loginButton");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void loginN11(){
        try {
            driver.findElement(By.className("btnSignIn")).click();
            Thread.sleep(3000);
            driver.findElement(byEmail).sendKeys(email);
            driver.findElement(byPass).sendKeys(pass);
            driver.findElement(byButton).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public String loginControl(){
        String byLoginControl = driver.findElement(By.xpath("//*[@class='myAccount']//a[@class='menuLink user']")).getText();
        return byLoginControl;

    }
}
