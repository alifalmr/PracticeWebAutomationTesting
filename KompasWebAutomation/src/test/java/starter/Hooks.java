package starter;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver webDriver;

    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\driver\\chromedriver.exe");


//        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "driver/chromedriver");

        webDriver = new ChromeDriver();
        String appUrl= "https://www.kompas.com/";
        webDriver.get(appUrl);
        webDriver.manage().window().maximize();
//        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);;

    }

    @After
    public void closeBrowser(){
        if (webDriver != null) {
            webDriver.quit();};
    }
}
