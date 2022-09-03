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
        Node<T> newNode = new Node<>(item);
        // 插到 sentinel 跟 sentinel.next 兩節點的中間
        newNode.prev = sentinel; // a. 一樣的拉到外面
        sentinel.next = newNode; // b. 一樣的拉到外面
    
        if (size == 0) { // only sentinel node
            // newNode.prev = sentinel; // a. 一樣的拉到外面
            newNode.next = sentinel;
            // sentinel.next = newNode; // b. 一樣的拉到外面
            sentinel.prev = newNode;
        } else {
            // newNode.prev = sentinel; // a. 一樣的拉到外面
            newNode.next = sentinel.next;
            // sentinel.next = newNode; // b. 一樣的拉到外面
            newNode.next.prev = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = sentinel; // a. 一樣的拉到外面
        sentinel.prev = newNode; // b. 一樣的拉到外面
        
        if (size == 0) { // only sentinel node
            newNode.prev = sentinel;
            // newNode.next = sentinel; // a. 一樣的拉到外面
            sentinel.next = newNode;
            // sentinel.prev = newNode; // b. 一樣的拉到外面
        } else {
            newNode.prev = sentinel.prev;
            // newNode.next = sentinel; // a. 一樣的拉到外面
            sentinel.prev.next = newNode;
            // sentinel.prev = newNode; // b. 一樣的拉到外面
        }
        size++;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node<T> p = sentinel.next;
        sentinel.next = p.next;
        p.next.prev = sentinel;
        p.prev = null;
        p.next = null;
        size--;
        return p.value;
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
