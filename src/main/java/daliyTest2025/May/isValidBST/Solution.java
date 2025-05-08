package daliyTest2025.May.isValidBST;


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
    private long minValue = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        TreeNode left = root.left, right = root.right;
        if(!isValidBST(left) || root.val <= minValue)
            return false;
        minValue = root.val;
        return isValidBST(right);
    }
}
