public class Node {
    Video data;
    Node next;
    Node prev;

    public Node (Video data) {
        this.data = data;
    }

    public Node (Node n) {
        data = n.data;
    }

    public Video getVideo() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
