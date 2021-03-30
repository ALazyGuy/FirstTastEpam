package test.com.ltp.arrayapi.service.impl;

import com.ltp.arrayapi.entity.ArrayEntity;
import com.ltp.arrayapi.exception.ArrayException;
import com.ltp.arrayapi.service.IReplaceService;
import com.ltp.arrayapi.service.impl.ReplaceServiceImpl;
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

    @Test(expectedExceptions = {ArrayException.class})
    public void replaceByValueTest() throws ArrayException  {
        replaceService.replaceByValue(arrayEntity, a -> a % 2 == 0, -100);
        AssertJUnit.assertArrayEquals(arrayEntity.getArray(), new int[]{5, 1, -100, -100, 45, -100, -19, -100});
        replaceService.replaceByValue(null, null, -1);
    }

    @Test(expectedExceptions = {ArrayException.class})
    public void replaceTest() throws ArrayException {
        replaceService.replace(arrayEntity, a -> a % 2 == 0, a -> a * 2);
        AssertJUnit.assertArrayEquals(arrayEntity.getArray(), new int[]{5, 1, -12, 0, 45, 0, -19, 4});
        replaceService.replace(null, null, null);
    }

    @Test(expectedExceptions = {ArrayException.class})
    public void replaceByValueStreamTest() throws ArrayException  {
        replaceService.replaceByValueStream(arrayEntity, a -> a % 2 == 0, -100);
        AssertJUnit.assertArrayEquals(arrayEntity.getArray(), new int[]{5, 1, -100, -100, 45, -100, -19, -100});
        replaceService.replaceByValueStream(null, null, -1);
    }

    @Test(expectedExceptions = {ArrayException.class})
    public void replaceStreamTest() throws ArrayException {
        replaceService.replaceStream(arrayEntity, a -> a % 2 == 0, a -> a * 2);
        AssertJUnit.assertArrayEquals(arrayEntity.getArray(), new int[]{5, 1, -12, 0, 45, 0, -19, 4});
        replaceService.replaceStream(null, null, null);
    }

    @AfterClass
    public void terminate(){
        arrayEntity = null;
        replaceService = null;
    }

}
