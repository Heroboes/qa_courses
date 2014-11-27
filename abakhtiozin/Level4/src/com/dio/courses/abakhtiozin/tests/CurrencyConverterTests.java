package com.dio.courses.abakhtiozin.tests;

import com.dio.courses.abakhtiozin.model.Currency;
import com.dio.courses.abakhtiozin.model.Operation;
import com.dio.courses.abakhtiozin.pages.CurrencyConverterPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by AA on 25.10.2014.
 */
public class CurrencyConverterTests extends TestBase{

    @Test(testName = "CalcCurrency", dataProvider="data provider for CalcCurrencyTest")
    public void currencyCalculatorTest(String value, Currency currencyToSell, Currency currencyToBuy){
        CurrencyConverterPage converterPage = goToMainPage()
                .goToConverterPage();
        Assert.assertTrue(converterPage.isOnThisPage(), "Not on converter page");
        converterPage.initFieldsByCurrency(currencyToBuy);
        converterPage.setOperation(Operation.продать);
        converterPage.setCurrencyToSell(currencyToSell);
        Assert.assertTrue(converterPage.getSelectedCurrencyToSell().equals(currencyToSell.toString()));
        converterPage.value.clear();
        converterPage.value.sendKeys(value);
        double expectedResult = converterPage.calculateResult(currencyToBuy);
        Assert.assertTrue( expectedResult == Double.parseDouble(converterPage.result.getAttribute("value")),"Expected result "+ expectedResult + " but got " + Double.parseDouble(converterPage.result.getAttribute("value")));
    }
    @DataProvider(name="data provider for CalcCurrencyTest")
    public Object[][] createDataForTest1() {
        return new  Object[][] {
                {"100"  , Currency.RUB, Currency.UAH},
                {"100"  , Currency.RUB, Currency.USD},
                {"100"  , Currency.RUB, Currency.EUR},
                {"100"  , Currency.USD, Currency.EUR},
                {"100"  , Currency.USD, Currency.RUB},
                {"100"  , Currency.USD, Currency.UAH},
                {"100"  , Currency.UAH, Currency.USD},
                {"100"  , Currency.UAH, Currency.RUB},
                {"100"  , Currency.UAH, Currency.EUR},
                {"100"  , Currency.EUR, Currency.USD},
                {"100"  , Currency.EUR, Currency.UAH},
                {"100"  , Currency.EUR, Currency.RUB}
        };
    }
}
