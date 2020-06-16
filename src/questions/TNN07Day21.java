package questions;

import java.util.ArrayList;

public class TNN07Day21 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null)
            return list;
        getTo(list, listNode);
        return list;
    }

    public void getTo(ArrayList<Integer> list, ListNode listNode) {
        if (listNode == null || list == null)
            return;

        getTo(list, listNode.next);
        list.add(listNode.val);
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
