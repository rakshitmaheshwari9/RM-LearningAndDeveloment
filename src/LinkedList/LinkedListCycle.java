package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle {


    public static ListNode detectCycle(ListNode head) {
        if (head == null) return head;

        Map<ListNode, Boolean> mp = new HashMap<>();

        ListNode iterator = head;
        while (iterator != null) {
            if (mp.containsKey(iterator)) return iterator;
            mp.put(iterator, true);
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");
    }
}
