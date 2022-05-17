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

public class SlaytPage79 {
    /*
    1. http://zero.webappsecurity.com sayfasina gidin
2. Signin buttonuna tiklayin
3. Login alanine “username” yazdirin
4. Password alanine “password” yazdirin
5. Sign in buttonuna tiklayin
6. Pay Bills sayfasina gidin
7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
8. tarih kismina “2020-09-10” yazdirin
9. Pay buttonuna tiklayin
10. “The payment was successfully submitted.” mesajinin ciktigini control edin
     */
WebDriver driver;
@Before
    public void before(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

}
@After
    public void after(){
    driver.close();
}


@Test
    public void test01(){
  //  1. http://zero.webappsecurity.com sayfasina gidin
    driver.get("http://zero.webappsecurity.com");
//    2. Signin buttonuna tiklayin
    driver.findElement(By.xpath("//button[@id='signin_button']")).click();
  //  3. Login alanine “username” yazdirin
    //  driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
    driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

    //4. Password alanine “password” yazdirin
    driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
    //5. Sign in buttonuna tiklayin
    driver.findElement(By.xpath("//input[@type='submit']")).click();
    driver.navigate().back();
    //6. Pay Bills sayfasina gidin
    driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
    driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();

    //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
    driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("200");
    //8. tarih kismina “2020-09-10” yazdirin
    driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");
    //9. Pay buttonuna tiklayin
    driver.findElement(By.xpath("//input[@value='Pay']")).click();

    //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
    WebElement text=driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
    String actualText= text.getText();
    String expectedText="The payment was successfully submitted.";
    Assert.assertEquals(expectedText, actualText);
/*

        //Bulunan sonuc sayisini yazdirin
        WebElement bulunanSonuc=driver.findElement(By.xpath("//div[@id='result-stats']"));
        String arr[]=bulunanSonuc.getText().split(" ");
 */
}

}


