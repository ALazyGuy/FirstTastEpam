package test.com.LTP.ArrayAPI.services.impl;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.services.ISortingService;
import com.LTP.ArrayAPI.services.impl.SortingServiceImpl;
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

    @Test
    public void bubbleSortTest(){
        int[] expected = {-17, 1, 1, 3, 4, 7};
        sortingService.bubbleSort(arrayEntity);
        AssertJUnit.assertArrayEquals(expected, arrayEntity.getArray());
    }

    @Test
    public void insertionSortTest(){
        int[] expected = {-17, 1, 1, 3, 4, 7};
        sortingService.insertionSort(arrayEntity);
        AssertJUnit.assertArrayEquals(expected, arrayEntity.getArray());
    }

    @Test
    public void selectionSortTest(){
        int[] expected = {-17, 1, 1, 3, 4, 7};
        sortingService.selectionSort(arrayEntity);
        AssertJUnit.assertArrayEquals(expected, arrayEntity.getArray());
    }

    @AfterClass
    public void terminate(){
        arrayEntity = null;
        sortingService = null;
    }

}
