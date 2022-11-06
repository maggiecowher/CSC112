class Node<T> {
    public T data;
    public Node<T> next;

    public Node (T data) {
        this.data = data;
    }

}

public class Stack <T>{
    Node<T> head = null;

    // Constructor
    public Stack (Node<T> head) {
        this.head = head;
    }

    // Push method to add to the top of the stack
    public Node<T> push(Node<T> data) {
        data.next = head;
        head = data;
        return head;
    }

    // Pop method to take off the top of the stack
    public Node<T> pop() {
        Node<T> curr = head;
        head = curr.next;
        return curr;
    }

    // isEmpty method to return true if the stack is empty ot false if not
    public boolean isEmpty() {
        return head == null;
    }

    // Peek method to return the top of the stack
    public Node<T> peek() {
        return head;
    }
}
