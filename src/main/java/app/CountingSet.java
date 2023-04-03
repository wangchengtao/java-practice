package app;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class CountingSet  {
    private HashSet<Object> hashSet = new HashSet<>();
    private int count = 0;

    public boolean add(Object obj) {
        count++;
        return hashSet.add(obj);
    }

    public boolean addAll(Collection c) {
        count += c.size();
        return hashSet.addAll(c);
    }

    public boolean remove(Object obj) {
        return hashSet.remove(obj);
    }

    public int size() {
        return hashSet.size();
    }

    public boolean removeAll(Collection c) {
        return hashSet.removeAll(c);
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        CountingSet countingSet = new CountingSet();
        countingSet.add(new Object());
        countingSet.addAll(Arrays.asList(1, 2, 3, 4, 5));

        System.out.println(countingSet.getCount());
    }
}
