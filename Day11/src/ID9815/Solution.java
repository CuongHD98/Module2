package ID9815;

public class Solution {

    private Queue queue;

    public Solution(Queue queue) {
        this.queue = queue;
    }

    public void enQueue(int data) {
        Node node = new Node(data);
        if (queue.rear == null) {
            queue.front = queue.rear = node;
            return;
        }
        queue.rear.link = node;
        queue.rear = node;
    }

    public void deQueue() {
        if (queue.front == null) return;
        queue.front = queue.front.link;
        if (queue.front == null) queue.rear = null;
    }

    public void displayQueue() {
        Node temp = queue.front;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.link;
        }
    }

}
