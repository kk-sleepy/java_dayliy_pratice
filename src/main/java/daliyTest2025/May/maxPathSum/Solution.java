package daliyTest2025.May.maxPathSum;

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
class Solution {
    private int ans;
    public int maxPathSum(TreeNode root) {
        ans = -1005;
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode node){
        if(node == null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        left = Math.max(0,left);
        right = Math.max(0,right);
        int cur = Math.max(left,right) + node.val;
        int maxLength = left + right + node.val;
        ans = Math.max(maxLength,ans);
        return cur;
    }
}
