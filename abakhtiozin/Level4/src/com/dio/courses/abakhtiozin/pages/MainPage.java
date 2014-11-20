package com.dio.courses.abakhtiozin.pages;

import com.dio.courses.abakhtiozin.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Heroboes on 20.12.13.
 */
public class MainPage extends AnyPage {

    @FindBy(xpath = "html/body/div[@class = 'section_nav']/ul/li[@class = 'sn_menu_item _current']/a")
    public WebElement currentPage;

    @FindBy(xpath = "html/body/div[4]/ul/*/a[text()='Конвертер валют']")
    public WebElement currencyConverterLink;




    public  CurrencyConverterPage goToConverterPage(){
        currencyConverterLink.click();
        return MyPageFactory.getPage(driver,CurrencyConverterPage.class);
    }

    public boolean isOnThisPage(){
        return currentPage.getAttribute("href").equals(new TestBase().getBaseUrl());
    }

    @Override
    void tryToOpen() {
        MyPageFactory.getPage(driver, MainPage.class);
    }
}
