package com.rishi.Hard;

import com.rishi.util.TreeNode;

public class MaxPathSum {
	int MAXI = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		maxPathSumHelper(root);
		return MAXI;
	}

	public int maxPathSumHelper(TreeNode root) {
		if(root.left == null && root.right == null)
		{
			MAXI = Math.max(MAXI, root.val);
			return root.val;
		}

		if(root.left == null || root.right == null)
		{
			int sum = root.left != null ? maxPathSumHelper(root.left) : maxPathSumHelper(root.right);
			int sumWithRoot = Math.max(root.val, sum + root.val);
			MAXI = Math.max(MAXI, Math.max(sumWithRoot, sum));
			return sumWithRoot;
		}

		int leftSum = maxPathSumHelper(root.left);
		int rightSum = maxPathSumHelper(root.right);

		int sumWithRoot = Math.max(Math.max(leftSum + root.val, rightSum + root.val), root.val);

		MAXI = Math.max(Math.max(Math.max(Math.max(sumWithRoot, leftSum), rightSum), MAXI), leftSum + root.val + rightSum);
		return sumWithRoot;
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);

		System.out.println(new MaxPathSum().maxPathSum(root));
	}
}
