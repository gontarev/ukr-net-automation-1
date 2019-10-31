package net.ukr.automation.selenium.session11.dataprovider;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class TestDataDrivenDemo
{
   Calc calc = new Calc();

    @Test
    @UseDataProvider(value = "calcData", location = TestData.class)
    public void addTest(Integer a, Integer b, Integer c) {
        Assert.assertEquals(calc.add(a,b),c);
    }

}
