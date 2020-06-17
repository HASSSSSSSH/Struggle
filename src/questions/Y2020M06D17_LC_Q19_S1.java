package questions;

public class Y2020M06D17_LC_Q19_S1 {

    public static void main(String args[]) {
        Y2020M06D17_LC_Q19_S1 instance = new Y2020M06D17_LC_Q19_S1();
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        System.out.println(instance.removeNthFromEnd(head, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode[] nodes = new ListNode[n + 1];
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            nodes[count % (n + 1)] = temp;
            count++;
            temp = temp.next;
        }
        if (count == n) {
            temp = head.next;
            head.next = null;
            head = temp;
        } else if (n == 1) {
            nodes[(count - n - 1) % (n + 1)].next = null;
        } else {
            nodes[(count - n - 1) % (n + 1)].next = nodes[(count - n + 1) % (n + 1)];
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
