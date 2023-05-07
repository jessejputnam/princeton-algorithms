public class LinkedList<Item> {
    private Node<Item> first;
    private int size;

    public Node<Item> get(int k) {
        if (isEmpty())
            return null;
        Node<Item> node = this.first;
        for (int i = 0; i < k; i++) {
            node = node.next();
        }
        return node;
    }

    public void add(Item item) {
        Node<Item> node = new Node<Item>(item);
        this.size++;

        if (this.first == null) {
            this.first = node;
            return;
        }

        for (Node<Item> n = this.first; n != null; n = n.next()) {
            if (n.next() == null) {
                n.setNext(node);
                return;
            }
        }
    }

    public Item removeLast() {
        if (isEmpty()) {
            System.out.println("Error: list is empty");
            return null;
        }

        return delete(size() - 1);
    }

    public int removeAll() {
        int total = size();
        this.first = null;
        this.size = 0;
        return total;
    }

    public int removeAll(String key) {
        int total = 0;

        Node<Item> parent = null;
        while (true) {
            Node<Item> n = (parent == null) ? this.first : parent.next();

            if (n == null)
                break;

            if (n.item().equals(key)) {
                this.size--;
                total++;
                if (parent == null)
                    this.first = n.next();
                else
                    parent.setNext(n.next());
            } else {
                parent = n;
            }
        }
        return total;
    }

    public Item removeAfter(Node<Item> node) {
        if (isEmpty() || node == null)
            return null;

        Item item = node.next().item();
        node.setNext(node.next().next());
        return item;
    }

    public void insertAfter(Node<Item> target, Node<Item> node) {
        if (target == null || node == null)
            return;
        Node<Item> temp = target.next();
        target.setNext(node);
        target.next().setNext(temp);
        this.size++;
    }

    public Item delete(int k) {
        if (k >= size()) {
            System.out.println("Error: index out of range");
            return null;
        }

        Item item = null;
        Node<Item> parent = null;

        for (int i = 0; i < k; i++)
            parent = parent == null ? this.first : parent.next();

        if (parent == null) {
            item = this.first.item();
            this.first = this.first.next();
        } else {
            item = parent.next().item();
            parent.setNext(parent.next().next());
        }

        this.size--;
        return item;
    }

    public boolean find(String key) {
        for (Node<Item> n = this.first; n != null; n = n.next()) {
            if (n.item().equals(key))
                return true;
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public String toString() {
        String output = "";
        for (Node<Item> n = this.first; n != null; n = n.next())
            output += n.item() + ", ";
        return output.isEmpty() ? null : "[" + output.substring(0, output.length() - 2) + "]";
    }
}
