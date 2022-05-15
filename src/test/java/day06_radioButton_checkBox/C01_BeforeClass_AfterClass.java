package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClass_AfterClass {
/*
@beforeClass ve@AfterClass notasyonlari sadece statc methodlar icin calisiri
 */

   static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        //her methodun basinda @Before sonunda @After method call var gibidir
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test02() {
        driver.get("https://techproeducation.com");

    }

    @Test
    public void test03() {
        driver.get("https://facebook.com");

    }

}
