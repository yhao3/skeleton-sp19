@SuppressWarnings("unused")
public class LinkedListDeque<T> implements Deque<T> {
    private int size;
    private Node<T> sentinel;

    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        public Node(T value, LinkedListDeque.Node<T> prev, LinkedListDeque.Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node<>(null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /**
     * Creating a deep copy means that you create an entirely new LinkedListDeque, with the exact same items as other. 
     * However, they should be different objects, i.e. if you change other, the new LinkedListDeque you created should not change as well.
     * @param other: another linkedlist to be copied from.
     */
    public LinkedListDeque(LinkedListDeque<T> other) {
        size = 0;
        sentinel = new Node<>(null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;

        for (int i = 0; i < other.size; i++) {
            addLast(other.get(i));
        }
    }

    @Override
    public void addFirst(T item) {
        // TODO Auto-generated method stub
    }

    @Override
    public void addLast(T item) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public T removeFirst() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T removeLast() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T getRecursive(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void printDeque() {
        // TODO Auto-generated method stub
        
    }
}
