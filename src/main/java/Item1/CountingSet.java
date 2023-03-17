package Item1;

import java.util.Collection;
import java.util.HashSet;

public class CountingSet {
    private int count = 0;
    private HashSet<Object> set = new HashSet<>();

    public boolean add(Object o) {
        count++;
        return set.add(0);
    }

    public boolean addAll(Collection c) {
        count += c.size();
        return set.addAll(c);
    }

    public boolean remove(Object obj) {
        return set.remove(obj);
    }

    public int size() {
        return set.size();
    }

    public boolean removeAll(Collection c) {
        count -= c.size();
        return set.removeAll(c);
    }

    public int getCount() {
        return count;
    }

}
