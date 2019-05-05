package UnitTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;
import static org.testng.Assert.assertEquals;

public class CalcMultiTest {

    Calculator calculator;

    @BeforeMethod
    public void setUp(){
        calculator = new Calculator();
    }

    @Test(dataProvider = "longNumbers", dataProviderClass = DataProviderClass.class)
    public void longMultiTest(long a, long b){
        assertEquals(calculator.mult(a,b), a*b);
    }

    @Test(dataProvider = "doubleNumbers", dataProviderClass = DataProviderClass.class)
    public void doubleMultiTest(double a, double b){
        assertEquals(calculator.mult(a,b), a*b);
    }

    @AfterMethod
    public void destroy() {
        calculator = null;
    }
}
