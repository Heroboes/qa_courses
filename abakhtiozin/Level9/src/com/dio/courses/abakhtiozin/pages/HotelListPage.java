package com.dio.courses.abakhtiozin.pages;

import com.dio.courses.abakhtiozin.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by e.briginets on 30.10.2014.
 */
public class HotelListPage extends AnyPage{

    @FindBy(xpath = ".//*[@id='j_idt40']")
    public WebElement hotelListSection;

    public boolean isOnThisPage(){
        return hotelListSection.isDisplayed();
    }

    @Override
    void tryToOpen() {

    }
}
