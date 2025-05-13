package daliyTest2025.May.rightSideView;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root == null)
            return new ArrayList<>();
        queue.add(root);
        Queue<TreeNode> nxt = new ArrayDeque<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null)
                nxt.add(node.left);
            if(node.right != null)
                nxt.add(node.right);
            if(queue.isEmpty()){
                ans.add(node.val);
                queue = nxt;
                nxt = new ArrayDeque<>();
            }
        }
        return ans;
    }
}
public class Solution {
}
