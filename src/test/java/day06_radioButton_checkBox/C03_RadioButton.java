package day06_radioButton_checkBox;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    /*
    1. Bir class oluşturun : RadioButtonTest
2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
-https://www.facebook.com adresine gidin
-Cookies’i kabul edin
-“Create an Account” button’una basin
-“radio buttons” elementlerini locate edin
-Secili degilse cinsiyet butonundan size uygun olani secin
     */
    WebDriver driver;

@Before
    public void testFacebook(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

}
        @After
    public void after(){
   // driver.close();
        }
@Test
//-https://www.facebook.com adresine gidin

public void test01() throws InterruptedException {
    driver.get("https://www.facebook.com");


    //-Cookies’i kabul edin
    driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();



//-“Create an Account” button’una basin
    driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();
//-“radio buttons” elementlerini locate edin
    WebElement kadin=driver.findElement(By.xpath("//*[text()='Kadın']"));
    WebElement maleButton=driver.findElement(By.xpath("(//label[@class='_58mt'])[2]"));
    WebElement ozelButton=driver.findElement(By.xpath("(//label[@class='_58mt'])[3]"));
//-Secili degilse cinsiyet butonundan size uygun olani secin
    if(!kadin.isSelected()){
        kadin.click();
        Thread.sleep(2000);
    }
    if(!maleButton.isSelected()){
        maleButton.click();
        Thread.sleep(2000);

    }
    if(!ozelButton.isSelected()){
        ozelButton.click();
        Thread.sleep(2000);

    }
}

}














