import org.example.Elements;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertThat;

public class TestElements {

    public static WebDriver driver;
    private static String baseUrl;
    public static Elements elementPage; //Modelimizin bulunduğu paket dosyası

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Uveys\\IdeaProjects\\deneme4\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://e-bebek.com";
        //Driver elementlere erişim için 10 sn bekleme süresi tanınır
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        //Sayfaların beklenmesi için süre aşağıdaki gibi tanınır
        driver.manage().timeouts().pageLoadTimeout(200, SECONDS);

        elementPage = new Elements(driver);
    }

    @Test
    public void testUyeol() throws Exception {

        driver.get(baseUrl);
        JavascriptExecutor js = ((JavascriptExecutor) driver);

        //Pencere boyutu maksimuma çıkarılır.
        driver.manage().window().maximize();
        Thread.sleep(5000);

        //Çıkan anket kapatılır.
        elementPage.popUpClose().click();
        //SearchBox içeriği temizlenir.
        elementPage.txtSearchBox().clear();
        //İlgili arama kelimesi yazılır.
        elementPage.txtSearchBox().sendKeys("kaşık maması");
        //Enter tuşu ile arama yapılır.
        elementPage.txtSearchBox().sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        //Sayfada aşağı inip son ürünü bul.
        js.executeScript("window.scrollTo(0,768)");
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0,1900)");
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0,3300)");
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0,5000)");
        Thread.sleep(1000);

        //Tıklanacak ürünün text içeriği alınır.
        String s1=elementPage.product1().getText();
        //System.out.println(s1);


        //Ürün sayfasına gidilir.
        elementPage.product().click();
        Thread.sleep(3000);


        //Açılan sayfadaki ürünün text içeriği alınır.
        String s2=elementPage.product2().getText();
        //System.out.println(s2);
        Thread.sleep(2000);

        //İki ürünün aynı olup olmaması kontrol edilir.
        if (!(s1.equals(s2))){
            System.out.println("KARŞILAŞTIRILAN ÜRÜNLER AYNI DEĞİL.");
            finish();
        }else{
            System.out.println("KARŞILAŞTIRILAN ÜRÜNLER AYNI.");
        }
        //Sepete ekle butonuna tıklanır.
        elementPage.addCartButton().click();
        Thread.sleep(2000);
        //Sepete git butonuna tıklanır.
        elementPage.btnShowCart().click();
        Thread.sleep(2000);
        //Alışverişi tamamla butonunu tıklanır.
        elementPage.completeShoppingBtn().click();
        Thread.sleep(2000);
        //Üyelik sayfasının açılıp açılmadığı kontrolü
        {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-untouched > .title-primary")));
        }
        assertThat(driver.findElement(By.cssSelector(".ng-untouched > .title-primary")).getText(), is("Üyelik"));
    }

    @After
    public void finish(){
        driver.quit();
    }

}