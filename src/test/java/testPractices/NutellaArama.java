package testPractices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NutellaArama {
    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void after() {
         driver.close();
    }

    @Test
    public void testNutella() {

        //1. https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //2.cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//*[text()='Kabul ediyorum']")).click();

        //3.sayfa basliginin "Google" ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectTite = "Google";

        if (actualTitle.contains(expectTite)) {
            System.out.println(actualTitle + " , " + expectTite + " ' iceriyor.Test PASSED");
        } else {
            System.out.println(actualTitle + " , " + expectTite + " ' icermiyor.Test FAILED");
        }


        //4.Arama cubuguna "NUtella " yazip aratin
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));

        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //5.Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String sonuc = sonucSayisi.getText();
        System.out.println(sonuc);  //Yaklaşık 1.510.000.000 sonuç bulundu (0,30 saniye)

        //6.sonuc sayisinin 10 milyondan fazla oldugunu test edin


        String[] arr = sonuc.split(" ");
        arr[1] = arr[1].replaceAll("\\D", "");
        String deger = arr[1]; //77400000
        int degerInt = Integer.parseInt(deger); //Integer deger : 77400000
        System.out.println("Integer deger : "+degerInt);
        System.out.println(degerInt > 10000000 ? "10M´dan büyük" : "10M´dan kücük");











       //7.sayfayi kapatin

    }

}