public class Node<Item> {
    private Item item;
    private Node<Item> next;

    public Node(Item item) {
        this.item = item;
        this.next = null;
    }

    public Item item() {
        return this.item;
    }

    public Node<Item> next() {
        return this.next;
    }

    public void setNext(Node<Item> node) {
        this.next = node;
    }

    public String toString() {
        return "[item: " + this.item + ", next: " + (this.next == null ? " - " : this.next.item()) + "]";
    }
}
