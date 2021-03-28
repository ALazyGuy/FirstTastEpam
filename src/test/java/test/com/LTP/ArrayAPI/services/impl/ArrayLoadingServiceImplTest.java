package test.com.LTP.ArrayAPI.services.impl;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.exceptions.ArrayException;
import com.LTP.ArrayAPI.services.IArrayLoadingService;
import com.LTP.ArrayAPI.services.impl.ArrayLoadingServiceImpl;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArrayLoadingServiceImplTest {

    private IArrayLoadingService arrayLoadingService;

    @BeforeClass
    public void init(){
        arrayLoadingService = ArrayLoadingServiceImpl.getInstance();
    }

    @Test(expectedExceptions = ArrayException.class)
    public void loadArrayTest() throws ArrayException{
        ArrayEntity arrayEntity = arrayLoadingService.loadArray("src/main/resources/data/data.txt");
        String expected = "{ 1, 2, 3 }";
        String actual = arrayEntity.toString();
        AssertJUnit.assertEquals(expected, actual);
        arrayLoadingService.loadArray("Error");
    }

    @AfterClass
    public void terminate(){
        arrayLoadingService = null;
    }

}
