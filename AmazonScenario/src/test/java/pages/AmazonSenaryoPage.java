package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonSenaryoPage {

    public AmazonSenaryoPage(){ PageFactory.initElements(Driver.getDriver(),this);}

   @FindBy (xpath="//input[@id='sp-cc-accept']")
   public WebElement çerezlerKabulEtElementi;

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    public WebElement merhabaGirisYapinElementi;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailBoxElementi;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement sifreBoxElementi;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    public WebElement girisYapildiKullaniciIsmıElementi;

    @FindBy(xpath = "//select[@id='searchDropdownBox']")
    public WebElement tumKategorilerSelectElementi;

    @FindBy(xpath = "//div[@data-value='search-alias=aps']")
    public WebElement secilenKategorininIsmiElementi;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement seearchBoxElementi;

    @FindBy(xpath = "//span[.='8.000 üzeri sonuç arasından 1-24 arası gösteriliyor. Aranan ürün:']")
    public WebElement aramaSonucuElementi;

    @FindBy(xpath = "(//a[@class='s-pagination-item s-pagination-button'])[1]")
    public WebElement ikinciSayfaElementi;

    @FindBy(xpath = "//span[@aria-current='page']")
    public WebElement bulunanSayfaninNumarsiElementi;

    @FindBy(xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]")
    public WebElement ikinciUrunElementi;

    @FindBy(xpath = "//input[@id='add-to-wishlist-button']")
    public WebElement listeyeEkleAcmaElementi;

    @FindBy(xpath = "//span[@id='atwl-list-name-3LHGCYFH92382']")
    public WebElement favorilerimElementi;

    @FindBy(xpath = "//a[@href='/MSI-KATANA-GF76-11UE-414TR-Diz%C3%BCst%C3%BC-" +
            "Bilgisayar-17-3-FHD-144Hz-Core-I7-11800H-16GB-RAM-RTX3060/dp/B09NLZTR7X/ref=cm_wl_huc_item']")
    public WebElement favorilerimUrunElementi;

    @FindBy(xpath = "(//button[@data-action='a-popover-close'])[2]")
    public WebElement favorilerimListCloseElementi;

    @FindBy(xpath = "//span[text()='Favorilerim']")
    public WebElement hesabımFavorilerimButtonElementi;

    @FindBy (xpath="(//div[@class='wl-list-entry-row-wrapper'])[3]")
    public WebElement favorilerimSayfasiYazisiElementi;

    @FindBy (xpath="//input[@name='submit.deleteItem']")
    public WebElement kaldirButtonElementi;

    @FindBy (xpath="//div[text()='Silindi']")
    public WebElement silindiYazisiElementi;

    @FindBy (xpath="//span[text()='Çıkış Yap']")
    public WebElement cikisYapButtonElementi;

    @FindBy (xpath="//h1[@class='a-spacing-small']")
    public WebElement girisYapYazisiElementi;



}
