package problems.leetcode;

/**
 * https://leetcode.cn/problems/design-linked-list/
 * 设计链表
 * <p>
 * 设计链表的实现
 * 您可以选择使用单链表或双链表
 * 单链表中的节点应该具有两个属性: val 和 next, val 是当前节点的值, next 是指向下一个节点的指针/引用
 * 如果要使用双向链表, 则还需要一个属性 prev 以指示链表中的上一个节点
 * 假设链表中的所有节点都是 0-index 的
 * <p>
 * 在链表类中实现这些功能:
 * <p>
 * get(index): 获取链表中第 index 个节点的值
 * 如果索引无效, 则返回 -1
 * <p>
 * addAtHead(val): 在链表的第一个元素之前添加一个值为 val 的节点
 * 插入后, 新节点将成为链表的第一个节点
 * <p>
 * addAtTail(val): 将值为 val 的节点追加到链表的最后一个元素
 * <p>
 * addAtIndex(index,val): 在链表中的第 index 个节点之前添加值为 val 的节点
 * 如果 index 等于链表的长度, 则该节点将附加到链表的末尾
 * 如果 index 大于链表长度, 则不会插入节点
 * 如果 index 小于 0, 则在头部插入节点
 * <p>
 * deleteAtIndex(index): 如果索引 index 有效, 则删除链表中的第 index 个节点
 * <p>
 * 提示:
 * 所有val值都在 [1, 1000] 之内
 * 操作次数将在  [1, 1000] 之内
 * 请不要使用内置的 LinkedList 库
 * <p>
 * Tags: {@link questions.tags.LinkedList}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#D}
 * <p>
 * 时间复杂度:
 * addAtHead, addAtTail: O(1)
 * get, addAtIndex, deleteAtIndex: O(k), 其中 k 指的是元素的索引
 * <p>
 * 空间复杂度: 所有的操作都是 O(1)
 */
public class Num707_Solution1 {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        // null
        myLinkedList.addAtIndex(1, 1);
        System.out.println(myLinkedList);

        // null
        myLinkedList.deleteAtIndex(2);
        System.out.println(myLinkedList);

        // 1
        myLinkedList.addAtHead(1);
        System.out.println(myLinkedList);

        // 0 -> 1
        myLinkedList.addAtHead(0);
        System.out.println(myLinkedList);

        // 1
        myLinkedList.deleteAtIndex(0);
        System.out.println(myLinkedList);

        // null
        myLinkedList.deleteAtIndex(0);
        System.out.println(myLinkedList);

        // 0
        myLinkedList.addAtTail(0);
        System.out.println(myLinkedList);

        // 0 -> 1
        myLinkedList.addAtTail(1);
        System.out.println(myLinkedList);

        // 0
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList);

        // null
        myLinkedList.deleteAtIndex(0);
        System.out.println(myLinkedList);

        // 0 -> 1 -> 2 -> 3
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(0);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtTail(3);
        System.out.println(myLinkedList);

        // 0 -> 0 -> 1 -> 2 -> 3
        myLinkedList.addAtIndex(0, 0);
        System.out.println(myLinkedList);

        // 0 -> 0 -> 1 -> 2 -> 3 -> 3
        myLinkedList.addAtIndex(5, 3);
        System.out.println(myLinkedList);

        // 0 -> 0 -> 1 -> 1 -> 2 -> 3 -> 3
        myLinkedList.addAtIndex(3, 1);
        System.out.println(myLinkedList);

        // 0
        System.out.println(myLinkedList.get(1));
    }

    private static class MyLinkedList {
        private Node head = null;
        private Node tail = null;
        private int length = 0;

        public MyLinkedList() {
        }

        public int get(int index) {
            if (length == 0 || index < 0 || index >= length) {
                return -1;
            }

            // 此时链表至少有一个节点, index >= 0
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.val;
        }

        public void addAtHead(int val) {
            Node node = new Node();
            node.val = val;
            if (head == null) {
                head = tail = node;
            } else {
                // 此时链表至少有一个节点, 而且要添加的节点不在尾部, 不用关心尾指针
                node.next = head;
                head = node;
            }
            length++;
        }

        public void addAtTail(int val) {
            Node node = new Node();
            node.val = val;
            if (tail == null) {
                head = tail = node;
            } else {
                // 此时链表至少有一个节点, 而且要添加的节点不在头部, 不用关心头指针
                tail.next = node;
                tail = node;
            }
            length++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > length) {
                return;
            }

            if (index == 0) {
                // 此时要添加的节点在头部
                addAtHead(val);
            } else if (index == length) {
                // 此时要添加的节点在尾部
                addAtTail(val);
            } else {
                // 此时要添加的节点不在头部或者尾部, 不用关心头指针和尾指针
                // 此时链表至少有三个节点, index >= 1
                Node cur = head.next;
                Node pre = head;
                for (int i = 1; i < index; i++) {
                    pre = cur;
                    cur = cur.next;
                }

                Node node = new Node();
                node.val = val;
                pre.next = node;
                node.next = cur;
                length++;
            }
        }

        public void deleteAtIndex(int index) {
            if (length == 0 || index < 0 || index >= length) {
                return;
            }

            if (index == 0) {
                // 此时要删除的节点在头部

                if (head == tail) {
                    // 此时链表只有一个节点, 要删除的节点也在尾部, 更新尾指针
                    tail = null;
                }
                head = head.next;
            } else {
                // 此时链表至少有两个节点, index >= 1
                Node pre = head;
                for (int i = 0; i < index - 1; i++) {
                    pre = pre.next;
                }
                Node del = pre.next;
                pre.next = pre.next.next;
                if (del == tail) {
                    // 此时尾节点是要被删除的节点, 令尾指针指向正确的节点
                    tail = pre;
                }
            }
            length--;
        }

        @Override
        public String toString() {
            return "MyLinkedList{\n" +
                    "head: \n" + head +
                    ((head == null) ? "\n" : "") +
                    "tail: \n" + tail +
                    ((tail == null) ? "\n" : "") +
                    "}";
        }
    }

    private static class Node {
        public int val;
        public Node next;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            Node head = this;
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
