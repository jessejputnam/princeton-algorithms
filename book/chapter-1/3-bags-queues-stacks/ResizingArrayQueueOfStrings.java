import java.util.Arrays;

public class ResizingArrayQueueOfStrings {
    private String[] arr;
    private int size;
    private int head;
    private int tail;

    public ResizingArrayQueueOfStrings(int size) {
        this.arr = new String[size];
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }

    public boolean enqueue(String str) {
        if (isFull())
            resize(this.size * 2);

        if (!isEmpty())
            moveTail();

        this.size++;
        this.arr[this.tail] = str;
        return true;
    }

    public String dequeue() {
        if (isEmpty())
            return "";
        this.size--;
        String str = this.arr[this.head];
        this.arr[this.head] = null;
        moveHead();
        if (this.size > 0 && this.size == this.arr.length / 4)
            resize(this.arr.length / 2);
        return str;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public String toString() {

        return Arrays.toString(this.arr);
    }

    private boolean isFull() {
        return this.size >= this.arr.length;
    }

    private void moveTail() {
        if (this.tail == this.arr.length - 1)
            this.tail = 0;
        else
            this.tail++;
    }

    private void moveHead() {
        if (this.head == this.arr.length - 1)
            this.head = 0;
        else
            this.head++;
    }

    private void resize(int max) {
        System.out.println("-----");
        String[] newArr = new String[max];
        int limit = this.size;
        for (int i = 0; i < limit; i++) {
            newArr[i] = this.arr[getIdx(i)];
        }
        this.arr = newArr;
        this.size = limit;
        this.head = 0;
        this.tail = limit - 1;
    }

    private int getIdx(int i) {
        if (i + this.head > this.arr.length - 1)
            return i + this.head - this.size;
        return i + this.head;
    }
}
