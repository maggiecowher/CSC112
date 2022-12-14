/** This program acts as shopping experience where all the input comes from the command line. The program checks to make
 * sure that the input is legal before it adds the item to the cart, while also avoiding any runtime errors and crashing
 * of the program. The program creates a store, then creates a cart by filling it with the inputs given in the command
 * line. After creating a cart the program prints the receipt in the order it was filled with the command line inputs.
 * </p>
 * This class creates the shopping class using a queue. The queue class has an enqueue(), dequeue(), and peek() method.
 * The enqueue() method adds to the end/back of the queue, the dequeue() method removes from the front/beginning of the
 * queue and returns that element, the peek() method returns the element at the front/beginning of the queue.
 * </p>
 * Maggie Cowher
 * March 31, 2022
 */

public class Lab7_queue {
    static class Item{
        private String itemName;
        private double itemPrice;

        public Item(String name, double price) {
            itemName = name;
            itemPrice = price;
        }

        public double getItemPrice() {
            return itemPrice;
        }

        public String getItemName() {
            return itemName;
        }
        // String interface for Item
        @Override
        public String toString() {
            String itemInfo;
            itemInfo = getItemName() + "\t\t" + "$%.2f".formatted(getItemPrice());
            return itemInfo;
        }

    }

    public static Item[] setupStore() {

        Item[] store = new Item[5];
        store[0] = new Item("Bananas", 1.5);
        store[1] = new Item("Apple", 0.5);
        store[2] = new Item("Bread", 2.0);
        store[3] = new Item("Milk", 3.0);
        store[4] = new Item("Eggs", 2.5);

        return store;
    }

    public static Queue<Item> createCart(Item[] itemList, String[] args) {

        Queue<Item> cart = new Queue<Item>();//set up ArrayList to contain the items in the cart

        for (int i = 0; i < args.length; i++) {
            int j;//j contains the token from the command line
            //the outer try catch statement tests whether the token represent an integer

            try {
                j = Integer.parseInt(args[i]);
                cart.enqueue(itemList[j]);//add the corresponding item into cart
            }
            catch (NumberFormatException e1) {
                System.out.println("\"" + args[i] + "\" is not a valid integer.");
            }
            //the second catch statement tests whether the integer value of the token
            // consistent with your Store
            catch (IndexOutOfBoundsException e2) {
                System.out.println("The store does not have an item of index " + args[i] + ".");

            }
        }
        return cart;
    }

    public static void printReceiptInOrder(Queue<Item> cart) {

        double subtotal = 0.0;
        double total;
        double tax = 5.0;
        double taxValue = 0.05;
        //print out receipt
        System.out.println();
        System.out.println("Receipt");
        System.out.println("=========================");
        System.out.println("Item\t\tPrice");
        //use a while loop to get the item name and price of every item from cart
        while (!cart.empty()) {
            Item item = cart.dequeue();
            subtotal += item.getItemPrice();
            System.out.println(item);
        }
        //calculate total price
        total = (1 + taxValue) * subtotal;
        System.out.println("=========================");
        //print out sum
        System.out.printf("(a) Subtotal: $%.2f\n", subtotal);
        System.out.printf("(b) Sales Tax: %.2f%%\n", tax);
        System.out.printf("(c) Total: $%.2f\n", total);

        System.out.println("Removed all items from the cart in \"Last In Last Out\" order");
    }

    public static void emptyCartReverseOrder(Queue<Item> cart) {

        while(!cart.empty()) {
            System.out.println("Removing: " + cart.peek().getItemName());
            cart.dequeue();
        }

        System.out.println("Cart has been emptied");

    }

    public static void main(String[] args) {
        Item itemList[] = setupStore();

        Queue<Item> cart = createCart(itemList, args);

        if(!cart.empty()) {
            printReceiptInOrder(cart);
        }
        else {
            System.out.println("No valid input to cart");
        }
    }
}
