package com.dio.courses.abakhtiozin.pages;

import com.dio.courses.abakhtiozin.model.Currency;
import com.dio.courses.abakhtiozin.model.CurrencyCalculator;
import com.dio.courses.abakhtiozin.model.Operation;
import com.dio.courses.abakhtiozin.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by AA on 25.10.2014.
 */
public class CurrencyConverterPage extends AnyPage {

    @FindBy(xpath = "html/body/div[@class = 'section_nav']/ul/li[@class = 'sn_menu_item _current']/a")
    private WebElement currentPage;

    @FindBy(xpath = ".//*[@id='fn_s1']")
    private WebElement valueField;

    @FindBy(css = "#fn_c1")
    private WebElement currencyField;

    @FindBy(css = "#fn_i1_1")
    private WebElement currencyRateUAH;

    @FindBy(css = "#fn_i1_978")
    private WebElement currencyRateEUR;

    @FindBy(css = "#fn_i1_643")
    private WebElement currencyRateRUB;

    @FindBy(css = "#fn_i1_840")
    private WebElement currencyRateUSD;

    @FindBy(css = "#fn_o1_1")
    private WebElement resultFieldUAH;

    @FindBy(css = "#fn_o1_978")
    private WebElement resultFieldEUR;

    @FindBy(css = "#fn_o1_643")
    private WebElement resultFieldRUB;

    @FindBy(css = "#fn_o1_840")
    private WebElement resultFieldUSD;

    public String getCurrentOperation() {
        return currentOperation.getText();
    }

    @FindBy(css = ".navigation_tabs_rounded.clear>.current>i>span")
    private WebElement currentOperation;

    public WebElement result;
    public WebElement rateField;
    public WebElement value;

    public double calculateResult(Currency currencyToBuy){
        if (currencyToBuy != Currency.UAH){
             return new CurrencyCalculator(Double.parseDouble(value.getAttribute("value")),
                    Double.parseDouble(rateField.getAttribute("value")),
                    this.getBaseCurrencyRate())
                    .getResult();
        } else {
            return  new CurrencyCalculator(Double.parseDouble(value.getAttribute("value")),
                    Double.parseDouble(rateField.getAttribute("value")))
                    .getResult();
        }
    }




    public void setOperation(Operation _operation) {
        for (WebElement webElement : driver.findElements(By.cssSelector(".navigation_tabs_rounded.clear>li>i>span"))){
            if (!webElement.getText().equals(currentOperation.getText()) && webElement.getText().equals(_operation.toString())){
                    webElement.click();
            }
        }
    }

    public void setCurrencyToSell(Currency currencyToSell) {
        Select currencyList = new Select(currencyField);
        currencyList.selectByVisibleText(currencyToSell.toString());
    }

    public String getSelectedCurrencyToSell() {
        Select currencyList = new Select(currencyField);
        return currencyList.getFirstSelectedOption().getText();
    }

    public double getBaseCurrencyRate() {
        return Double.parseDouble(currencyRateUAH.getAttribute("value"));
    }

    public void initFieldsByCurrency(Currency currencyToBuy){
        this.value = this.valueField;
        switch (currencyToBuy){
            case EUR:
                this.result = this.resultFieldEUR;
                this.rateField = this.currencyRateEUR;
                break;
            case USD:
                this.result = this.resultFieldUSD;
                this.rateField = this.currencyRateUSD;
                break;
            case UAH:
                this.result = this.resultFieldUAH;
                this.rateField = this.currencyRateUAH;
                break;
            case RUB:
                this.result = this.resultFieldRUB;
                this.rateField = this.currencyRateRUB;
                break;
        }
    }

    public boolean isOnThisPage() {
        return currentPage.getAttribute("href").equals(new TestBase().getBaseUrl()+"converter/");
    }

    @Override
    void tryToOpen() {
        MyPageFactory.getPage(driver,MainPage.class).goToConverterPage();
    }
}
