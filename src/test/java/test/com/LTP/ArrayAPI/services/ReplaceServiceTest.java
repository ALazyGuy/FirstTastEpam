package test.com.LTP.ArrayAPI.services;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.services.ReplaceService;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReplaceServiceTest {

    private ArrayEntity arrayEntity;

    @BeforeMethod
    public void initMethods(){
        arrayEntity = new ArrayEntity(new int[]{5, 1, -6, 0, 45, 0, -19, 2});
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void replaceByValueTest(){
        ReplaceService.replaceByValue(arrayEntity, a -> a % 2 == 0, -100);
        AssertJUnit.assertArrayEquals(arrayEntity.getArray(), new int[]{5, 1, -100, -100, 45, -100, -19, -100});
        ReplaceService.replaceByValue(null, null, -1);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void replaceTest(){
        ReplaceService.replace(arrayEntity, a -> a % 2 == 0, a -> a * 2);
        AssertJUnit.assertArrayEquals(arrayEntity.getArray(), new int[]{5, 1, -12, 0, 45, 0, -19, 4});
        ReplaceService.replace(null, null, null);
    }

    @AfterClass
    public void terminate(){
        arrayEntity = null;
    }

}
