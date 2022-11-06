public class LinkedList1 {
    public Node head;

    // Possible to track size as an integer variable

    public LinkedList1(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void append(Node n) {
        if (head == null) {
            head = new Node(n);
        }
        else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.getNext();
            }

            curr.setNext(new Node(n));//adds to end

        }
    }

    public void prepend(Node n) {
        if (head == null) {
            head = new Node(n);
        }
        else {
            Node head1 = head;
            n.next = head1;
            setHead(n);
        }
    }

    public void insertAtMid (Node n, int loc) {
        if (head == null) {
            head = new Node(n);
        } else {
            Node curr = head;
            int counter = 0;
            while (curr.next != null) {
                if (loc == counter) {
                    n.next = curr.next;
                    curr.next = n;

                }
                counter += 1;
                curr = curr.next;
            }
        }
    }
}
