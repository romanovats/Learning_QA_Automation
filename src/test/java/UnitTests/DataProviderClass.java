package UnitTests;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider
    public Object[][] longNumbers() {
        return new Object[][]{
                {2, 4},
                {-3, 0},
                {-4, -8},
                {-5, 6}
        };
    }

    @DataProvider
    public Object[][] doubleNumbers() {
        return new Object[][]{
                {2.0, 4.0},
                {-2.5, -4.2},
                {0.0, 1.0},
                {-1.0, 3.2}
        };
    }
}
