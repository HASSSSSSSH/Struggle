package questions;

public class TTN07Day15 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        TTN07Day15 t = new TTN07Day15();
        t.ReverseList(n1);
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;


        ListNode targetNode = null;
        while (head.next != null) {
            ListNode previousNode = head;
            head = head.next;
            previousNode.next = targetNode;
            targetNode = previousNode;
            // nextNode = head.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
