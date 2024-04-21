package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {

    public static ListNode reverseList(ListNode head) {
        if (head == null && head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static boolean isPalindromeSecondMethod(ListNode head) {

        if (head == null || head.next == null) return true;


        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverseList(slow.next);
        slow = slow.next;
        ListNode dummy = head;
        while (slow != null) {
            if (slow.val != dummy.val) return false;
            slow = slow.next;
            dummy = dummy.next;

        }

        return true;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int n = list.size();
        for (int i = 0; i <= n / 2; i++) {
            if (list.get(i) != list.get(n - i - 1)) return false;
        }

        return true;
    }

    static ListNode insertNode(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return head;
        }

        ListNode temp = head;
        while (temp.next != null) temp = temp.next;

        temp.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = null;
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 3);
        head = insertNode(head, 2);
        head = insertNode(head, 1);
        if (isPalindromeSecondMethod(head) == true)
            System.out.println("True");
        else
            System.out.println("False");
        System.out.println("Rahul khichar");
    }
}
