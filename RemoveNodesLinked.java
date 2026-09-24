import java.util.Stack;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class RemoveNodesLinked {

    public Node removeNodes(Node head) {

        Stack<Node> st = new Stack<>();

        Node temp = head;

        // Put all nodes into stack
        while (temp != null) {
            st.push(temp);
            temp = temp.next;
        }

        Node maxNode = null;

        // Process from right to left
        while (!st.isEmpty()) {

            Node current = st.pop();

            if (maxNode == null || current.val >= maxNode.val) {

                current.next = maxNode;
                maxNode = current;
            }
        }

        return maxNode;
    }

    public static void print(Node head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(5);

        head.next = new Node(2);
        head.next.next = new Node(13);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(8);

        RemoveNodesLinked obj = new RemoveNodesLinked();

        System.out.println("Original:");
        print(head);

        head = obj.removeNodes(head);

        System.out.println("After removing:");
        print(head);
    }
}