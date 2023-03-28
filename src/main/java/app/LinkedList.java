package app;

public class LinkedList<E> {
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is illegal");
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next = new Node(e, pre.next);
        size++;
    }

    public void addFirst(E e) {
        add(e, 0);
    }

    public void addLast(E e) {
        add(e, size);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is illegal");
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        return pre.next.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(E e, int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is illegal");
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;

        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }

            cur = cur.next;
        }

        return false;
    }

    public void removeElement(E e) {
        Node pre = dummyHead;

        while(pre.next != null) {
            if (pre.next.e.equals(e)) {
                Node delNode = pre.next;
                pre.next = delNode.next;
                delNode.next = null;
                size--;

                return;
            }
            pre = pre.next;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        Node e = pre.next;
        pre.next = e.next;
        size--;
        e.next = null;

        return e.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Linked list size: " + size + "\n");
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur.e).append("->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }


    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

}
