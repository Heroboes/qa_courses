package com.dio.courses.abakhtiozin.tests;

import com.dio.courses.abakhtiozin.model.Hotel;
import com.dio.courses.abakhtiozin.pages.HotelListPage;
import com.dio.courses.abakhtiozin.pages.HotelPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by AA on 25.10.2014.
 */
public class Tests extends TestBase {

    @DataProvider(name="data for registerNewHotel test")
    public Object[][] createDataForNewHotel() {
        return new  Object[][] {
                {new Hotel().withHotelName("New Hotel 4 stars night")
                        .withdateConstructed("10/10/2010")
                        .withStars(4)
                        .withCountry("Ukraine")
                        .withCity("Dnipropetrovsk")
                        .withShortDesc("some short description")
                        .withDesc("some description")
                        .withNotes("some notes")},
                {new Hotel().withHotelName("Hilton")
                        .withdateConstructed("11/03/2006")
                        .withStars(2)
                        .withCountry("Ukraine")
                        .withCity("Kyiv")
                        .withShortDesc("some short description test 2")
                        .withDesc("some description blabla")
                        .withNotes("some notes about hotel")},
        };
    }

    @Test(testName = "registerNewHotel", dataProvider = "data for registerNewHotel test")
    public void registerNewHotel(Hotel hotel) {
        HotelPage hotelPage = goToMainPage()
                .goToHotelPage();
        hotelPage.nameField.sendKeys(hotel.getHotelName());
        hotelPage.getRatingStar(4).click();
        hotelPage.dateOfConstruction.sendKeys(hotel.getDateConstructed());
        hotelPage.setCountryByName(hotel.getCountry());
        Assert.assertTrue(hotelPage.countryField.getAttribute("data-label").equals(hotel.getCountry()), " Country wasn't selected");
        hotelPage.setCityByName(hotel.getCity());
        Assert.assertTrue(hotelPage.cityField.getAttribute("data-label").equals(hotel.getCity()), " City wasn't selected");
        hotelPage.shortDescriptionField.sendKeys(hotel.getShortDesc());
        hotelPage.descriptionField.sendKeys(hotel.getDesc());
        hotelPage.notesField.sendKeys(hotel.getNotes());
        HotelListPage hotelListPage = hotelPage.saveButtonClick();
        Assert.assertTrue(hotelListPage.isOnThisPage(), " Not on Hotel List page");
    }

    @DataProvider(name="invalid data for validation of new hotel form")
    public Object[][] createInvalidDataForNewHotel() {
        return new  Object[][] {
                {""},
                {"9999999999"}
        };
    }

    @Test(testName = "checking validation of new hotel form register", dataProvider = "invalid data for validation of new hotel form")
    public void newHotelFormValidationTest(String date) {
        HotelPage hotelPage = goToMainPage()
                .goToHotelPage();
        hotelPage.dateOfConstruction.clear();
        hotelPage.dateOfConstruction.sendKeys(date);
        hotelPage.saveButtonClickWithWrongData();
        Assert.assertTrue(hotelPage.descriptionErrorMessage.isDisplayed(), " error message is not displayed");
        Assert.assertTrue(hotelPage.shortDescriptionErrorMessage.isDisplayed(), " error message is not displayed");
        Assert.assertTrue(hotelPage.cityErrorMessage.isDisplayed(), " error message is not displayed");
        Assert.assertTrue(hotelPage.countryFieldErrorMessage.isDisplayed(), " error message is not displayed");
        Assert.assertTrue(hotelPage.dateOfConstructionWrongDateFormat.isDisplayed(), " error message is not displayed");
        Assert.assertTrue(hotelPage.nameErrorMessage.isDisplayed(), " Error message not found");
    }


                    /* Useless old tests */


    @Test(testName = "open New Hotel Page", enabled = false)
    public void openNewHotelPageTest() {
        HotelPage hotelPage = goToMainPage()
                .goToHotelPage();
        Assert.assertTrue(hotelPage.isOnThisPage(), " Not on hotel page");
        Assert.assertTrue(hotelPage.dataSection.isDisplayed(), " data section not found");
        Assert.assertTrue(hotelPage.saveButton.isDisplayed(), " save button not found");
    }

    @Test(testName = "name field verification", enabled = false)
    public void verifyNameField() {
        HotelPage hotelPage = goToMainPage()
                .goToHotelPage();
        Assert.assertTrue(hotelPage.isOnThisPage(), " Not on hotel page");
        Assert.assertTrue(hotelPage.dataSection.isDisplayed(), " data section not found");
        Assert.assertTrue(hotelPage.nameField.isDisplayed(), " name field not found");
        Assert.assertTrue(hotelPage.nameFieldAsterisk.getText().equals("*"), " asterisk near name field not found");
        Assert.assertTrue(hotelPage.nameField.isEnabled(), " name field is not editable by attributes");
        hotelPage.nameField.sendKeys("111a");
        Assert.assertTrue(hotelPage.nameField.getAttribute("value").equals("111a"), " name field is not editable, can't get text");
        hotelPage.nameField.clear();
        hotelPage.saveButtonClickWithWrongData();
        Assert.assertTrue(hotelPage.isOnThisPage(), " Not on hotel page after clicking on save button with wrong data");
        Assert.assertTrue(hotelPage.nameErrorMessage.isDisplayed(), " Error message not found");
        hotelPage.nameField.sendKeys("testHotel1");
        hotelPage.saveButtonClick();
        Assert.assertTrue(hotelPage.isOnThisPage(), " Not on hotel page after clicking on save button with valid data");
        Assert.assertTrue(hotelPage.nameField.getAttribute("value").equals("testHotel1"), " name field is not editable, can't get text");
    }

