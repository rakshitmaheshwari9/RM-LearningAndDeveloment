package StackAndQueue.Learning;

public class MinStack {
    Node head;

    public MinStack() {
        this.head = null;

    }

    public void push(int val) {

        if (head == null) {
            head = new Node(val, val);
        } else {
            Node newNode = new Node(val, Math.min(val, head.minValue));
            newNode.nextNode = head;
            head = newNode;
        }

    }

    public void pop() {
        if (head == null) return;
        head = head.nextNode;

    }

    public int top() {
        if (head != null) return head.value;
        else return -1;
    }

    public int getMin() {
        if (head != null) return head.minValue;
        else return -1;
    }
}
