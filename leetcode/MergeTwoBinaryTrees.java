class Solution {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		TreeNode merged = null;
		boolean bt1 = false;
		boolean bt2 = false;
		
		if (t1 != null && t2 != null) {
			merged = new TreeNode(t1.val + t2.val);
			bt1 = bt2 = true;
		} else if (t1 != null && t2 == null) {
			merged = new TreeNode(t1.val);
			bt1 = true;
		} else if (t1 == null && t2 != null) {
			merged = new TreeNode(t2.val);
			bt2 = true;
		}

		if (bt1 && bt2) {
			merged.left = mergeTrees(t1.left, t2.left);
			merged.right = mergeTrees(t1.right, t2.right);
		} else if (bt1) {
			merged.left = mergeTrees(t1.left, null);
			merged.right = mergeTrees(t1.right, null);
		} else if (bt2) {
			merged.left = mergeTrees(null, t2.left);
			merged.right = mergeTrees(null, t2.right);
		}

		return merged;
	}
}
