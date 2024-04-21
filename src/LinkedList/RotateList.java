package LinkedList;

public class RotateList {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public ListNode rotateRight(ListNode head, int k) {
        int sizeOfList = 0;
        ListNode temp = head;
        while (temp != null) {
            sizeOfList++;
            temp = temp.next;
        }

        int firstListSize = sizeOfList - k;
        if(firstListSize<0) {
            firstListSize+=sizeOfList;
        }

        temp = head;
        while (firstListSize > 1) {
            firstListSize--;
            temp = temp.next;
        }
        ListNode secondList = temp.next;
        temp.next = null;
        temp = secondList;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;

        return secondList;
    }
}
