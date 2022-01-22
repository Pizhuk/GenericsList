package main.com.lists;

import java.util.Arrays;

class ListNode{
    private Object val;
    private ListNode prev;
    private ListNode next;

    public ListNode(Object val) {
        this.val = val;
    }

    public Object getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode getPrev() {
        return prev;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}



public class LList2<T> {
    private ListNode head;
    private ListNode last;

    public LList2(T[] arr) {
        for (T num:arr) {
            add(num);
        }
    }

    public boolean addFirst(T data){
        int i = size();
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else {
            node.setNext(this.head);
            head.setPrev(node);
            head = node;
        }
        if(size()-i == 1){
            return true;
        }
        else {
            return false;
        }
    }

    public void print(){
        System.out.println(Arrays.toString(toArray()));
    }

    public T[] toArray() {
        ListNode cur = this.head;
        Object[] arr = new Object[size()];
        int iterator = 0;
        while (cur != null){
            arr[iterator] = cur.getVal();
            cur = cur.getNext();
            iterator++;
        }
        return (T[]) arr;
    }

    public boolean removeAll(T[] ar) {
        if (toArray() == ar){
            clear();
            return true;
        }
        int num = size();
        for (int i = 0; i < ar.length; i++) {
            remove(ar[i]);
        }
        if (size() == num) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addLast(T data){
        ListNode node = new ListNode(data);
        int i = size();
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else{
            last.setNext(node);
            node.setPrev(last);
            this.last = node;
        }
        if (size()-i == 1){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean add(T value){
        int i = size();
        addLast(value);
        if (size()-i == 1){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean add(int index,T value){
        if (index < 0 || index > size()){
            return false;
        }
        if(index == 0){
            addFirst(value);
            return false;
        }
        if(index == size()){
            addLast(value);
            return false;
        }
        int i = size();
        ListNode cur = this.head;
        while (index != 0){
            cur = cur.getNext();
            index--;
        }
        ListNode node =new ListNode(value);
        node.setNext(cur);
        node.setPrev(cur.getPrev());
        node.getPrev().setNext(node);
        cur.setPrev(node);
        if (size()-i == 1){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean contains(T value){
        ListNode cur = this.head;
        while (cur != null){
            if (cur.getVal().equals(value)){
                return true;
            }
            cur= cur.getNext();
        }
        return false;
    }

    public boolean set(int index, T value) {
        if (index > size()) {
            return false;
        }
        else {
            T[] ar = toArray();
            ar[index] = value;
            clear();
            for (int i = 0; i < ar.length; i++) {
                add(ar[i]);
            }
            if (toArray()[index] == value) {
                return true;
            } else {
                return false;
            }
        }
    }

    private ListNode findNode(T key) {
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.getVal().equals(key)) {
                return cur;
            }
            cur = cur.getNext();
        }
        return null;
    }

    public boolean remove(T number){
        ListNode cur = this.findNode(number);
        int i = size();
        if (cur == null) {
            return false;
        }
        if (cur == this.head && size() == 1) {
            clear();
            return true;
        }
        if (cur == this.head && size() != 1) {
            this.head = this.head.getNext();
            this.head.setPrev(null);
            if (size() - i == -1) {
                return true;
            } else {
                return false;
            }
        }
        if (cur == this.last) {
            cur.getPrev().setNext(null);
            this.last = this.last.getPrev();
            return false;
        }
        cur.getPrev().setNext(cur.getNext());
        cur.getNext().setPrev(cur.getPrev());
        if (size() - i == -1) {
            return true;
        } else {
            return false;
        }
    }

    public int removeByIndex(int index) {
        if (index >= size()){
            return -1;
        }
        T num = toArray()[index];
        remove(num);
        return index;
    }

    public int size(){
        ListNode cur = this.head;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }

    public T get(int index) {
        return toArray()[index];
    }

    public void clear(){
        ListNode cur = this.head;
        while (cur != null) {
            ListNode curNext = cur.getNext();
            cur.setNext(null);
            cur.setPrev(null);
            cur = curNext;
        }
        this.last = null;
        this.head = null;
    }
}
