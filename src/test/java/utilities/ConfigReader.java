package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static   Properties properties ;
    /*
    Methodu devreye sokabilmek için FileInputStream ile dosya yolunu belirtmemiz gerekir
    methoddan once calısması ıcın static blok ıcerisine FileInputStream 'i olusturmamız gerekir.
     */
    static {
        String dosyaYolu ="config.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            properties= new Properties();
            properties.load(fis);//fis'in okudugu bilgileri properties'e yükler
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key){

        /*
            Test methodundan gönderdiğimiz string key degerini alıp Properties class'ından
            getProperty() methodunu kullanarak bu key'e ait value'u bize getirir.
         */
        return properties.getProperty(key);

    }










}
