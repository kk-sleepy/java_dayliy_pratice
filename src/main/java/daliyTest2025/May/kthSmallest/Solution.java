package daliyTest2025.May.kthSmallest;

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
}

public class Solution {
    private int cnt;
    private int ans;
    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode node){
        if(node== null || cnt <= 0)
            return;
        dfs(node.left);
        cnt -= 1;
        if(cnt == 0){
            ans = node.val;
            return;
        }
        dfs(node.right);
    }
}
