package daliyTest2025.May.mergeKLists;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)->{
            return a.val - b.val;
        });
        for(ListNode head : lists){
            ListNode cur = head;
            while(cur != null){
                ListNode nxt = cur.next;
                cur.next = null;
                heap.offer(cur);
                cur = nxt;
            }
        }
        ListNode dumpy = new ListNode();
        ListNode cur = dumpy;
        while(!heap.isEmpty()){
            cur.next = heap.poll();
            cur = cur.next;
        }
        return dumpy.next;
    }
}
