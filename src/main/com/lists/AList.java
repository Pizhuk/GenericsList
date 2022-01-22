package main.com.lists;

import java.util.Arrays;

public class AList<T>{
    private int capacity;
    private Object[] array;


    public AList(T[] array) {
        this.array = array;
        capacity = array.length;
    }

    public AList() {
        capacity = 10;
        array = new Object[capacity];
    }

    public AList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    public void clear() {
        array = new Object[0];
    }


    public int size() {
        return array.length;
    }


    public Object get(int index) {
        return (T)array[index];
    }


    public boolean add(T value) {
        int amount = 0;
        for (int i = 0; i < array.length; i++) {
            if((array[i]+"").equals("null")){
                array[i] = value;
                amount++;
                return true;
            }
        }
        if (amount == 0){
            Object[] helpArr = new Object[array.length*2];
            for (int i = 0; i < array.length; i++){
                helpArr[i] = array[i];
            }
            helpArr[array.length] = value;
            array = helpArr;
            return true;
        }
        return false;
    }

    public boolean add(int index, T value) {
        if(index < array.length){
            Object[] helpArr = new Object[array.length+1];
            for(int i = 0; i < index; i++){
                helpArr[i] = array[i];
            }
            helpArr[index] = value;
            for(int i = index+1; i < array.length+1; i++){
                helpArr[i] = array[i-1];
            }
            array = helpArr;
            return true;
        }
        else {
            Object[] helpArr = new Object[index+5];
            for (int i = 0; i < array.length; i++){
                helpArr[i] = array[i];
            }
            helpArr[index] = value;
            array = helpArr;
            return true;
        }
    }

    public boolean remove(T value) {
        int index = -1;

        for(int i = 0; i < array.length; i++){
            if(array[i] == value){
                index = i;
                break;
            }
        }

        if(index == -1){
            return false;
        }
        else {
            Object[] helpArr = new Object[array.length-1];
            for (int i = 0; i < index; i++){
                helpArr[i] = array[i];
            }
            for (int i = index+1; i < array.length; i++){
                helpArr[i-1] = array[i];
            }
            array = helpArr;
            return true;
        }
    }

    public int removeByIndex(int index) {
        if(index >= array.length){
            return -1;
        }
        else {
            Object[] helpArr = new Object[array.length-1];
            for (int i = 0; i < index; i++){
                helpArr[i] = array[i];
            }
            for (int i = index+1; i < array.length; i++){
                helpArr[i-1] = array[i];
            }
            array = helpArr;
            return index;
        }
    }

    public boolean contains(T value) {
        for (Object obj:array) {
            if(obj == null){
                continue;
            }
            else {
                if(obj.equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean set(int index, T value) {
        if(index < array.length){
            array[index] = value;
            return true;
        }
        return false;
    }

    //
    public void print() {
        System.out.println(Arrays.toString(array));
    }

    public T[] toArray() {
        return (T[]) array;
    }

    public boolean removeAll(T[] ar) {
        T[] arrayCMP = (T[]) array;
        for(int i = 0; i < ar.length; i++){
            remove(ar[i]);
        }

        if(array != arrayCMP){
            return true;
        }
        return false;
    }
}
