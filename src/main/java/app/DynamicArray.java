package app;


public class DynamicArray<E> {
    private E[] data;
    private int size;

    public DynamicArray(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public DynamicArray() {
        this(10);
    }

    public DynamicArray(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        add(e, size);
    }

    public void addFirst(E e) {
        add(e, 0);
    }

    public void add(E e, int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("Add failed. Required index >= 0 and index <= size");
        }

        if (size == data.length) {
            resize(data.length * 2);
        }

        // if (size - index >= 0) System.arraycopy(data, index, data, index + 1, size - index);
        for (int i = size - 1; i >= index ; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E removeFirst() {
        return remove(0);
    }

    public boolean removeElement(E e) {
        int index = find(e);

        if (index != -1) {
            remove(index);
            return true;
        }

        return false;
    }

    public boolean removeAllElements(E e) {
        int count = getElementCount(e);
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                removeElement(e);
            }
            return true;
        } else {
            return false;
        }
    }

    public E remove(int index) {
        if (size <= 0) {
            throw new IllegalArgumentException("Remove failed. Array is empty");
        }

        if (index < 0 | index >= size) {
            throw new IllegalArgumentException("Index is Illegal!");
        }

        E ret = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed");
        }

        return data[index];
    }

    public E getLast() {
        return data[size - 1];
    }

    public E getFirst() {
        return data[0];
    }

    public void set(E e, int index) {
        if (index < 0 || index >= size) {
            throw  new IllegalArgumentException("Get failed");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        return find(e) != -1;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    public int[] findALl(E e) {
        int count = getElementCount(e);
        if(count == 0) {
            return new int[]{};
        }
        int[] ret = new int[count];
        int retIndex = 0;
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                ret[retIndex++] = i;
            }
        }
        return ret;
    }

    public int getElementCount(E e) {
        int ret = 0;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                ret++;
            }
        }

        return ret;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal");
        }

        E e = data[i];
        data[i] = data[j];
        data[j] = e;
    }
}
