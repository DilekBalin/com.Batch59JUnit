package testPractices;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class task2 {
    WebDriver driver;
    @Before
    public void method1() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void method2() {
        driver.close();
    }
    @Test
    public void run() {
        //1- https://www.saucedemo.com adresine gidin
        driver.get("https://www.saucedemo.com");
        //2- Username kutusuna "standard_user" yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //3- Password kutusuna "secret_sauce" yazdirin
        driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]")).sendKeys("secret_sauce");
        //4- Login tusuna basin
        driver.findElement(By.xpath("//input[@name='login-button']")).click();
        //5- Ilk ürünün ismini kaydedin ve bu ürünün sayfasina gidin
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).click();
        //6- Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //7- Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();
        //8- Sectiginiz ürünün basarili olarak sepete eklendigini kontrol edin
       if(driver.findElement(By.xpath("//button[@id='checkout']")).isDisplayed()){
            System.out.println("Urun sepette,Test PASSED");
        }else System.out.println("Urun yok,Test FAILED");
       // System.out.println(driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).isDisplayed() ? "Sepete ekleme testi PASSED" : "Sepete ekleme testi FAILED");

    }
}
