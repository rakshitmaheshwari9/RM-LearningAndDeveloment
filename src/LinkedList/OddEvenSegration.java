package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class OddEvenSegration {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }


    public static ListNode oddEvenList(ListNode head) {


        List<Integer> listOdd = new ArrayList<>();
        List<Integer> listEven = new ArrayList<>();

        if (head == null) return head;

        ListNode temp = head;
        while (temp != null) {
            listOdd.add(temp.val);
            temp = temp.next;
            if (temp != null) {
                listEven.add(temp.val);
                temp = temp.next;
            }

        }
        int odd = 0;
        int even = 0;
        temp = head;
        while (temp != null && odd < listOdd.size()) {
            temp.val = listOdd.get(odd);
            odd++;
            temp = temp.next;

        }

        while (temp != null && even < listEven.size()) {
            temp.val = listEven.get(even);
            even++;
            temp = temp.next;

        }

        return head;


    }


    public static ListNode secondMethod(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) return head;

        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode oddTail = oddHead;
        ListNode evenTail = evenHead;
        ListNode current = oddTail.next;
        boolean isOdd = true;

        while (current != null) {
            if (isOdd) {
                oddTail.next = current;
                oddTail = current;
            } else {
                evenTail.next = current;
                evenTail = current;
            }

            current = current.next;
            isOdd = !isOdd;
        }


        oddTail.next = evenHead;
        evenTail.next = null;
        return oddHead;



    }
}
