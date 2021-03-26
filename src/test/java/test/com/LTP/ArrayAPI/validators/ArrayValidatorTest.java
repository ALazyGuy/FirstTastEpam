package test.com.LTP.ArrayAPI.validators;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.exceptions.ArrayException;
import com.LTP.ArrayAPI.validators.ArrayValidator;
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

    @Test(expectedExceptions = ArrayException.class, dataProvider = "validateArrayData")
    public void validateArrayTest(ArrayEntity arrayEntity) throws ArrayException{
        ArrayValidator.validateArray(arrayEntity);
    }

}
