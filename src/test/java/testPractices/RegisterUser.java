package testPractices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RegisterUser {
    //1. Launch browser
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //driver.close();
    }

    //2.2. Navigate to url 'http://automationexercise.com'

    @Test
    public void test01() {
        driver.get("https:automationexercise.com");

        //3. Verify that home page is visible successfully
        if (driver.findElement(By.xpath("//i[@class='fa fa-home']")).isDisplayed()) {
            System.out.println("passed");
        } else {
            System.out.println("Failed");
        }
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        if (driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed()) {
            System.out.println("New user sign up test PASSED");
        } else {
            System.out.println("New user sign up test FAILED");
        }

        //6. Enter name and email address
       driver.findElement(By.xpath("//input[@name='name']"+Keys.ENTER));

        driver.findElement(By.xpath("//input[@data-qa='login-email']"+Keys.ENTER));


       //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[text()='Signup']")).click();
        }

    }






