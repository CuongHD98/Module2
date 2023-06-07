package ID9225;

public class MyStack {
    private int arr[];
    private int size;
    private int index = 0;

    public MyStack(int size) {
        arr = new int[size];
    }

    public int[] getArr() {
        return arr;
    }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int element){
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        arr[index] = element;
        index++;
        size++;
    }

    public int pop() throws Exception {
        int last = -1;
        if (isEmpty()) {
            throw new Exception("Stack is null");
        } else {
            size--;
            last = index;
            index--;
        }
        return arr[last];
    }
}
