public class Main {
    public static void main(String[] args) {
        // Exercise 1
        // System.out.println(ex1("([{[()]}([]{}))"));
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings(3);
        queue.enqueue("one");
        System.out.println(queue);
        queue.enqueue("one");
        System.out.println(queue);
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