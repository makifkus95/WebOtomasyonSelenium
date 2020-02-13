package com.akif.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaskedOperation {

    WebDriver driver;
    By byBasked = By.xpath("//*[@class='btn btnGrey btnAddBasket']");
    By byProductPrice = By.xpath("//*[@class='newPrice']/ins");
    By byGotoBasked = By.xpath("//*[@class='myBasket']");
    By byBaskedProductPrice = By.xpath("//*[@class='priceArea']/span");
    By byBaskedProductUp = By.xpath("//*[@class='spinnerUp spinnerArrow']");
    By byRemoveProduct = By.xpath("//*[@class='removeProd svgIcon svgIcon_trash']");
    private static String baskedPrice;
    private static String productPrice;

    public BaskedOperation(WebDriver driver){
        this.driver = driver;
    }

    public String getBaskedPrice() {
        return baskedPrice;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void addBasked(){
        productPrice = driver.findElement(byProductPrice).getText();
        driver.findElement(byBasked).click();
    }

    public void goToBasked(){
        try {
            Thread.sleep(2000);
            driver.findElement(byGotoBasked).click();
            baskedPrice = driver.findElement(byBaskedProductPrice).getText();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void baskedProductUp(){

        try {
            driver.findElement(byBaskedProductUp).click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String baskedProductUpControl(){

        String control = driver.findElement(By.xpath("//*[@class='spinnerField ']/input")).getAttribute("value");
        return control;
    }

    public void baskedProductRemove(){
        try {
            driver.findElement(byRemoveProduct).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String productRemoveControl(){
        String control = driver.findElement(By.xpath("//*[@class='cartEmptyText']/h2")).getText();
        return control;
    }
}
