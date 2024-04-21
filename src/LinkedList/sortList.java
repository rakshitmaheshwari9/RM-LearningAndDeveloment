package LinkedList;

import static LinkedList.IsPalindrome.insertNode;

public class sortList {


    public static void main(String[] args) {
        System.out.println("Rahul Khichar");
        System.out.println("");

        ListNode head = null;
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 3);
        head = insertNode(head, 2);
        head = insertNode(head, 1);
        printList(head);
//        head = sortList(head);
        head=mergeSort(head);
        printList(head);
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val + " ");
            temp = temp.next;
        }
    }

    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode iteration = head;
        while (iteration != null) {
            ListNode temp = head;
            while (temp != null && temp.next != null) {
                if (temp.val > temp.next.val) {
                    int t = temp.val;
                    temp.val = temp.next.val;
                    temp.next.val = t;
                }
                temp = temp.next;
            }

            iteration = iteration.next;
        }

        return head;
    }

    public static ListNode mergeSortedList(ListNode first, ListNode second) {
        if (first == null) return second;

        if (second == null) return first;


        if (first.val < second.val) {
            first.next = mergeSortedList(first.next, second);
            return first;
        } else {
            second.next = mergeSortedList(first, second.next);
            return second;
        }
    }

    public static ListNode mergeSort(ListNode head) {

        if (head == null || head.next == null) return head;


        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondSortedList = mergeSort(slow.next);
        slow.next = null;
        ListNode firstSortedList = mergeSort(head);

        return mergeSortedList(firstSortedList, secondSortedList);

    }
}
