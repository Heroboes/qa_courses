package com.dio.courses.abakhtiozin.pages;

import com.dio.courses.abakhtiozin.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Heroboes on 20.12.13.
 */
public class MainPage extends AnyPage {

    @FindBy(css = "#content>div>h1")
    public WebElement currentPage;

//    @FindBy(xpath = ".//*[@id='header_form:j_idt9']/ul/li[1]/ul/li[1]/ul/li[1]/a/span")
//    public WebElement hotelLink;

    private String welcome = "Welcome! Use top menu for start working with the application!";


    public HotelPage goToHotelPage(){
        driver.get(new TestBase().getBaseUrl()+"faces/hotel.xhtml");
        return MyPageFactory.getPage(driver,HotelPage.class);
    }

    public boolean isOnThisPage(){
        return currentPage.getText().equals(welcome);
    }

    @Override
    void tryToOpen() {
        MyPageFactory.getPage(driver, MainPage.class);
    }
}
