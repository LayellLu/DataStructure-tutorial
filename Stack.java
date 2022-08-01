////package misc;
//
//import java.util.EmptyStackException;
//
//class Node<T> {
//    private T item;
//    private Node<T> next;
//
//    public Node(T item, Node<T> next) {
//        this.item = item;
//        this.next = next;
//    }
//
//    public T getItem() {
//        return item;
//    }
//
//    public void setItem(T item) {
//        this.item = item;
//    }
//
//    public Node<T> getNext() {
//        return next;
//    }
//
//    public void setNext(Node<T> next) {
//        this.next = next;
//    }
//}
//
//public class Stack<T> {
//    private Node<T> top;
//    private int size;
//
//    public Stack() {
//        top = null;
//        size = 0;
//    }
//
//    public void push(T item) {
//        final Node<T> node = new Node<>(item, null);
//        if (top == null) {
//            top = node;
//        } else {
//            node.setNext(top);
//            top = node;
//        }
//        size ++;
//    }
//
//    public T pop() throws EmptyStackException {
//        if (top == null) throw new EmptyStackException();
//        final T item = top.getItem();
//        top = top.getNext();
//        size--;
//        return item;
//    }
//
//    public int size() { return size; }
//
//    public T peek() {
//        if (top == null) return null;
//        return top.getItem();
//    }
//
//    public boolean isEmpty() { return size == 0; }
//}
