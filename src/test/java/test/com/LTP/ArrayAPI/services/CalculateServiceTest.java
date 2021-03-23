package test.com.LTP.ArrayAPI.services;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.services.CalculateService;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculateServiceTest {

    private ArrayEntity arrayEntity;

    @BeforeClass
    public void init(){
        arrayEntity = new ArrayEntity(new int[]{3, 1, 8, 5, 4});
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void averageTest(){
        double result = CalculateService.average(arrayEntity);
        double expected = 4.2;
        AssertJUnit.assertEquals(expected, result);
        CalculateService.average(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void sumTest(){
        int result = CalculateService.sum(arrayEntity);
        int expected = 21;
        AssertJUnit.assertEquals(expected, result);
        CalculateService.sum(null);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class, IndexOutOfBoundsException.class})
    public void sumBoundsTest(){
        int result = CalculateService.sum(arrayEntity, 1, 3);
        int expected = 14;
        AssertJUnit.assertEquals(expected, result);
        CalculateService.sum(null, -1, -1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void positivesTest(){
        int result = CalculateService.countPositives(arrayEntity);
        int expected = 5;
        AssertJUnit.assertEquals(expected, result);
        CalculateService.countPositives(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativesTest(){
        int result = CalculateService.countNegatives(arrayEntity);
        int expected = 0;
        AssertJUnit.assertEquals(expected, result);
        CalculateService.countNegatives(null);
    }

    @AfterClass
    public void terminate(){
        arrayEntity = null;
    }

}
