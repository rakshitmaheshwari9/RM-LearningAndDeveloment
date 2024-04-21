package LinkedList;

public class CopyRandomNode {

    public static void main(String[] args) {
        Node head = null;

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        head = node1;
        head.next = node2;
        head.next.next = node3;
        head.next.next.next = node4;

        head.random = node4;
        head.next.random = node1;
        head.next.next.random = null;
        head.next.next.next.random = node2;

        System.out.println("Original list:(current node:node pointed by next pointer,node pointed by random pointer)");
        printList(head);

        System.out.println("Copy list:(current node:node pointed by next pointer,node pointed by random pointer)");
        Node newHead = copyRandomList(head);
        printList(newHead);
        System.out.println("Rahul khichar");
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head + "address");
            System.out.print(head.val + ":");
            if (head.next != null)
                System.out.print(head.next.val);
            else
                System.out.print("NULL");
            if (head.random != null)
                System.out.print("," + head.random.val);
            else
                System.out.print(",NULL");
            System.out.println();
            head = head.next;
        }
    }

    public static Node copyRandomList(Node head) {

        if (head == null) return head;
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        temp = head;

        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }


        temp = head.next;
        while (temp != null && temp.next != null) {
            temp.next = temp.next.next;
            temp = temp.next;
        }

        return head.next;
    }
}
