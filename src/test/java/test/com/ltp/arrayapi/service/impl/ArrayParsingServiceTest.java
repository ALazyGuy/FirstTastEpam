package test.com.ltp.arrayapi.service.impl;

import com.ltp.arrayapi.service.IArrayParsingService;
import com.ltp.arrayapi.service.impl.ArrayParsingServiceImpl;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArrayParsingServiceTest {

    private IArrayParsingService arrayParsingService;

    @BeforeClass
    public void init(){
        arrayParsingService = ArrayParsingServiceImpl.getInstance();
    }

    @Test
    public void parseTest(){
        int[] expected = {-1, -2, -3, -4};
        int[] actual = arrayParsingService.parse("-1 - -2 -3, -4").getArray();
        AssertJUnit.assertArrayEquals(expected, actual);
    }

    @AfterClass
    public void terminate(){
        arrayParsingService = null;
    }

}
