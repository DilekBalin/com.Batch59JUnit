package day05_jUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeAfter {

    WebDriver driver;   //drıver butun methodlarda calısır buraya yazdıgımız ıcın

    @Before
   public void setUp(){
       WebDriverManager.chromedriver().setup();   //ayarlar yapildi
        driver= new ChromeDriver();//atama yapildi
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   }
   @After
public void tearDown(){
        driver.close();
}
    @Test
    public void test01(){
        //her methodun basinda @Before sonunda @After method call var gibidir
        driver.get("https://www.amazon.com");
    }
@Test
    public void test02(){
        driver.get("https://techproeducation.com");

    }
@Test
    public void test03(){
        driver.get("https://facebook.com");

}

}
