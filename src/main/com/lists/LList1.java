package main.com.lists;

class Node {
    Object data;
    Node next;

    public Node(Object data){
        this.data = data;
    }
}

public class LList1<T> {
    public LList1(T[] ar) {
        for (T num:ar) {
            add(num);
        }
    }
    Node head;

    public void clear(){
        head = null;
    }

    public int size() {
        int i = 0;
        Node current = head;
        while (current != null) {
            i += 1;
            current = current.next;
        }
        return i;
    }

    public T get(int index) {
        T[] arr = toArray();
        return arr[index];
    }

    public boolean add(T data) {
        int num1 = size();
        if (head == null)
        {
            head = new Node(data);
            return true;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
        int num2 = size();
        if(num2 == num1){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean add(int index, T value) {
        T[] arr = toArray();
        if (index >= arr.length){
            return false;
        }
        else {
            clear();
            for(int i = 0; i < index; i++){
                add(arr[i]);
            }
            add(value);
            for(int i = index; i < arr.length; i++){
                add(arr[i]);
            }
            return true;
        }
    }

    public boolean remove(T number) {
        T[] arr = toArray();
        if (contains(number)){
            removeByIndex(getIndex(number, arr));
            return true;
        }
        else {
            return false;
        }
    }

    public int removeByIndex(int index) {
        if (index >= size()){
            return -1;
        }
        T[] arr = toArray();
        clear();
        for(int i = 0; i < arr.length; i++){
            if(i == index){
                continue;
            }
            add(arr[i]);
        }
        return index;
    }

    public boolean contains(T value) {
        T[] arr = toArray();
        for (T num: arr){
            if (num.equals(value)){
                return true;
            }
        }
        return false;
    }

    public boolean set(int index, T value) {
        T[] arr = toArray();
        if (index >= arr.length){
            return false;
        }
        else {
            clear();
            for(int i = 0; i < index; i++){
                add(arr[i]);
            }
            add(value);
            for(int i = index+1; i < arr.length; i++){
                add(arr[i]);
            }
            return true;
        }
    }

    public void print() {
        Node current = head;
        if(current == null){
            System.out.println("[]");
        }
        else {
            System.out.print("[");
            while (current.next != null) {
                System.out.print(current.data + ", ");
                current = current.next;
            }
            System.out.println(current.data+"]");
        }
    }

    public T[] toArray() {
        Object[] Arr;
        Node current = head;
        if(current == null){
            Arr = new Object[0];
        }
        else {
            Object[] helpArr = new Object[size()];
            int iterator = 0;
            for(int i = 0; i < size(); i++){
                helpArr[iterator] = current.data ;
                current = current.next;
                iterator++;
            }
            Arr = helpArr;
        }
        return (T[]) Arr;
    }

    public boolean removeAll(T[] ar) {
        T[] arr = toArray();
        boolean isContains = false;

        for(T num1: ar){
            for (T num2: arr) {
                if (num1.equals(num2)){
                    isContains = true;
                    break;
                }
            }
        }

        if (isContains){
            for(T num: ar){
                remove(num);
            }
            return true;
        }
        else {
            return false;
        }
    }

    private int getIndex(T number, T[] arr){
        int index = -1;
        for (int i = 0; i < arr.length; i++){
            if(number.equals(arr[i])){
                index = i;
            }
        }
        return index;
    }

}
