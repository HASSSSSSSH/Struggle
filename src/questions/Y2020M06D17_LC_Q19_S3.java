package questions;

public class Y2020M06D17_LC_Q19_S3 {

    public static void main(String args[]) {
        Y2020M06D17_LC_Q19_S3 instance = new Y2020M06D17_LC_Q19_S3();
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        System.out.println(instance.removeNthFromEnd(head, 5));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode header = new ListNode(0);
        header.next = head;
        ListNode p1 = header;
        ListNode p2 = header;
        while (n != 0 && p2.next != null) {
            p2 = p2.next;
            n--;
        }
        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        p1.next = p1.next.next;
        return header.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            ListNode head = this;
            while (head != null) {
                builder.append("node-")
                        .append(head.hashCode())
                        .append(": ")
                        .append(head.val)
                        .append("\n");
                head = head.next;
            }
            return builder.toString();
        }
    }
}
