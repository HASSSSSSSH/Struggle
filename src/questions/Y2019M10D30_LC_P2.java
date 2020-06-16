package questions;

public class Y2019M10D30_LC_P2 {

    public static void main(String[] args) {
        Y2019M10D30_LC_P2 y = new Y2019M10D30_LC_P2();

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        y.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode result = l1;
        ListNode head1 = new ListNode(0);
        head1.next = l1;
        ListNode head2 = new ListNode(0);
        head2.next = l2;
        ListNode nextNode1 = head1;
        ListNode nextNode2 = head2;
        boolean carry = false;
        do {
            ListNode temp = null;
            if (nextNode1.next == null) {
                result = l2;
                // nonnull
                temp = nextNode2.next;
                nextNode2 = nextNode2.next;
            } else if (nextNode2.next == null) {
                result = l1;
                // nonnull
                temp = nextNode1.next;
                nextNode1 = nextNode1.next;
            }
            if (temp != null) {
                if (!carry) {
                    break;
                }
                int sum = temp.val + 1;
                if (sum / 10 == 1) {
                    temp.val = sum % 10;
                    carry = true;
                    continue;
                } else {
                    temp.val = sum;
                    carry = false;
                    break;
                }
            }

            // nonnull
            nextNode1 = nextNode1.next;
            nextNode2 = nextNode2.next;
            int sum = carry ? nextNode1.val + nextNode2.val + 1 : nextNode1.val + nextNode2.val;
            if (sum / 10 == 1) {
                nextNode1.val = sum % 10;
                nextNode2.val = sum % 10;
                carry = true;
            } else {
                nextNode1.val = sum;
                nextNode2.val = sum;
                carry = false;
            }
        } while (nextNode1.next != null || nextNode2.next != null);

        if (carry) {
            if (result == l1) {
                nextNode1.next = new ListNode(1);
            } else {
                nextNode2.next = new ListNode(1);
            }
        }

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
