package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class OddEvenList {


    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> arrayList = new ArrayList<>();


        ListNode temp = head;
        while (temp != null) {
            arrayList.add(temp.val);
            temp = temp.next;
        }

        temp = head;

        for (int number : arrayList) {
            if (number % 2 != 0) {
                temp.val = number;
                temp = temp.next;
            }
        }
        for (int number : arrayList) {
            if (number % 2 == 0) {
                temp.val = number;
                temp = temp.next;
            }
        }
        return head;
    }
}
