package questions;

/**
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class Y2020M06D19_LCOF_Q35_S1 {

    public static void main(String args[]) {
        Y2020M06D19_LCOF_Q35_S1 instance = new Y2020M06D19_LCOF_Q35_S1();
        Node head = new Node(1);
        Node temp = head;
        for (int i = 2; i <= 2; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }
        System.out.println(instance.copyRandomList(head));
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp != null) {
            Node copy = new Node(temp.val);
            Node next = temp.next;
            temp.next = copy;
            copy.next = next;
            temp = copy.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            } else {
                temp.next.random = null;
            }
            temp = temp.next.next;
        }
        temp = head;
        Node header = temp.next;
        while (temp != null) {
            Node next = temp.next;
            temp.next = next == null ? null : next.next;
            temp = next;
        }
        return header;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            Node head = this;
            while (head != null) {
                builder.append("node-")
                        .append(head.hashCode())
                        .append(": ")
                        .append(head.val)
                        .append(" \n");
                head = head.next;
            }
            return builder.toString();
        }
    }
}
