package daliyTest2025.May.buildTree;

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
}

class Solution {
    private Map<Integer, Queue<Integer>> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) {
            return null;
        }

        // 构建中序遍历值到索引的映射（支持重复值）
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.putIfAbsent(inorder[i], new LinkedList<>());
            inorderIndexMap.get(inorder[i]).offer(i);
        }

        // 调用递归函数构建树
        return build(preorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // 前序遍历的第一个节点是当前子树的根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // 找到根节点在中序遍历中的位置
        int rootIndex = inorderIndexMap.get(rootVal).poll();

        // 计算左子树的节点数量
        int leftSize = rootIndex - inStart;

        // 递归构建左子树和右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize, inStart, rootIndex - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, rootIndex + 1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] preorder = new int[]{3, 1, 2, 4, 2};
        int[] inorder = new int[]{1, 2, 3, 2, 4};
        TreeNode root = s.buildTree(preorder, inorder);
        System.out.println("Tree built successfully.");
    }
}