package LinkedList.doublylinkedlist;

public class DeleteAllOccurrences {

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");
    }

    public static Node deleteAllOccurrences(Node head, int k) {


        if (head == null) {
            return head;
        }


        Node temp = head;
        while (temp != null) {

            if (temp.data == k) {
                Node prevNode = temp.prev;
                if (prevNode == null) {
                    if (temp.next == null) return null;
                    temp.data = temp.next.data;
                    temp.next = temp.next.next;
                } else {
                    prevNode.next = temp.next;
                }
            }
            temp = temp.next;
        }

        return head;
        // Write your code here.
    }
}
