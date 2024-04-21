package StackAndQueue.implemetation;

public class Queue {


    int[] arr;
    int index;
    int lastIndex;

    Queue() {
        arr = new int[1000];
        index = -1;
        lastIndex = -1;


    }

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public void push(int element) {
        lastIndex++;
        arr[lastIndex] = element;
    }

    public int size() {
        return (lastIndex - index);

    }

    public int pop() {
        index++;
        return arr[index];
    }

    public int top() {
//
//        if (index < 0) return -1;
//        else {
        int element = arr[index + 1];
        return element;
//        }
    }


}
