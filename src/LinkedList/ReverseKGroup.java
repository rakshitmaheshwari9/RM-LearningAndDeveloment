package LinkedList;


public class ReverseKGroup {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode nextNode = curr.next;

            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {


        int t = k;

        ListNode temp = head;

        while (temp != null && t > 0) {
            temp = temp.next;
            t--;
        }

        ListNode secondNode = reverseKGroup(temp.next, k);
        temp.next = null;
        ListNode reversedNode = reverseList(head);
        ListNode secondTemp = reversedNode;
        while (secondTemp.next != null) {
            secondTemp = secondNode.next;
        }
        secondTemp.next=reversedNode;
        return reversedNode;
    }
}
