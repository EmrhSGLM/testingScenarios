package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AmazonSenaryoPage;
import utilities.ConfigReader;
import utilities.Driver;

public class AmazonSenarcioTesting {

    AmazonSenaryoPage amazonPage;

    @Test
    public void amazonSenarcio() throws InterruptedException {

        amazonPage = new AmazonSenaryoPage();

        // https://www.amazon.com.tr/ sitesi açılır
        Driver.getDriver().get(ConfigReader.getProperty("AmazonURL"));

        //Ana sayfanın açıldığı kontrol edilir.
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl=ConfigReader.getProperty("AmazonURL");
        Assert.assertEquals("Amazon sayfasına gidilememiştir",expectedUrl,actualUrl);

        // Çerez tercihlerinden Çerezleri kabul et seçilir.
        amazonPage.çerezlerKabulEtElementi.click();

        // Siteye login olunur.
        amazonPage.merhabaGirisYapinElementi.click();
        amazonPage.emailBoxElementi.sendKeys(ConfigReader.getProperty("kullaniciEmail"), Keys.ENTER);
        amazonPage.sifreBoxElementi.sendKeys(ConfigReader.getProperty("kullaniciSifre"), Keys.ENTER);

        // Login işlemi kontrol edilir.
        String actualKullaniciIsmi=amazonPage.girisYapildiKullaniciIsmıElementi.getText();
        String expectKullaniciİsmi=ConfigReader.getProperty("kullaniciIsmi");
        Assert.assertEquals("Giris yapilamadi", expectKullaniciİsmi, actualKullaniciIsmi);

        //Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
        Select options = new Select(amazonPage.tumKategorilerSelectElementi);
        options.selectByVisibleText("Bilgisayarlar");
        String expectedKategoriIsmi=ConfigReader.getProperty("secilenKategori");
        String actualKategoriIsmi=amazonPage.secilenKategorininIsmiElementi.getText();
        Assert.assertEquals("Yanlis kategori secilmis", expectedKategoriIsmi, actualKategoriIsmi);

        //Arama alanına msi yazılır ve arama yapılır.
        amazonPage.seearchBoxElementi.sendKeys(ConfigReader.getProperty("aranacakKelime"), Keys.ENTER);

        //Arama yapıldığı kontrol edilir.
        String actualSonuc=amazonPage.aramaSonucuElementi.getText();
        String expectedSonuc=ConfigReader.getProperty("aranacakKelime");
        Assert.assertTrue("Istenen kelime aranmadi", actualKategoriIsmi.contains(expectedKategoriIsmi));

        //Arama sonuçları sayfasından 2. sayfa açılır.
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();", amazonPage.ikinciSayfaElementi);

        //2. sayfanın açıldığı kontrol edilir.
        String actualSayfaNu=amazonPage.bulunanSayfaninNumarsiElementi.getText();
        String expectedSayfaNu="2";
        Assert.assertEquals("2. sayfaya gidilmedi", actualSayfaNu, expectedSayfaNu);

        //Sayfadaki 2. ürün favorilere eklenir.
        String expectedUrunIsmi=amazonPage.ikinciUrunElementi.getText();
        amazonPage.ikinciUrunElementi.click();
        amazonPage.listeyeEkleAcmaElementi.click();
        amazonPage.favorilerimElementi.click();

        //2. Ürünün favorilere eklendiği kontrol edilir.
        String actualFavorilerimUrunIsmi=amazonPage.favorilerimUrunElementi.getText();
        Assert.assertEquals("Istenilen uruk favorilerime eklenememistir",
                expectedUrunIsmi, actualFavorilerimUrunIsmi);

        //Hesabım > Favori Listem sayfasına gidilir.
        amazonPage.favorilerimListCloseElementi.click();
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(amazonPage.merhabaGirisYapinElementi).perform();
        amazonPage.hesabımFavorilerimButtonElementi.click();

        //“Favori Listem” sayfası açıldığı kontrol edilir.
        Assert.assertTrue("Favorilerim sayfasi acilmadi", amazonPage.favorilerimSayfasiYazisiElementi.isDisplayed());

        //Eklenen ürün favorilerden silinir.
        amazonPage.kaldirButtonElementi.click();

        //Silme işleminin gerçekleştiği kontrol edilir.
        Assert.assertTrue("Silinme islemi gerceklesmedi", amazonPage.silindiYazisiElementi.isDisplayed());

        //Üye çıkış işlemi yapılır.
        actions.moveToElement(amazonPage.merhabaGirisYapinElementi).perform();
        amazonPage.cikisYapButtonElementi.click();

        //Çıkış işleminin yapıldığı kontrol edilir
        Assert.assertTrue("Cikis yapilamadi", amazonPage.girisYapYazisiElementi.isDisplayed());

        //Browser kapatilir
        Thread.sleep(2000);
        Driver.closeDriver();

    }
}
