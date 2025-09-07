package m1p1;

import java.util.Arrays;
import java.util.Collection;

public class CustomLinkedList<T> {

    private static class Node<T>{
        T _obj;
        Node<T> _prev;
        Node<T> _next;

        Node(T obj, Node<T> prev, Node<T> next){
            this._obj = obj;
            this._prev = prev;
            this._next = next;
        }
    }

    private Node<T> _firstNode;
    private Node<T> _lastNode;
    private int listSize = 0;

    public int getListSize(){
        return this.listSize;
    }

    public CustomLinkedList(){

    }

    public void add(T item){
        Node<T> n = this._lastNode;
        Node<T> newNode = new Node<>(item, n, null);
        this._lastNode = newNode;

        if(n == null)
            this._firstNode = newNode;
        else n._next = newNode;

        this.listSize++;
    }

    public void add(T item, int position){
        if(!checkIndex(position,true)) throw new IndexOutOfBoundsException();
        Node<T> n = GetNode(position);
        Node<T> nPrev = n._prev;//GetNode(position-1);
        Node<T> newNode = new Node<>(item, nPrev, n);

        nPrev._next=newNode;
        n._prev=newNode;

        this.listSize++;
    }

    public T get(int position){
        if(!checkIndex(position, false)) throw new IndexOutOfBoundsException();
        return GetNode(position)._obj;
    }

    private Node<T> GetNode(int position){
        Node<T> n;
        if(position < (this.listSize >> 1) ){
            //start
            n = this._firstNode;
            for(int i = 0; i<position; i++)
                n = n._next;
        } else{
            //end
            n = this._lastNode;
            for(int i = this.listSize - 1; i>position; i--)
                n = n._prev;
        }
        return n;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (Node<T> x = this._firstNode; x != null; x = x._next) {
                if (x._obj == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<T> x = this._firstNode; x != null; x = x._next) {
                if (o.equals(x._obj)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }
    void unlink(Node<T> x) {
        final Node<T> next = x._next;
        final Node<T> prev = x._prev;

        if (prev == null) {
            this._firstNode = next;
        } else {
            prev._next = next;
            x._prev = null;
        }

        if (next == null) {
            this._lastNode = prev;
        } else {
            next._prev = prev;
            x._next = null;
        }

        x._obj = null;
        this.listSize--;
    }

    public boolean addAll(Collection<? extends T> c) { return addAll(c, this.listSize); }
    public boolean addAll(Collection<? extends T> c, int position){
        if(!checkIndex(position, true)) throw new IndexOutOfBoundsException();

        Object[] arr = c.toArray();
        if(arr.length == 0) return false;

        Node<T> nPrev, nNext;

        if(position == this.listSize){
            nPrev = this._lastNode;
            nNext = null;
        }
        else{
            nNext = GetNode(position);
            nPrev = nNext._prev;
        }

        for(Object o: arr){
            T obj = (T)o;
            Node<T> n = new Node<>(obj, nPrev, null);
            if(nPrev == null)
                this._firstNode = n;
            else
                nPrev._next = n;
            nPrev=n;
        }

        if(nNext == null)
            this._lastNode = nPrev;
        else{
            nPrev._next = nNext;
            nNext._prev = nPrev;
        }

        this.listSize+=arr.length;

        return true;
    }

    private boolean checkIndex(int i, boolean includes) { return i >= 0 && (includes?i <= this.listSize:i<this.listSize); }

    public Object[] toArray() {
        Object[] result = new Object[this.listSize];
        int i = 0;
        for (Node<T> x = this._firstNode; x != null; x = x._next)
            result[i++] = x._obj;
        return result;
    }


    public void Print(){
        Arrays.stream(this.toArray())
                .reduce((a, e)-> a + ", " + e.toString())
                .ifPresentOrElse(System.out::println, ()-> System.out.println("List is empty"));
    }

}
