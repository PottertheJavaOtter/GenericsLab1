package io.minlee;

import org.junit.Before;
import org.junit.Test;
import scala.util.parsing.combinator.testing.Str;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by minlee on 5/30/16.
 */
public class MyMapSpec {

    MyMap<String,String> myMap;
    @Before
    public void initialize(){
        myMap = new MyMap<>();
        myMap.put("first","Min");
    }

    @Test
    public void clearTest() {
        assertTrue(myMap.containsKey("first"));
        assertTrue(myMap.containsValue("Min"));
        myMap.clear();
        assertFalse(myMap.containsKey("first"));
        assertFalse(myMap.containsValue("Min"));
    }

    @Test
    public void containsKeyTest()  {
        assertTrue(myMap.containsKey("first"));
        assertFalse(myMap.containsKey("second"));

    }

    @Test
    public void containsValueTest()  {
        assertTrue(myMap.containsValue("Min"));
        assertFalse(myMap.containsValue("Lee"));
    }

    @Test
    public void entrySetTest(){
        String expectedKey = "first";
        String actualKey = "";
        String expectedValue = "Min";
        String actualValue = "";

        Set<Map.Entry<String,String>> actualEntrySet = myMap.entrySet();
        Iterator<Map.Entry<String,String>> iterator = actualEntrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry<String,String> thisEntry = iterator.next();
            actualKey = thisEntry.getKey();
            actualValue = thisEntry.getValue();
        }
        assertEquals(expectedKey,actualKey);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void equalsTest()  {
        MyMap<String,String> myMapTest= myMap;
        assertTrue(myMap.equals(myMapTest));

    }

    @Test
    public void getTest() {
        String expectedValue = "Min";
        String actualValue = myMap.get("first");
        assertEquals(expectedValue,actualValue);
        assertNull(myMap.get("second"));

    }

    @Test
    public void hashCodeTest()  {
        int expectedHash = 195600860;
        int actualHash = myMap.hashCode();
        assertEquals(actualHash,expectedHash);
    }

    @Test
    public void isEmptyTest()  {
        assertFalse(myMap.isEmpty());
        myMap.clear();
        assertTrue(myMap.isEmpty());
    }

    @Test
    public void putTest() {
        myMap.put("second","Lee");
        String expectedValue = "Lee";
        String actualValue = myMap.get("second");
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void keySetTest() {
        Set<String> actualSet = myMap.keySet();
        String actualString = "";
        Iterator<String> iterator = actualSet.iterator();
        while (iterator.hasNext()){
            actualString = iterator.next();
        }
        assertEquals("first", actualString);
    }

    @Test
    public void putAllTest() {
        MyMap<String,String> myMapTest = new MyMap<>();;
        myMapTest.put("second", "Lee");
        myMap.putAll(myMapTest);
        String expectedString = "Lee";
        String actualString = myMap.get("second");
        assertEquals(expectedString,actualString);
    }

    @Test
    public void removeTest()  {
        String expectedValue = "Min";
        String actualValue = myMap.remove("first");
        assertEquals(expectedValue,actualValue);
        assertFalse(myMap.containsValue("Min"));
    }

    @Test
    public void sizeTest()  {
        int expectedInt = 1;
        int actualInt = myMap.size();
        assertEquals(expectedInt,actualInt);
    }

    @Test
    public void valuesTest() {
        Collection<String> myValues = myMap.values();
        Iterator<String> iterator = myValues.iterator();
        String expectedValue = "Min";
        String actualString = "";
        while (iterator.hasNext()){
            actualString = iterator.next();
        }
        assertEquals(expectedValue, actualString);
    }

}