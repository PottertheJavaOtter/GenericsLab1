package io.minlee;

import java.util.*;

/**
 * Created by minlee on 5/30/16.
 */
public class MyMap<K,V> {

    private K[] myKeyArray;
    private V[] myValueArray;

    private int myArrayListSize;

    public MyMap(){
        myKeyArray = (K[])new Object[0];
        myValueArray = (V[])new Object[0];

    }

    public void clear(){
        myKeyArray = (K[])new Object[0];
        myValueArray = (V[])new Object[0];
    }

    public boolean containsKey(K key){
        for(int i = 0; i < myKeyArray.length; i++){
            if(key.equals(myKeyArray[i])){
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(V value){
        for(int i = 0; i < myValueArray.length; i++){
            if(value.equals(myValueArray[i])){
                return true;
            }
        }
        return false;
    }


    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> entrySet = new HashSet<>();
        for(int i = 0; i < myKeyArray.length; i++){
            Map.Entry<K,V> myEntry = new MyEntry<>(myKeyArray[i],myValueArray[i]);
            entrySet.add(myEntry);
        }
        return entrySet;
    }


    public boolean equals(Object o){
        if (o == this)
            return true;

        if (!(o instanceof Map))
            return false;
        Map<?,?> m = (Map<?,?>) o;
        if (m.size() != size())
            return false;

        try {
            Iterator<Map.Entry<K,V>> i = entrySet().iterator();
            while (i.hasNext()) {
                Map.Entry<K,V> e = i.next();
                K key = e.getKey();
                V value = e.getValue();
                if (value == null) {
                    if (!(m.get(key)==null && m.containsKey(key)))
                        return false;
                } else {
                    if (!value.equals(m.get(key)))
                        return false;
                }
            }
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }

        return true;
    }

    public V get(K key){
        if(containsKey(key)){
            for(int i = 0; i < myKeyArray.length; i++){
                if(key.equals(myKeyArray[i])){
                    return myValueArray[i];
                }
            }
        }
        return null;
    }
    public int hashCode(){
        int h = 0;
        Iterator<Map.Entry<K,V>> i = entrySet().iterator();
        while (i.hasNext())
            h += i.next().hashCode();
        return h;
    }

    public boolean isEmpty(){
        if(myKeyArray.length < 1){
            return true;
        }
        return false;
    }

    public Set<K> keySet(){
        Set<K> newKeySet = new TreeSet<>();
        for(int i = 0; i < myKeyArray.length; i++){
            newKeySet.add(myKeyArray[i]);
        }
        return newKeySet;
    }
    public V put(K key, V value){
        if(containsKey(key)){
            for(int i = 0; i < myKeyArray.length; i++){
                if(key.equals(myKeyArray[i])){
                    V previousValue = myValueArray[i];
                    myValueArray[i] = value;
                    return previousValue;
                }
            }
        }
        else
        {
            myKeyArray = Arrays.copyOf(myKeyArray, myKeyArray.length+1);
            myKeyArray[myKeyArray.length-1] = key;
            myValueArray = Arrays.copyOf(myValueArray, myValueArray.length+1);
            myValueArray[myValueArray.length-1] = value;

        }
        return null;
    }
    public void putAll(MyMap<K,V> map){
        for (Map.Entry<? extends K, ? extends V> e : map.entrySet())
            put(e.getKey(), e.getValue());
    }

    public V remove(K key){
        if(containsKey(key)){
            int index = removeableKeyIndex(key);
            K[] newKArrayBack = Arrays.copyOf(myKeyArray, myKeyArray.length);
            myKeyArray = Arrays.copyOf(myKeyArray, myKeyArray.length-1);
            for(int i = index; i < newKArrayBack.length-1;i++){
                myKeyArray[i] = newKArrayBack[i+1];
            }
            V returnValue = myValueArray[index];
            V[] newVArrayBack = Arrays.copyOf(myValueArray, myValueArray.length);
            myValueArray = Arrays.copyOf(myValueArray, myValueArray.length-1);
            for(int i = index; i < newVArrayBack.length-1;i++){
                myValueArray[i] = newVArrayBack[i+1];
            }
            return returnValue;
        }
        return null;
    }

    public int size(){
        return myKeyArray.length;
    }

    public Collection<V> values(){
        Collection<V> values = new ArrayList<V>();
        for(int i = 0; i < myValueArray.length; i++){
            values.add(myValueArray[i]);
        }
        return values;
    }

    private int removeableKeyIndex(K key){
        for(int i = 0; i < myKeyArray.length; i++){
            if(key.equals(myKeyArray[i])){
                return i;
            }
        }
        return 0;
    }

    private final class MyEntry<K, V> implements Map.Entry<K, V> {
        private final K entryKey;
        private V entryValue;

        public MyEntry(K key, V value) {
            entryKey = key;
            entryValue = value;
            System.out.println();
        }

        public K getKey() {
            return entryKey;
        }

        public V getValue() {
            return entryValue;
        }
        public V setValue(V value) {
            V old = entryValue;
            entryValue = value;
            return old;
        }
    }


}
