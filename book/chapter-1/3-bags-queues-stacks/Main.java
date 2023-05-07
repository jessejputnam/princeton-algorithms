public class Main {
    public static void main(String[] args) {
        // Exercise 1
        // System.out.println(ex1("([{[()]}([]{}))"));

        // Exercise 1.3.14
        // ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings(3);

        // LinkedList exercises
        LinkedList<String> list = new LinkedList<>();
        // System.out.println(list + " " + list.size());
        list.add("One");
        // System.out.println(list + " " + list.size());
        list.add("Two");
        // System.out.println(list + " " + list.size());
        list.add("Three");
        // System.out.println(list + " " + list.size());
        list.add("Four");
        // System.out.println(list + " " + list.size());
        list.add("Five");
        // System.out.println(list + " " + list.size());
        // System.out.println(list.delete(2));
        // System.out.println(list + " " + list.size());
        // System.out.println(list.remove());
        // System.out.println(list + " " + list.size());
        // list.delete(1);
        Node<String> node = list.get(1);
        list.removeAfter(node);
        System.out.println(list);
    }

    public static boolean ex1(String str) {
        Parentheses<Character> p = new Parentheses<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                p.push(ch);
            } else {
                char popped = p.pop();
                if (!checkValidParens(popped, ch))
                    return false;
            }
        }

        return p.isEmpty();
    }

    private static boolean checkValidParens(char popped, char ch) {
        return Math.abs(ch - popped) < 3;
    }
}