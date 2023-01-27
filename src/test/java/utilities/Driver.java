package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Driver {
    /*
    Driver daki temel mantık extents yontemi ile degil TestBase classına extent etmek yerine
     Driver Clasından statik methodlar kullanara driver olustururuz.
     1- İlk olarak public static WebDriver getDriver () methodu olusturmak.Bu method bize bir driver getirecek
     2- Driver'i kapatacagımız zaman zaman da public static void closeDriver() methodu olusturmak.Istedigimiz zamana bu methodla driveri kapatacagız
     */
    static WebDriver driver;
    public static WebDriver getDriver(){
        if (driver==null){//eger driver'a deger atanmamıs ise(driver null ise) deger ata,
            // eger deger atanmıssa driveri aynı sayfada return et
            switch (ConfigReader.getProperty("browser")){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

            }
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }

    public static void closeDriver(){
        if (driver!=null){ //driver a deger atanmıs ise kapat
            driver.close();
            driver=null;
        }

    }

    public static void quitDriver(){
        if (driver!=null){ //driver a deger atanmıs ise kapat
            driver.close();
            driver=null;
        }

    }








}
