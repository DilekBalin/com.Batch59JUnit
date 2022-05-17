package day08_allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Allerts {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void test01() {
       /*
        //herhangi bir web sitesine gidince veya
          //bir web sitesinde herhaangi bir islem yaptigimizda ortaya cikan uyarilara alert diyoruz

          Eger bir alert inspect yapilabiliyorsa o alert otomaston ile kullanilabilir
          bu tur alert'lere HTML alert denir ve bunlar icin ekstra bir islem yapmaya gerek yoktur
          tum elementler gibi locaate edip istedgimixz islemleri yapabiliriz

          Ancak web uygulamalarinda HTML  alert yaninda java script alertde bulunabilir
          js alert'ler locate edilemez
          Selenium'da JS alert'ler icin ozel bir yontem gelistirmistir



                  */


        driver.get("https://www.facebook.com");
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        //alert'te ok tusuna basin
        driver.switchTo().alert().accept();
        //  result kisminda "You successfully clicked an alert" yazdigini test edin
        String expectedResult="You successfully clicked an alert";
        WebElement sonucYazielementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultYazisi=sonucYazielementi.getText();
        Assert.assertEquals(expectedResult,actualResultYazisi);

    }
}
