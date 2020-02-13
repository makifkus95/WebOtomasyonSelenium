package com.akif.selenium;

import org.openqa.selenium.WebDriver;

public class N11Home
{
    WebDriver driver;

    public N11Home(WebDriver driver){
        this.driver = driver;
    }

    public void gotoN11(){
        driver.get("https://www.n11.com/");
    }

}
