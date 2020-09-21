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
