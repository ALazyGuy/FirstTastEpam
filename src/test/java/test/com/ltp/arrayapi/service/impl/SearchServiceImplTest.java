package test.com.ltp.arrayapi.service.impl;

import com.ltp.arrayapi.entity.ArrayEntity;
import com.ltp.arrayapi.exception.ArrayException;
import com.ltp.arrayapi.service.ISearchService;
import com.ltp.arrayapi.service.impl.SearchServiceImpl;
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

    @Test(expectedExceptions = {ArrayException.class})
    public void findMaxValueTest() throws ArrayException  {
        int expected = 45;
        int result = searchService.findMaxValue(arrayEntity);
        AssertJUnit.assertEquals(expected, result);
        searchService.findMaxValue(null);
    }

    @Test(expectedExceptions = {ArrayException.class})
    public void findMinValueTest() throws ArrayException {
        int expected = -19;
        int result = searchService.findMinValue(arrayEntity);
        AssertJUnit.assertEquals(expected, result);
        searchService.findMinValue(null);
    }

    @Test(expectedExceptions = {ArrayException.class})
    public void findMaxValueStreamTest() throws ArrayException  {
        int expected = 45;
        int result = searchService.findMaxValueStream(arrayEntity);
        AssertJUnit.assertEquals(expected, result);
        searchService.findMaxValueStream(null);
    }

    @Test(expectedExceptions = {ArrayException.class})
    public void findMinValueStreamTest() throws ArrayException {
        int expected = -19;
        int result = searchService.findMinValueStream(arrayEntity);
        AssertJUnit.assertEquals(expected, result);
        searchService.findMinValueStream(null);
    }

    @AfterClass
    public void terminate(){
        arrayEntity = null;
        searchService = null;
    }
}
