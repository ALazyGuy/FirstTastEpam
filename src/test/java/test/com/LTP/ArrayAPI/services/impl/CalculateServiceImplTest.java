package test.com.LTP.ArrayAPI.services.impl;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.exceptions.ArrayException;
import com.LTP.ArrayAPI.services.ICalculateService;
import com.LTP.ArrayAPI.services.impl.CalculateServiceImpl;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculateServiceImplTest {

    private ArrayEntity arrayEntity;
    private ICalculateService calculateService;

    @BeforeClass
    public void init(){
        arrayEntity = new ArrayEntity(new int[]{3, 1, 8, 5, 4});
        calculateService = CalculateServiceImpl.getInstance();
    }

    @Test(expectedExceptions = ArrayException.class)
    public void averageTest() throws ArrayException {
        double result = calculateService.average(arrayEntity);
        double expected = 4.2;
        AssertJUnit.assertEquals(expected, result);
        calculateService.average(null);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void sumTest() throws ArrayException{
        int result = calculateService.sum(arrayEntity);
        int expected = 21;
        AssertJUnit.assertEquals(expected, result);
        calculateService.sum(null);
    }

    @Test(expectedExceptions = {ArrayException.class})
    public void sumBoundsTest() throws ArrayException {
        int result = calculateService.sum(arrayEntity, 1, 3);
        int expected = 14;
        AssertJUnit.assertEquals(expected, result);
        calculateService.sum(null, -1, -1);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void positivesTest() throws ArrayException {
        int result = calculateService.countPositives(arrayEntity);
        int expected = 5;
        AssertJUnit.assertEquals(expected, result);
        calculateService.countPositives(null);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void negativesTest() throws ArrayException {
        int result = calculateService.countNegatives(arrayEntity);
        int expected = 0;
        AssertJUnit.assertEquals(expected, result);
        calculateService.countNegatives(null);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void sumStreamTest() throws ArrayException{
        int result = calculateService.sumStream(arrayEntity);
        int expected = 21;
        AssertJUnit.assertEquals(expected, result);
        calculateService.sumStream(null);
    }

    @Test(expectedExceptions = {ArrayException.class})
    public void sumBoundsStreamTest() throws ArrayException {
        int result = calculateService.sumStream(arrayEntity, 1, 3);
        int expected = 14;
        AssertJUnit.assertEquals(expected, result);
        calculateService.sumStream(null, -1, -1);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void positivesStreamTest() throws ArrayException {
        int result = calculateService.countPositivesStream(arrayEntity);
        int expected = 5;
        AssertJUnit.assertEquals(expected, result);
        calculateService.countPositivesStream(null);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void negativesStreamTest() throws ArrayException {
        int result = calculateService.countNegativesStream(arrayEntity);
        int expected = 0;
        AssertJUnit.assertEquals(expected, result);
        calculateService.countNegativesStream(null);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void averageStreamTest() throws ArrayException {
        double result = calculateService.averageStream(arrayEntity);
        double expected = 4.2;
        AssertJUnit.assertEquals(expected, result);
        calculateService.averageStream(null);
    }

    @AfterClass
    public void terminate(){
        arrayEntity = null;
        calculateService = null;
    }

}
