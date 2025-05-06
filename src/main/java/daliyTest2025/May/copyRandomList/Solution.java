package daliyTest2025.May.copyRandomList;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Solution {
    public Node copyRandomList(Node head){
        Node dumpy = new Node(0);
        Map<Node,Node> cnt = new HashMap<>();
        dumpy.next = head;
        Node p0 = dumpy;
        Node cur = head;
        while(cur != null){
            Node newNode = new Node(cur.val);
            p0.next = newNode;
            newNode.random = null;
            p0 = p0.next;
            cnt.put(cur,newNode);
            cur = cur.next;
        }
        cur = head;
        p0 = dumpy.next;
        while(cur != null){
            if(cur.random != null){
                p0.random = cnt.get(cur.random);
            }else{
                p0.random = null;
            }
            cur = cur.next;
            p0 = p0.next;
        }
        return dumpy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
