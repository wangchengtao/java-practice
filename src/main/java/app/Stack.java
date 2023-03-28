package app;

public interface Stack<E> {
    /**
     * 压栈
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     * @return
     */
    E pop();

    /**
     * 当前栈顶元素
     * @return
     */
    E peek();

    /**
     * 栈大小
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();
}
