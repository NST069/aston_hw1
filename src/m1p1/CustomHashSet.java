package m1p1;

import java.util.HashMap;

public class CustomHashSet<T>{


    private final HashMap<T, Object> _hashMap;

    static final Object DUMMY = new Object();

    public CustomHashSet(){
        this._hashMap = new HashMap<>();
    }

    public CustomHashSet(int size){
        this._hashMap = new HashMap<>(size);
    }

    public boolean add(T t){
        return this._hashMap.put(t, DUMMY) == null;
    }

    public boolean remove(Object o) {
        return this._hashMap.remove(o) == DUMMY;
    }

    @Override
    public String toString(){
        if(this._hashMap.isEmpty()) return "";
        StringBuilder s = new StringBuilder();
        for(T obj : this._hashMap.keySet())
            s.append(obj.toString()).append(", ");
        return s.substring(0, s.length() - 2);
    }

}
