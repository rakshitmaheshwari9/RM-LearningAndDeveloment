package StackAndQueue.Learning;

public class Node {
    int minValue;
    int value;
    Node nextNode = null;

    Node(int value, int minValue) {
        this.value = value;
        this.minValue = minValue;
    }
}
