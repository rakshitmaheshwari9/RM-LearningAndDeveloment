package StackAndQueue.implemetation;

public class ImplementStackUsingQueue {

    Queue qu;

    ImplementStackUsingQueue() {
        qu = new Queue();

    }

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");
    }

    public int pop() {

        int size = qu.size();
        for (int i = 1; i < size; i++) {
            qu.push(qu.pop());
        }
        return qu.pop();
    }

    public void push(int element) {
        qu.push(element);
    }

    public int size() {
        return qu.size();
    }

    public int top() {
        int size = qu.size();
        for (int i = 1; i < size; i++) {
            qu.push(qu.pop());
        }
        int element = qu.top();
        qu.push(qu.pop());
        return element;
    }
}
