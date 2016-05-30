package io.minlee;

import org.hamcrest.internal.ArrayIterator;

import java.util.*;

/**
 * Created by minlee on 5/30/16.
 */
public class MySet<T> {


    private T[] myArray;
    private int mySetSize;

    public MySet(){
        myArray = (T[])new Object[0];
        mySetSize = 0;
    }

    public boolean add(T tObj){
        if(!contains(tObj)){
            myArray = Arrays.copyOf(myArray, myArray.length+1);
            myArray[myArray.length-1] = tObj;
            return true;
        }

        return false;
    }

    public boolean addAll(Collection<T> tCollection){
        Iterator<T> tIterator = tCollection.iterator();
        boolean result = false;
        while(tIterator.hasNext()){
            T currentObj = tIterator.next();
            if(!contains(currentObj)){
                add(currentObj);
                result = true;
            }
        }
        return result;
    }

    public void clear(){
        myArray = (T[])new Object[0];
    }

    public boolean contains(T tObj){
        for(int i = 0; i < myArray.length; i++){
            if(tObj.equals(myArray[i])){
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Collection<?> tCollection){
        Iterator<?> tIterator = tCollection.iterator();
        boolean result = true;
        while(tIterator.hasNext()){
            T currentObj = (T) tIterator.next();
            if(!contains(currentObj)){
                result = false;
            }
        }
        return result;
    }

    public boolean equals(Object tObj){
        if (!(tObj instanceof Set))
            return false;
        Collection<?> c = (Collection<?>) tObj;
        if (c.size() != myArray.length)
            return false;
        try {
            return containsAll(c);
        } catch (ClassCastException unused)   {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public int hashCode(){
        int hashCode = 0;
        Iterator<T> tIterator = iterator();
        while (tIterator.hasNext()) {
            T obj = tIterator.next();
            if (obj != null)
                hashCode += obj.hashCode();
        }
        return hashCode;
    }

    public boolean isEmpty(){
        if(myArray.length == 0)
            return true;
        return false;
    }

    public Iterator<T> iterator(){
        Iterator<T> iterator = (Iterator<T>) new ArrayIterator(myArray);
        return iterator;
    }

    public boolean remove(T tObj){
        if(contains(tObj)){
            int index = removeableIndex(tObj);
            T[] newArrayBack = Arrays.copyOf(myArray, myArray.length);
            myArray = Arrays.copyOf(myArray, myArray.length-1);
            for(int i = index; i < newArrayBack.length-1;i++){
                myArray[i] = newArrayBack[i+1];
            }
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection<T> tCollection){
        Iterator<T> tIterator = tCollection.iterator();
        boolean result = false;
        while(tIterator.hasNext()){
            T currentObj = tIterator.next();
            if(contains(currentObj)){
                remove(currentObj);
                result = true;
            }
        }
        return result;
    }

    public boolean retainAll(Collection<T> tCollection){
        boolean result = false;
        MyArrayList<T> tempArrayList = new MyArrayList<>();
        Iterator<T> tIterator = tCollection.iterator();
        while(tIterator.hasNext()){
            T currentObj = tIterator.next();
            if(contains(currentObj)){
                tempArrayList.add(currentObj);
                result = true;
            }
        }
        myArray = (T[])new Object[tempArrayList.getMyArrayListSize()];
        for(int i = 0; i < myArray.length; i++){
            myArray[0] = tempArrayList.get(i);
        }
        return result;
    }
    public int size(){
        return myArray.length;
    }
    public Object[] toArray(){
        return myArray;
    }
    public T[] toArray(T[] a){
        T[] array = a;
        return array;
    }

    private int removeableIndex(T tObj){
        for(int i = 0; i < myArray.length; i++){
            if(tObj.equals(myArray[i])){
                return i;
            }
        }
        return 0;
    }

}
