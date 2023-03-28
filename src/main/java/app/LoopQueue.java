package app;

public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];

        // int newIndex = 0;
        // for (int i = front; i % data.length != tail; i++) {
        //     newData[newIndex++] = data[i];
        // }

        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[(front + i) % data.length];
        }

        data = newData;
        front = 0;
        tail = getSize();
    }

    @Override
    public void enqueue(E e) {
        if (isFull()) {
            resize(2 * getCapacity());
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }

        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;

        if (getSize() <= getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return e;
    }

    private boolean isFull() {
        return (tail + 1) % data.length == front;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new RuntimeException("LoopQueue is empty");
        }

        return data[front];
    }

    @Override
    public int getSize() {
        if (tail < front) {
            return tail + data.length - front;
        } else {
            return tail - front;
        }
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LoopQueue size: %d, capacity: %d\n", getSize(), getCapacity()));
        sb.append("front[");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(", ");
            }
        }
        sb.append("]tail");
        return sb.toString();
    }
}
