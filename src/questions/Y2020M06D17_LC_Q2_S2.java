package questions;

public class Y2020M06D17_LC_Q2_S2 {

    public static void main(String args[]) {
        Y2020M06D17_LC_Q2_S2 instance = new Y2020M06D17_LC_Q2_S2();

//        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);

        System.out.println(instance.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int sum;
        int carry = 0;
        while (l1 != null || l2 != null) {
            sum = 0;
            sum += carry;
            sum += l1 != null ? l1.val : 0;
            sum += l2 != null ? l2.val : 0;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // Be careful!!! carry may be TURE but l1 and l2 is null
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return head.next;
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
