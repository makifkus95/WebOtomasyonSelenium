package com.akif.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductOperations {

    List<WebElement> result;
    WebDriver driver;
    By bySearch = By.id("searchData");
    By byButton = By.className("searchBtn");
    By byPage = By.xpath("//div[@class='pagination']//a[text()='2']");
    private String searchWord = "bilgisayar";

    public ProductOperations(WebDriver driver){
        this.driver = driver;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public void sendAndClickSearch(){
        try {
            driver.findElement(bySearch).sendKeys(searchWord);
            driver.findElement(byButton).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void secondPage(){
        try {
            driver.findElement(byPage).click();
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void productSelect(){
        try {
            result = driver.findElements(By.xpath("//*[@class='listView ']//*[@class='column']/div/div/a/img"));
            Random r = new Random();
            int linkNo= r.nextInt(result.size());
            result.get(linkNo).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
