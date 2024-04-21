package Heaps;

import java.util.PriorityQueue;

public class MergeKSortedList {


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (ListNode list : lists) {

                ListNode temp = list;

                while (temp != null) {

                    pq.add(temp.val);
                    temp = temp.next;
                }

            }


            ListNode head = new ListNode();
            ListNode temp = head;
            while (!pq.isEmpty()) {

                ListNode newNode = new ListNode(pq.poll());
                temp.next = newNode;
                temp = temp.next;

            }


            return head;
        }
    }
}
