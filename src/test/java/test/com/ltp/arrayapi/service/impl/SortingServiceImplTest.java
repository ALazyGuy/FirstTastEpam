package test.com.ltp.arrayapi.service.impl;

import com.ltp.arrayapi.entity.ArrayEntity;
import com.ltp.arrayapi.exception.ArrayException;
import com.ltp.arrayapi.service.ISortingService;
import com.ltp.arrayapi.service.impl.SortingServiceImpl;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortingServiceImplTest {

    private ArrayEntity arrayEntity;
    private ISortingService sortingService;

    @BeforeClass
    public void init(){
        sortingService = SortingServiceImpl.getInstance();
    }

    @BeforeMethod
    public void initMethods(){
        arrayEntity = new ArrayEntity(new int[]{3, 1, 7, 4, 1, -17});
    }

    @Test(expectedExceptions = ArrayException.class)
    public void bubbleSortTest() throws ArrayException  {
        int[] expected = {-17, 1, 1, 3, 4, 7};
        sortingService.bubbleSort(arrayEntity);
        AssertJUnit.assertArrayEquals(expected, arrayEntity.getArray());
        sortingService.bubbleSort(null);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void insertionSortTest() throws ArrayException {
        int[] expected = {-17, 1, 1, 3, 4, 7};
        sortingService.insertionSort(arrayEntity);
        AssertJUnit.assertArrayEquals(expected, arrayEntity.getArray());
        sortingService.insertionSort(null);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void selectionSortTest() throws ArrayException {
        int[] expected = {-17, 1, 1, 3, 4, 7};
        sortingService.selectionSort(arrayEntity);
        AssertJUnit.assertArrayEquals(expected, arrayEntity.getArray());
        sortingService.selectionSort(null);
    }

    @AfterClass
    public void terminate(){
        arrayEntity = null;
        sortingService = null;
    }

}
