package testPractices.GroupTekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru2 {
    //1. “https://www.saucedemo.com” Adresine gidin
    //2. Username kutusuna “standard_user” yazdirin
    //3. Password kutusuna “secret_sauce” yazdirin
    //4. Login tusuna basin
    //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    //6. Add to Cart butonuna basin
    //7. Alisveris sepetine tiklayin
    //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
    //9. Sayfayi kapatin
    static WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
    @Test
    public void test() {
        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.name("login-button")).click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        if (driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).isDisplayed())
            System.out.println("The produtc is in the cart");
        else System.out.println("The produtc is not in cart FAILED");
        // WebElement cartEklendiMi = driver.findElement(By.className("shopping_cart_badge"));
        // Assert.assertTrue("basariyla ekledik",cartEklendiMi.isDisplayed());
        //9. Sayfayi kapatin
    }
}

