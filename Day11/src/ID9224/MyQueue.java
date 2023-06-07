package ID9224;

public class MyQueue {
    private int capacity;
    private int queueArr[];
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;

    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[this.capacity];

    }

    public int[] getQueueArr() {
        return queueArr;
    }

    public boolean isQueueFull() {
        return currentSize == capacity;
    }

    public boolean isQueueEmpty() {
        return currentSize == 0;
    }

    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Stack Over Flow!");
        } else {
            if (isQueueEmpty()) {
                queueArr[head] = item;
            }
            tail++;
            queueArr[tail] = item;
            currentSize++;
        }
    }

    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow!");
        } else {
            for (int i = 0; i < currentSize; i++) {
                queueArr[i] = queueArr[i + 1];
            }
            tail--;
        }
        currentSize--;
    }
}
