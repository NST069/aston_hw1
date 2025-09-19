package m1.m1p1;

import java.util.ArrayList;
import java.util.List;

public class AnotherCustomHashSet<T> {
    private final int CAPACITY = 16; // количество бакетов
    private List<T>[] buckets;


    public AnotherCustomHashSet() {
        buckets = new ArrayList[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    private int getBucketIndex(T element) {
        return (element == null ? 0 : Math.abs(element.hashCode() % CAPACITY));
    }

    public boolean add(T element) {
        int index = getBucketIndex(element);
        List<T> bucket = buckets[index];

        for (T e : bucket) {
            if (e == null && element == null) return false;
            if (e != null && e.equals(element)) return false;
        }

        bucket.add(element);
        return true;
    }

    public boolean remove(T element) {
        int index = getBucketIndex(element);
        List<T> bucket = buckets[index];
        return bucket.remove(element);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;

        for (List<T> bucket : buckets) {
            for (T e : bucket) {
                if (!first) sb.append(", ");
                sb.append(e);
                first = false;
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
