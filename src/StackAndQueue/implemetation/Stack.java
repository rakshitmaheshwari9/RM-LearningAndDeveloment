package StackAndQueue.implemetation;

public class Stack {
    int[] arr;
    int index;

    Stack() {
        arr = new int[5];
        index = -1;
    }

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");
    }

    public void copyElementAndIncreaseSize() {
        int[] newArray = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        arr = newArray;
    }

    public void push(int element) {
        if (index >= arr.length) {
            copyElementAndIncreaseSize();
        }
        index++;
        arr[index] = element;
    }

    public int size() {
        return index + 1;
    }

    public int pop() {
        if (index < 0) {
            return -1;
        }
        int element = arr[index];
        index--;
        return element;
    }

    public int top() {
        if (index < 0) {
            return -1;
        }
        int element = arr[index];
        return element;
    }
}
