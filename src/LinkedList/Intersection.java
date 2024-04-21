package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Intersection {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> st = new HashSet<>();

        ListNode temp = headA;
        while (temp != null) {
            st.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            if (st.contains(temp)) return temp;
            temp = temp.next;
        }


        return null;
    }

    public ListNode getIntersectionSecondExample(ListNode headA, ListNode headB) {

        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while (temp1 != temp2) {
            if (temp1 == null) {
                temp1 = headB;
            } else {
                temp1 = temp1.next;
            }

            if (temp2 == null) {
                temp2 = headA;
            } else {
                temp2 = temp2.next;
            }
        }


        return temp1;
    }
}
