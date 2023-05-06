public class Parentheses<Item> {
    private Node first;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return this.n;
    }

    public void push(Item item) {
        Node prevFirst = this.first;
        this.first = new Node();
        this.first.item = item;
        this.first.next = prevFirst;
        n++;
    }

    public Item pop() {
        Item item = this.first.item;
        this.first = this.first.next;
        n--;
        return item;
    }

    public Item peek() {
        return this.first.item;
    }
}
