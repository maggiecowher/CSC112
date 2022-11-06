import java.util.Random;

// linked list class for a deck of cards
public class LinkedList {

    public Node head;
    public Node tail;
    public int size = 0;

    LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void shuffle(int shuffle_count) {

        Random rand = new Random();
        for(int i = 0; i < shuffle_count; i++) {
            // pick two random integers
            int r1 = rand.nextInt(52);
            int r2 = rand.nextInt(52);

            swap(r1,r2); // swap nodes at these indices
        }
    }

    // remove a card from a specific index
    public void remove_from_index(int index) {
        int count = 0;

        if (isEmpty()) // If the list is empty (base case)
            return;

        if (index == 0) { // If the index is zero, the card to be removed is the head, use a different method
            remove_from_head();
        } else {
            Node curr = head;
            while (count != index) { // Traverse linked list until reaching index to be removed
                curr = curr.next;
                count += 1;
            }
            if (curr.next != null) {
                Node temp1 = curr.next;
                Node temp2 = curr.prev;
                temp1.prev = curr.prev;
                temp2.next = curr.next;
                curr = null;
            } else {
                Node temp = curr.prev;
                temp.next = null;
                tail=temp;
                curr = null;
            }
            size = size -1;
        }
    }

    // insert a card at a specific index
    public void insert_at_index(Card x, int index) {
        int count = 0;
        Node insert = new Node(x);

        if (index == 0) { // If the value is inserted at the head
           head.prev = insert;
           insert.next = head;
           head = insert;
           size += 1;
       } else {
           Node curr = head;
           while (count != index) { // Traverse linked list until reaching index to be added
               curr = curr.next;
               count += 1;
           }
           if (curr == null) { // If the index is at the end of the list
               add_at_tail(x);
           } else { // If the index is not at the end or the beginning of the list
               Node temp = curr.prev;
               temp.next = insert;
               insert.prev = temp;
               insert.next = curr;
               curr.prev = insert;
               size++;
           }

       }

    }

    // swap two cards in the deck at the specific indices
    public void swap(int index1, int index2) {
        int count = 0;
        Node curr = head; // Curr pointer to be used in while loop

        Node card1 = null; // First card to be swapped
        Node card2 = null; // Second card to be swapped

        while(curr != null) { // Traverse through the entire list
            // If the counter variable is equal to either of the given indices, set the corresponding card with the
            // data of the current node
            if (count == index1) {
                card1 = new Node(curr.data);
            }
            if (count == index2) {
                card2 = new Node(curr.data);
            }
            count += 1;
            curr = curr.next;
        }

        // Swap cards using remove and insert methods
        remove_from_index(index1); // Remove card1 from index1
        insert_at_index(card2.data, index1); // Add card2 to index1
        remove_from_index(index2); // Remove card2 from index2
        insert_at_index(card1.data, index2); // Add card1 to index2

        // Make sure method worked
        sanity_check();
    }

    // add card at the end of the list
    public void add_at_tail(Card data) {
        Node newTail = new Node(data);
        size++;
        // Create new node that will become the new tail
        // Change pointers to add to tail
        if (head == null) {
            head = newTail;
        }
        if (tail != null) {
            tail.next = newTail;
            newTail.prev = tail;
        }
        tail = newTail;
    }

    // remove a card from the beginning of the list
    public Card remove_from_head() {
        Node curr = head;
        // Change pointers to remove head
        if (curr.next != null) { // If the head is not the last thing in the list
            curr = curr.next;
            curr.prev = null;
            head = curr;
        } else { // If the head is the last thing in the list
            head = null;
            tail = null;
        }
        size -= 1;

        // Make sure method worked
        sanity_check();
        
        return curr.data;
    }

    // check to make sure the linked list is implemented correctly by iterating forwards and backwards
    // and verifying that the size of the list is the same when counted both ways.
    // 1) if a node is incorrectly removed
    // 2) and head and tail are correctly updated
    // 3) each node's prev and next elements are correctly updated
    public void sanity_check() {
        // count nodes, counting forward
        Node curr = head;
        int count_forward = 0;
        while (curr != null) {
            curr = curr.next;
            count_forward++;
        }

        // count nodes, counting backward
        curr = tail;
        int count_backward = 0;
        while (curr != null) {
            curr = curr.prev;
            count_backward++;
        }

        // check that forward count, backward count, and internal size of the list match
        if (count_backward == count_forward && count_backward == size) {
           // System.out.println("Basic sanity Checks passed");
        }
        else {
            // there was an error, here are the stats
            System.out.println("Count forward:  " + count_forward);
            System.out.println("Count backward: " + count_backward);
            System.out.println("Size of LL:     " + size);
            System.out.println("Sanity checks failed");
            System.exit(-1);
        }
    }

    // print the deck
    public void print() {
        Node curr = head;
        int i = 1;
        while(curr != null) {
            curr.data.print_card();
            if(curr.next != null)
                System.out.print(" -->  ");
            else
                System.out.println(" X");

            if (i % 7 == 0) System.out.println("");
            i = i + 1;
            curr = curr.next;
        }
        System.out.println("");
    }

    public boolean isEmpty() {
        return head == null;
    }

}