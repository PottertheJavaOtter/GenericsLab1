package io.minlee;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by minlee on 5/26/16.
 */
public class MyArrayListSpec {

    MyArrayList<String> myArrayList;
    @Before
    public void initialize(){
        myArrayList = new MyArrayList<>();
        myArrayList.add(11, "Prior eleven");
    }

    @Test
    public void addTest(){
        myArrayList.add("At 12 index");
        String expectedResult = "At 12 index";
        String actualResult = myArrayList.get(12);
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void addAtSpecifiedIndexTest(){
        myArrayList.add(11, "New eleven");
        String expectedResult = "New eleven";
        String actualResult = myArrayList.get(11);
        assertEquals(expectedResult,actualResult);
        expectedResult = "Prior eleven";
        actualResult = myArrayList.get(12);
        assertEquals(expectedResult,actualResult);
        myArrayList.add(14, "New fourteen");
        expectedResult = "New fourteen";
        actualResult = myArrayList.get(14);
        assertEquals(expectedResult,actualResult);
        int expectedArraySize = 15;
        int actualArraySize = myArrayList.getMyArrayListSize();
        assertEquals(expectedArraySize,actualArraySize);
    }

    @Test
    public void getTest(){
        int expectedArraySize = 12;
        int actualArraySize = myArrayList.getMyArrayListSize();
        assertEquals(expectedArraySize,actualArraySize);
    }

    @Test
    public void removeTest(){
        myArrayList.remove(11);
        String expectedResult = null;
        String actualResult = myArrayList.get(11);
        assertEquals(expectedResult,actualResult);
        int expectedArraySize = 11;
        int actualArraySize = myArrayList.getMyArrayListSize();
        assertEquals(expectedArraySize,actualArraySize);
    }

    @Test
    public void setTest(){
        myArrayList.set(14,"New fourteen");
        String expectedResult = "New fourteen";
        String actualResult = myArrayList.get(14);
        assertEquals(expectedResult,actualResult);
        int expectedArraySize = 15;
        int actualArraySize = myArrayList.getMyArrayListSize();
        assertEquals(expectedArraySize,actualArraySize);
    }

    @Test
    public void clearTest(){
        myArrayList.clear();
        assertTrue(myArrayList.isEmpty());
    }

    @Test
    public void isEmptyTest(){
        assertFalse(myArrayList.isEmpty());
        myArrayList.clear();
        assertTrue(myArrayList.isEmpty());
    }

    @Test
    public void containsTest(){
        assertTrue(myArrayList.contains("Prior eleven"));
    }
}
