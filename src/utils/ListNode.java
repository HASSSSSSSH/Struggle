package utils;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode head = this;
        ListNode cycleHead = detectCycle(head);

        if (cycleHead == null) {
            while (head != null) {
                builder.append("node-")
                        .append(head.hashCode())
                        .append(": ")
                        .append(head.val)
                        .append("\n");
                head = head.next;
            }
        } else {
            boolean inCycle = false;
            while (!inCycle || head != cycleHead) {
                if (head == cycleHead) {
                    inCycle = true;
                }
                builder.append("node-")
                        .append(head.hashCode())
                        .append(": ")
                        .append(head.val);
                if (inCycle) {
                    builder.append(" (in the cycle)");
                }
                builder.append("\n");
                head = head.next;
            }
        }

        return builder.toString();
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        ListNode temp = head;
        while (temp != slow) {
            temp = temp.next;
            slow = slow.next;
        }

        return slow;
    }
}
