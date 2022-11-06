public class Queue<T> extends List<T> {
    Node tail = null; // Create tail so that the enqueue method has a constant complexity rather than linear

    // Null constructor
    public Queue() {
        head = null;
    }

    // Add method
    public void enqueue(T data) {
        Node curr = new Node(data, null, null); // Create node with generic data type from parameter

        if (head == null) { // If the queue is empty, initialize it with this given data
            head = curr;
        } else { // Else, add the data to the end of the list
            tail.next = curr;
            curr.prev = tail;
        }
        tail = curr;
    }

    // Remove method to take out the first (oldest) entry in the list
    public T dequeue() {
        Node curr = head;
        head = curr.next;
        return curr.value;
    }

    // Peek method that returns the first (oldest) element in the list
    public T peek() {
        return head.value;
    }
}