package questions;

public class Y2020M06D17_LC_Q2_S1 {

    public static void main(String args[]) {
        Y2020M06D17_LC_Q2_S1 instance = new Y2020M06D17_LC_Q2_S1();

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
        boolean carry = false;
        while (l1 != null && l2 != null) {
            sum = carry ? l1.val + l2.val + 1 : l1.val + l2.val;
            if (sum / 10 > 0) {
                carry = true;
            } else {
                carry = false;
            }
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        // Be careful!!! carry may be TURE but l1 and l2 is null
        if (l1 != null) {
            if (!carry) {
                temp.next = l1;
            } else {
                while (true) {
                    sum = l1 != null ? 1 + l1.val : 1;
                    temp.next = new ListNode(sum % 10);
                    temp = temp.next;
                    if (l1 != null) {
                        l1 = l1.next;
                    }
                    if (sum / 10 <= 0) {
                        temp.next = l1;
                        break;
                    }
                }
            }
        } else if (l2 != null) {
            if (!carry) {
                temp.next = l2;
            } else {
                while (true) {
                    sum = l2 != null ? 1 + l2.val : 1;
                    temp.next = new ListNode(sum % 10);
                    temp = temp.next;
                    if (l2 != null) {
                        l2 = l2.next;
                    }
                    if (sum / 10 <= 0) {
                        temp.next = l2;
                        break;
                    }
                }
            }
        } else if (carry) {
            // Be careful!!! carry may be TURE but l1 and l2 is null
            temp.next = new ListNode(1);
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
