package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() throws MalformedURLException {
        String url = "http:/"+this.getHost()+"/wd/hub";
//        try {
            this.driver = new RemoteWebDriver(new URL(url), this.getDriver());
//        }catch (UnreachableBrowserException e){
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        }
//        this.getDriver();

    }

    private DesiredCapabilities getDriver(){
        DesiredCapabilities dc;
        switch (System.getProperty("BROWSER")) {
            case "firefox":
//                System.setProperty("webdriver.gecko.driver", "/Users/josserestrepo/Study/dockerTesting/src/test/resources/geckodriver");
//                this.driver = new FirefoxDriver();
                dc = DesiredCapabilities.firefox();
                break;
            case "chrome":
            default:
//                System.setProperty("webdriver.chrome.driver", "/Users/josserestrepo/Study/dockerTesting/src/test/resources/chromedriver");
//                this.driver = new ChromeDriver();
                dc = DesiredCapabilities.chrome();
                break;
        }
        return dc;
    }

    private String getHost(){
        if(System.getProperty("HUB_HOST")!=null){
            return System.getProperty("HUB_HOST");
        }else{
            return "localhost";
        }
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }


}
