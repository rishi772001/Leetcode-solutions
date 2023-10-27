package com.rishi.Hard;

import com.rishi.util.TreeNode;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {

    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(-10);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
    }
}
