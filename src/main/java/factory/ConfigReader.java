package factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop = new Properties();

    static {
        try{
            InputStream is = new FileInputStream("src/test/resources/config.properties");
            prop.load(is);
        } catch (Exception e) {
            throw new RuntimeException("Could not load config.properties",e);
        }
    }

    public static String get(String key){
        return prop.getProperty(key);
    }

    public static String getBaseURL(){ return get("base.url");}
    public static String getBrowser(){ return get("browser");}
    public static boolean isHeadless (){ return Boolean.parseBoolean(get("headless"));}
    public static int getImplicitWait(){ return Integer.parseInt(get("implicit.wait"));}
    public static int getExplicitWait(){ return Integer.parseInt(get("explicit.wait"));}

}
