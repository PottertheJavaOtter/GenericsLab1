package io.minlee;

import java.io.Serializable;
import java.util.*;

/**
 * Created by minlee on 5/26/16.
 */
public class MyArrayList<T>{

    private T[] myArray;
    private int myArrayListSize;

    public MyArrayList(){
        this(10);
        myArrayListSize = 0;
    }
    public MyArrayList(int arraySize){
        myArray = (T[])new Object[arraySize];
        myArrayListSize = arraySize;
    }

    public boolean add(T tObj){
        resize(myArray.length+1);
        myArray[myArrayListSize] = tObj;
        myArrayListSize++;
        return true;
    }

    public void add(int index, T tObj){
        resize(index);
        if(index > myArrayListSize){
            myArrayListSize = index+1;
            myArray[index] = tObj;
        }
        else {
            myArrayListSize++;
            T[] newArrayBack = Arrays.copyOfRange(myArray, 0,myArray.length-1);
            myArray[index] = tObj;
            for(int i = index; i < newArrayBack.length;i++){
                myArray[i+1] = newArrayBack[i];
            }

        }

    }

    public T get(int index){
        return myArray[index];
    }
    public void remove(int index){
        T[] newArrayBack = Arrays.copyOfRange(myArray, 0,myArray.length-1);
        for(int i = index; i < newArrayBack.length-1;i++){
            myArray[i] = newArrayBack[i+1];
        }
        myArrayListSize--;

    }
    public int getMyArrayListSize() {
        return myArrayListSize;
    }

    public void set(int index, T tObj){
        resize(index);
        if(index > myArrayListSize){
            myArrayListSize = index+1;
        }
        myArray[index] = tObj;
    }

    public void clear(){
        myArray = (T[])new Object[10];
        myArrayListSize = 0;
    }

    public boolean isEmpty(){
        if(myArrayListSize == 0){
            return true;
        }
        return false;
    }
    public boolean contains(T tObj){
        System.out.println(myArrayListSize);
        for(int i = 0; i < myArrayListSize; i++){
            if(tObj.equals(myArray[i])){
                return true;
            }
        }
        return false;
    }

    private void resize(int index) {
        if(myArray.length < index){
            myArray = Arrays.copyOf(myArray,index*2);
        }
    }


}

