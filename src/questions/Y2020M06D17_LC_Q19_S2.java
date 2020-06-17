package questions;

public class Y2020M06D17_LC_Q19_S2 {

    public static void main(String args[]) {
        Y2020M06D17_LC_Q19_S2 instance = new Y2020M06D17_LC_Q19_S2();
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        System.out.println(instance.removeNthFromEnd(head, 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        int count = 1;
        while (p2.next != null) {
            p2 = p2.next;
            count++;
            if (count > n + 1) {
                p1 = p1.next;
            }
        }
        if (n >= count) {
            head = head.next;
            p1.next = null;
        } else {
            p1.next = p1.next.next;
        }
        return head;
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
