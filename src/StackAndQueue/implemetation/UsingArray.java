package StackAndQueue.implemetation;

public class UsingArray {

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");


//        stack exapmle completed Rahul khichar
//        Stack stack = new Stack();
//        System.out.println(stack.size());
//        stack.push(23);
//        stack.push(43);
//        stack.push(78);
//        System.out.println(stack.size());
//
//        System.out.println(stack.pop());
//        System.out.println(stack.size());
//        System.out.println(stack.pop());


//here we are done with Queue Rahul Khichar

//        Queue queue = new Queue();
//        System.out.println(queue.size());
//        queue.push(23);
//        queue.push(43);
//        queue.push(78);
//        System.out.println(queue.size());
//
//        System.out.println(queue.pop());
//        System.out.println(queue.size());
//        System.out.println(queue.pop());
//        System.out.println(queue.top());
        ImplementStackUsingQueue s = new ImplementStackUsingQueue();
        s.push(3);
        s.push(2);
        s.push(4);
        s.push(1);
        System.out.println("Top of the stack: " + s.top());
        System.out.println("Size of the stack before removing element: " + s.size());
        System.out.println("The deleted element is: " + s.pop());
        System.out.println("Top of the stack after removing element: " + s.top());
        System.out.println("Size of the stack after removing element: " + s.size());

    }

//    public []int stackSize() {
//
//    }

}
