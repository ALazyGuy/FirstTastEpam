package test.com.LTP.ArrayAPI.services.impl;

import com.LTP.ArrayAPI.exceptions.ArrayException;
import com.LTP.ArrayAPI.services.IFileReadingService;
import com.LTP.ArrayAPI.services.impl.FileReadingServiceImpl;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FileReadingServiceTest {

    private IFileReadingService fileReadingService;

    @DataProvider(name = "parseExceptionData")
    public Object[][] getExceptionData(){
        return new Object[][]{
                new Object[]{""},
                new Object[]{"wrong"},
                new Object[]{null}
        };
    }

    @BeforeClass
    public void init(){
        fileReadingService = FileReadingServiceImpl.getInstance();
    }

    @Test(expectedExceptions = ArrayException.class, dataProvider = "parseExceptionData")
    public void readLineExceptionTest(String path) throws ArrayException{
        fileReadingService.readLine(path);
    }

    @Test
    public void readLineTest(){
        try{
            String expected = "1, 2, 3";
            String actual = fileReadingService.readLine("src/main/resources/data/data.txt");
            AssertJUnit.assertEquals(expected, actual);
        }catch(ArrayException e){
            AssertJUnit.fail();
        }
    }

    @AfterClass
    public void terminate(){
        fileReadingService = null;
    }

}
