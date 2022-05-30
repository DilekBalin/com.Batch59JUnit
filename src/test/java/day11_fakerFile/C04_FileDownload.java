package day11_fakerFile;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownloadBIRDAHABAK extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //1. Tests packagenin altina bir class oluşturalim
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3.LambdaTest.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='LambdaTest.txt']")).click();

        Thread.sleep(5000);
        //4. dosyanın başarıyla indirilip indirilmediğini test edelim
        // dosya downloads'a indirilecektir, bize downloads'un dosya yolu lazim

        String farkliKisim= System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\LambdaTest.txt";

        String arananDosyaYolu= farkliKisim+ortakKisim;

        // geriye o dosya yolundaki dosyanin var oldugunu assert edelim
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));











    }
}
