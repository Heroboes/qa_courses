package com.dio.courses.abakhtiozin.pages;

import com.dio.courses.abakhtiozin.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by serg on 28.10.14.
 */
public class HotelPage extends AnyPage {

    @FindBy(xpath = "//span[text()='Data:']/..")
    public WebElement dataSection;

    @FindBy(xpath = "//span[text()='Save']/..")
    public WebElement saveButton;

    @FindBy(xpath = "//label[text()='Name:']/span[text()='*']")
    public WebElement nameFieldAsterisk;

    @FindBy(xpath = ".//*[@id='add_hotel:name']")
    public WebElement nameField;

    @FindBy(xpath = "//span[text()='Name: Validation Error: Value is required.']")
    public WebElement nameErrorMessage;

    @FindBy(xpath = ".//*[@id='add_hotel:rate']")
    public WebElement globalRating;

    @FindBy(xpath = ".//*[@id='add_hotel:rate']/div[@class='ui-rating-cancel']/a")
    public WebElement globalRatingCancel;

    @FindBy(xpath = ".//*[@id='add_hotel:rate_input']")
    public WebElement globalRatingStars;

    @FindBy(xpath = ".//*[@id='add_hotel:dateOfConstruction_input']")
    public WebElement dateOfConstruction;

    @FindBy(xpath = "//label[text()='Date of Construction:']/span[text()='*']")
    public WebElement dateOfConstructionAsterisk;

    @FindBy(xpath = ".//span[text()='Date of Construction: Validation Error: Value is required.']")
    public WebElement dateOfConstructionWrongDateFormat;

    @FindBy(xpath = ".//label[text()='Country:']/span[text()='*']")
    public WebElement countryFieldAsterisk;

    @FindBy(xpath = ".//*[@id='add_hotel:country_label']") 
    public WebElement countryField;

    @FindBy(xpath = ".//*[@id='add_hotel:country']/div[3]/span")
    public WebElement countryFieldSelect;

    @FindBy(xpath = "//span[text()='Country: Validation Error: Value is required.']")
    public WebElement countryFieldErrorMessage;

    @FindBy(xpath = "//label[text()='City:']/span[text()='*']")
    public WebElement cityAsterisk;

    @FindBy(xpath = "//span[text()='City: Validation Error: Value is required.']")
    public WebElement cityErrorMessage;

    @FindBy(xpath = ".//*[@id='add_hotel:city_label']")
    public WebElement cityField;

    @FindBy(xpath = ".//*[@id='add_hotel:city']/div[3]/span")
    public WebElement cityFieldSelect;

    @FindBy(xpath = "//label[text()='Short Description:']/span[text()='*']")
    public WebElement shortDescriptionAsterisk;

    @FindBy(xpath = ".//*[@id='add_hotel:short_description']")
    public WebElement shortDescriptionField;

    @FindBy(xpath = "//span[text()='Short Description: Validation Error: Value is required.']")
    public WebElement shortDescriptionErrorMessage;

    @FindBy(xpath = "//label[text()='Description:']/span[text()='*']")
    public WebElement descriptionAsterisk;

    @FindBy(xpath = ".//*[@id='add_hotel:description']")
    public WebElement descriptionField;

    @FindBy(xpath = "//span[text()='Description: Validation Error: Value is required.']")
    public WebElement descriptionErrorMessage;

    @FindBy(xpath = ".//*[@id='add_hotel:notes']")
    public WebElement notesField;

    private String hotelURLAttribute = "faces/hotel.xhtml";

    public void setCityByName(String name){
        driver.findElement(By.id("add_hotel:city_label")).click();
        driver.findElement(By.xpath("//li[@data-label='"+ name+ "']")).click();
    }

    public void setCountryByName(String name){
        driver.findElement(By.id("add_hotel:country_label")).click();
        driver.findElement(By.xpath("//li[@data-label='"+ name+ "']")).click();
    }

    public WebElement getRatingStar(int n){
        return driver.findElement(By.xpath(".//*[@id='add_hotel:rate']/div["+(n+1)+"]/a"));
    }

    public boolean isOnThisPage(){
        return driver.getCurrentUrl().equals(new TestBase().getBaseUrl()+hotelURLAttribute);
    }

    public HotelPage saveButtonClickWithWrongData(){
        saveButton.click();
        return MyPageFactory.getPage(driver,HotelPage.class);
    }

    public HotelListPage saveButtonClick(){
        saveButton.click();
        return MyPageFactory.getPage(driver,HotelListPage.class);
    }

    @Override
    void tryToOpen() {}
}
