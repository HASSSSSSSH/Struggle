package questions;

public class TTN07Day15_2 {

    public static void main(String[] args) {
    }

    public TTN07Day15.ListNode Merge(TTN07Day15.ListNode list1, TTN07Day15.ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        TTN07Day15.ListNode head = null;
        TTN07Day15.ListNode currentNode = null;
        TTN07Day15.ListNode listNodeA = list1;
        TTN07Day15.ListNode listNodeB = list2;
        while (listNodeA != null || listNodeB != null) {
            if (listNodeA == null) {
                currentNode.next = listNodeB;
                break;
            }
            if (listNodeB == null) {
                currentNode.next = listNodeA;
                break;
            }

            if (listNodeA.val <= listNodeB.val) {
                if (head == null) {
                    head = listNodeA;
                    currentNode = head;
                    listNodeA = listNodeA.next;
                    continue;
                }
                currentNode.next = listNodeA;
                currentNode = currentNode.next;
                listNodeA = listNodeA.next;
            } else {
                if (head == null) {
                    head = listNodeB;
                    currentNode = head;
                    listNodeB = listNodeB.next;
                    continue;
                }
                currentNode.next = listNodeB;
                currentNode = currentNode.next;
                listNodeB = listNodeB.next;
            }
        }
        return head;
    }
}
