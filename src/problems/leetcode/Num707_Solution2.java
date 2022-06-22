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
 * addAtHead: O(1)
 * get, addAtIndex, deleteAtIndex: O(k), 其中 k 指的是元素的索引
 * addAtTail: O(N), 其中 N 指的是链表的元素个数
 * <p>
 * 空间复杂度: 所有的操作都是 O(1)
 */
public class Num707_Solution2 {

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
        private Node dummyHead = null;
        private int size = 0;

        public MyLinkedList() {
            dummyHead = new Node();
        }

        public int get(int index) {
            if (size == 0 || index < 0 || index >= size) {
                return -1;
            }

            // 此时链表至少有一个节点, index >= 0
            Node temp = dummyHead;
            for (int i = 0; i <= index; i++) {
                temp = temp.next;
            }
            return temp.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }

            Node prev = dummyHead;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            Node temp = prev.next;
            Node newNode = new Node(val);
            prev.next = newNode;
            newNode.next = temp;
            ++size;
        }

        public void deleteAtIndex(int index) {
            if (size == 0 || index < 0 || index >= size) {
                return;
            }

            Node prev = dummyHead;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
            --size;
        }

        @Override
        public String toString() {
            return "MyLinkedList{\n" + "dummyHead: " + dummyHead + "}";
        }
    }

    private static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
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
                        .append("\n");
                head = head.next;
            }
            return builder.toString();
        }
    }
}
