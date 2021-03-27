package test.com.LTP.ArrayAPI.validators;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.exceptions.ArrayException;
import com.LTP.ArrayAPI.validators.ArrayValidator;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayValidatorTest {

    @DataProvider(name = "validateArrayData")
    public Object[][] getData(){
        return new Object[][]{
                {null},
                {new ArrayEntity(0)}
        };
    }

    @DataProvider(name = "validateLineData")
    public Object[][] getLineData(){
        return new Object[][]{
                new Object[]{null, false},
                new Object[]{"", false},
                new Object[]{"qwoejp", false},
                new Object[]{"123, - 52", false},
                new Object[]{"1, 2, 3", true},
                new Object[]{"-1 -2 -3", true},
                new Object[]{"-1 - -2 -3, -4", true}
        };
    }

    @Test(expectedExceptions = ArrayException.class, dataProvider = "validateArrayData")
    public void validateArrayTest(ArrayEntity arrayEntity) throws ArrayException{
        ArrayValidator.validateArray(arrayEntity);
    }

    @Test(dataProvider = "validateLineData")
    public void validateArrayLineTest(String input, boolean expected){
        boolean actual = ArrayValidator.validateArrayString(input);
        AssertJUnit.assertEquals(expected, actual);
    }

}
