package io.minlee;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by minlee on 5/30/16.
 */
public class MySetSpec {

    MySet<String> mySet;

    @Before
    public void initialize(){
        mySet = new MySet<>();
        mySet.add("First Item");
    }
    @Test
    public void addTest(){
        assertTrue(mySet.add("Second Item"));
        assertFalse(mySet.add("Second Item"));
    }

    @Test
    public void addAllTest(){
        ArrayList<String> testArrayList = new ArrayList<>();
        testArrayList.add("First Item");
        assertFalse(mySet.addAll(testArrayList));
        testArrayList.add("Second Item");
        assertTrue(mySet.addAll(testArrayList));
    }

    @Test
    public void clearTest(){
        assertTrue(mySet.contains("First Item"));
        mySet.clear();
        assertFalse(mySet.contains("First Item"));
    }

    @Test
    public void containsTest(){
        assertTrue(mySet.contains("First Item"));
    }

    @Test
    public void containsAllTest(){
        mySet.add("Second Item");
        ArrayList<String> testArrayList = new ArrayList<>();
        testArrayList.add("First Item");
        testArrayList.add("Second Item");
        assertTrue(mySet.containsAll(testArrayList));
    }

    @Test
    public void equalsTest(){
        Set<String> otherSet = new HashSet<>();
        otherSet.add("First Item");
        assertTrue(mySet.equals(otherSet));
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(15);
        assertFalse(mySet.equals(integerSet));
    }

    @Test
    public void hashCodeTest(){
        int expectedValue = 1773213379;
        int actualValue = mySet.hashCode();
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void isEmptyTest(){
        assertFalse(mySet.isEmpty());
        mySet.clear();
        assertTrue(mySet.isEmpty());
    }

    @Test
    public void iteratorTest(){
        Iterator<String> iterator = mySet.iterator();
        String actualString = "";
        while (iterator.hasNext()){
            actualString = iterator.next();
        }
        String expectedString = "First Item";
        assertEquals(expectedString,actualString);
    }

    @Test
    public void removeTest(){
        mySet.remove("First Item");
        assertFalse(mySet.contains("First Item"));

    }

    @Test
    public void removeAllTest(){
        mySet.add("Second Item");
        ArrayList<String> testArrayList = new ArrayList<>();
        testArrayList.add("First Item");
        testArrayList.add("Second Item");
        assertTrue(mySet.removeAll(testArrayList));
    }

    @Test
    public void retainAllTest(){
        mySet.add("Second Item");
        ArrayList<String> testArrayList = new ArrayList<>();
        testArrayList.add("First Item");
        testArrayList.add("Second Item");
        assertTrue(mySet.retainAll(testArrayList));
    }

    @Test
    public void sizeTest(){
        int expectedValue = 1;
        int actualValue = mySet.size();
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void toArrayObjectTest(){
        mySet.add("Second Item");
        Object[] actualArray = mySet.toArray();
        Object[] expectedArray = {"First Item","Second Item"};
        assertArrayEquals(actualArray,expectedArray);
    }

    @Test
    public void toArrayTTest(){
        String[] expectedArray = {"First Item","Second Item"};
        assertArrayEquals(expectedArray,mySet.toArray(expectedArray));
    }

}