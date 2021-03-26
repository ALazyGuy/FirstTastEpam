package test.com.LTP.ArrayAPI.services.impl;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.exceptions.ArrayException;
import com.LTP.ArrayAPI.services.ISearchService;
import com.LTP.ArrayAPI.services.impl.SearchServiceImpl;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchServiceImplTest {

    private ArrayEntity arrayEntity;
    private ISearchService searchService;

    @BeforeClass
    public void init(){
        arrayEntity = new ArrayEntity(new int[]{5, 1, -6, 0, 45, 0, -19, 3});
        searchService = SearchServiceImpl.getInstance();
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void findMaxValueTest() throws ArrayException  {
        int expected = 45;
        int result = searchService.findMaxValue(arrayEntity);
        AssertJUnit.assertEquals(expected, result);
        searchService.findMaxValue(null);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void findMinValueTest() throws ArrayException {
        int expected = -19;
        int result = searchService.findMinValue(arrayEntity);
        AssertJUnit.assertEquals(expected, result);
        searchService.findMinValue(null);
    }

    @AfterClass
    public void terminate(){
        arrayEntity = null;
        searchService = null;
    }
}
