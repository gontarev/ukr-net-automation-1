package net.ukr.automation.selenium.session11.dataprovider;

import com.tngtech.java.junit.dataprovider.DataProvider;

public class TestData {

    @DataProvider
    public static Object[][] calcData() {
        return new Object[][]{
                  {1, 2, 3}
                , {3, 4, 7}
                , {300, 4000, 722}
                , {-3, 3, 0}
                , {33232, 114, 1117}
        };
    }
}
