package day11_fakerFile;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist extends TestBase {

    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));
        // bana icinde oldugum projenin dosy yoliunu(path) verir
        // C:\Users\dilek\IdeaProjects\com.Batch59JUnit
        System.out.println(System.getProperty("user.home"));
        // C:\Users\dilek  yani benim bilgisayarimin bana ozel kismini verdi
        // "C:\Users\dilek\Downloads"

        // homePath + "/Downloads"
        // Masa ustumuzdeki text dosyasinin varligini test edin
        // "C:\Users\dilek\Desktop\text.txt"
        String dosyaYolu= System.getProperty("user.home")+ "\\Desktop\\text.txt";
        System.out.println(dosyaYolu);
        /*
        Bilgisayarimizdaki bir dosyanin varligini test etmek icin
        once o dosyaya ulasmamiz gerekir
        Java'da dosyaya erisim icin dosya yoluna (path) ihtiyac vardir
        Her bilgisayarin kullanici adi farkli olacagindan
        masaustu dosya yolu da birbirinden farkli olacaktir
        Testlerimizin tum bilgisayarlarda calismasi icin dosya yolunu DINAMIK yapmak zorundayiz
        Bunun icin
         her bilgisayarin birbirinden farkli olan yolunu bulmak icin
         */
        String farkliKisim= System.getProperty("user.home");
        // herkesin bilgisayarinda ortak olan kisim ise
        String ortakKisim="\\Desktop\\text.txt";
        // mac icin   "/Desktop/text"
        String masaustuDosyaYolu=farkliKisim+ortakKisim ;
        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));
    }
}
