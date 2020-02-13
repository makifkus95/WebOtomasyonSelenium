package com.akif.test;

import com.akif.selenium.BaskedOperation;
import com.akif.selenium.LoginPage;
import com.akif.selenium.N11Home;
import com.akif.selenium.ProductOperations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestN11Project {
    WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\chrome-driver\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @Test
    public void start() {
        N11Home n11App = new N11Home(driver);
        /* www.n11.com sitesi açılır. */
        n11App.gotoN11();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.n11.com/");
        /* Ana sayfanın açıldığı kontrol edilir. Siteye login olunur. */
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("m.akif.kus95@gmail.com");
        loginPage.setPass("xxxxxxxx");
        loginPage.loginN11();
        /* kullanıcı ismi ile Login işlemi kontrol edilir. */
        Assert.assertEquals(loginPage.loginControl(),"mehmet akif kuş");
        /* Arama kutucuğuna 'bilgisayar' kelimesi girilir. */
        ProductOperations productOperations = new ProductOperations(driver);
        productOperations.setSearchWord("bilgisayar");
        productOperations.sendAndClickSearch();
        /* Arama sonuçları sayfasından 2.sayfa açılır. */
        productOperations.secondPage();
        /* 2.sayfanın açıldığı kontrol edilir. */
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.n11.com/arama?q=bilgisayar&pg=2");
        /* Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir. */
        productOperations.productSelect();

        BaskedOperation baskedOperation = new BaskedOperation(driver);
        /* Rastgele Seçilen ürün sepete eklenir.*/
        baskedOperation.addBasked();
        /* Sepet görüntülenir */
        baskedOperation.goToBasked();
        /* Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır. */
        Assert.assertEquals(baskedOperation.getBaskedPrice(),baskedOperation.getProductPrice());
        /* Adet arttırılarak ürün adedinin 2 olduğu doğrulanır. */
        baskedOperation.baskedProductUp();
        Assert.assertEquals(baskedOperation.baskedProductUpControl(),"2");
        /* Ürün sepetten silinerek sepetin boş olduğu kontrol edilir. */
        baskedOperation.baskedProductRemove();
        Assert.assertEquals(baskedOperation.productRemoveControl(),"Sepetiniz Boş");

        System.out.println("Successful");
    }



}
