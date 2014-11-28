package com.dio.courses.abakhtiozin.tests;

import com.dio.courses.abakhtiozin.WebDriverFactory;
import com.dio.courses.abakhtiozin.pages.MainPage;
import com.dio.courses.abakhtiozin.pages.MyPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

/**
 * Created by AA on 25.10.2014.
 */
public class TestBase {
    public WebDriver driver;
    private static final String BaseUrl = "http://finance.i.ua/";

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/google-chrome/chromedriver");
        driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public MainPage goToMainPage() {
        driver.get(BaseUrl);
        return MyPageFactory.getPage(driver, MainPage.class);
    }



    public String getBaseUrl(){
        return BaseUrl;
    }

}
