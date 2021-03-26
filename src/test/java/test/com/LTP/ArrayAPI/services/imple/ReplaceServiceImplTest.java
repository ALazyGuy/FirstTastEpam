package test.com.LTP.ArrayAPI.services.imple;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.services.IReplaceService;
import com.LTP.ArrayAPI.services.impl.ReplaceServiceImpl;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReplaceServiceImplTest {

    private ArrayEntity arrayEntity;
    private IReplaceService replaceService;

    @BeforeMethod
    public void initMethods(){
        arrayEntity = new ArrayEntity(new int[]{5, 1, -6, 0, 45, 0, -19, 2});
        replaceService = ReplaceServiceImpl.getInstance();
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void replaceByValueTest(){
        replaceService.replaceByValue(arrayEntity, a -> a % 2 == 0, -100);
        AssertJUnit.assertArrayEquals(arrayEntity.getArray(), new int[]{5, 1, -100, -100, 45, -100, -19, -100});
        replaceService.replaceByValue(null, null, -1);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void replaceTest(){
        replaceService.replace(arrayEntity, a -> a % 2 == 0, a -> a * 2);
        AssertJUnit.assertArrayEquals(arrayEntity.getArray(), new int[]{5, 1, -12, 0, 45, 0, -19, 4});
        replaceService.replace(null, null, null);
    }

    @AfterClass
    public void terminate(){
        arrayEntity = null;
        replaceService = null;
    }

}
