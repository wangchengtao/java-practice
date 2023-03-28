package app;

// first in first out
public class ArrayStack<E> implements Stack<E> {
    private DynamicArray<E> array;

    public ArrayStack(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    public ArrayStack() {
        this(10);
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array Stack size: %d, capacity: %d\n", getSize(), getCapacity()));

        for (int i = array.getSize() - 1; i >= 0; i--) {
            sb.append("[" + array.get(i) + "]");
            if (i != 0) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}