    @Test(testName = "name field verification", enabled = false)
    public void hotelRatingTest() {
        HotelPage hotelPage = goToMainPage()
                .goToHotelPage();
        Assert.assertTrue(hotelPage.isOnThisPage(), " Not on hotel page");
        Assert.assertTrue(hotelPage.globalRating.isDisplayed(), " globalRating not displayed");
        for (int i = 1; i <= 5; i++) {
            hotelPage.globalRatingCancel.click();
            hotelPage.getRatingStar(i).click();
            Assert.assertTrue(hotelPage.globalRatingStars.getAttribute("value").equals(Integer.toString(i)), " rating starts doesn't match expected value " + i);
        }
    }

    @Test(testName = "Story#190127", enabled = false)
    public void dateOfConstructionTest() {
        HotelPage hotelPage = goToMainPage()
                .goToHotelPage();
        Assert.assertTrue(hotelPage.isOnThisPage(), " Not on hotel page");
        Assert.assertTrue(hotelPage.dateOfConstruction.isDisplayed(), " dateOfConstruction is not displayed");
        Assert.assertTrue(hotelPage.dateOfConstructionAsterisk.isDisplayed(), " dateOfConstruction asterisk is not displayed");
        hotelPage.dateOfConstruction.sendKeys("9999999999");
        hotelPage.saveButtonClickWithWrongData();
        Assert.assertTrue(hotelPage.dateOfConstructionWrongDateFormat.isDisplayed(), " error message is not displayed");
        hotelPage.dateOfConstruction.clear();
        hotelPage.saveButtonClickWithWrongData();
        Assert.assertTrue(hotelPage.dateOfConstructionWrongDateFormat.isDisplayed(), " error message is not displayed");

    }

    @Test(testName = "Story#190128", enabled = false)
    public void countryFieldTest() {
        String country = "Ukraine";
        HotelPage hotelPage = goToMainPage()
                .goToHotelPage();
        Assert.assertTrue(hotelPage.isOnThisPage(), " Not on hotel page");
        Assert.assertTrue(hotelPage.countryFieldAsterisk.isDisplayed(), " country asterisk is not displayed");
        Assert.assertTrue(hotelPage.countryField.isDisplayed(), " country field is not displayed");
        hotelPage.saveButtonClickWithWrongData();
        Assert.assertTrue(hotelPage.countryFieldErrorMessage.isDisplayed(), " error message is not displayed");
        hotelPage.countryFieldSelect.click();
        hotelPage.setCountryByName(country);
        Assert.assertTrue(hotelPage.countryField.getText().equals(country), "Expected " + country + " but got " + hotelPage.countryField.getText());
    }

    @Test(testName = "Story#190129", enabled = false)
    public void cityFieldTest() {
        String city = "Dnipropetrovsk";
        String country = "Ukraine";
        HotelPage hotelPage = goToMainPage()
                .goToHotelPage();
        Assert.assertTrue(hotelPage.isOnThisPage(), " Not on hotel page");
        Assert.assertTrue(hotelPage.cityAsterisk.isDisplayed(), " city asterisk is not displayed");
        Assert.assertTrue(hotelPage.cityField.isDisplayed(), " city is not displayed");
        hotelPage.saveButtonClickWithWrongData();
        Assert.assertTrue(hotelPage.cityErrorMessage.isDisplayed(), " error message is not displayed");
        hotelPage.countryFieldSelect.click();
        hotelPage.setCountryByName(country);
        hotelPage.setCityByName(city);
        Assert.assertTrue(hotelPage.cityField.getText().equals(city), "Expected " + city + " but got " + hotelPage.cityField.getText());
    }

    @Test(testName = "Story#190130", enabled = false)
    public void shortDescriptionFieldTest() {
        HotelPage hotelPage = goToMainPage()
                .goToHotelPage();
        Assert.assertTrue(hotelPage.isOnThisPage(), " Not on hotel page");
        Assert.assertTrue(hotelPage.shortDescriptionField.isDisplayed(), " short description is not displayed");
        Assert.assertTrue(hotelPage.shortDescriptionAsterisk.isDisplayed(), "short description asterisk was not found");
        hotelPage.saveButtonClickWithWrongData();
        Assert.assertTrue(hotelPage.shortDescriptionErrorMessage.isDisplayed(), " error message is not displayed");
    }

    @Test(testName = "Story#190131", enabled = false)
    public void DescriptionFieldTest() {
        HotelPage hotelPage = goToMainPage()
                .goToHotelPage();
        Assert.assertTrue(hotelPage.isOnThisPage(), " Not on hotel page");
        Assert.assertTrue(hotelPage.descriptionField.isDisplayed(), " description is not displayed");
        Assert.assertTrue(hotelPage.descriptionAsterisk.isDisplayed(), "description asterisk was not found");
        hotelPage.saveButtonClickWithWrongData();
        Assert.assertTrue(hotelPage.descriptionErrorMessage.isDisplayed(), " error message is not displayed");
    }

    @Test(testName = "Story#190132", enabled = false)
    public void notesFieldTest() {
        HotelPage hotelPage = goToMainPage()
                .goToHotelPage();
        Assert.assertTrue(hotelPage.isOnThisPage(), " Not on hotel page");
        Assert.assertTrue(hotelPage.notesField.isDisplayed(), " notes is not displayed");
    }


}
