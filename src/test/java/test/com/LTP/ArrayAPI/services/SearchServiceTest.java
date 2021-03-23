package test.com.LTP.ArrayAPI.services;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.services.SearchService;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchServiceTest {

    private ArrayEntity arrayEntity;

    @BeforeClass
    public void init(){
        arrayEntity = new ArrayEntity(new int[]{5, 1, -6, 0, 45, 0, -19, 3});
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void findMaxValueTest(){
        int expected = 45;
        int result = SearchService.findMaxValue(arrayEntity);
        AssertJUnit.assertEquals(expected, result);
        SearchService.findMaxValue(null);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void findMinValueTest(){
        int expected = -19;
        int result = SearchService.findMinValue(arrayEntity);
        AssertJUnit.assertEquals(expected, result);
        SearchService.findMinValue(null);
    }

    @AfterClass
    public void terminate(){
        arrayEntity = null;
    }
}
