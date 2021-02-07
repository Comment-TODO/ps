/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.*;

class L104 {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> que = new ArrayDeque<>();
        int level = 0;
        
        if (root == null) return level;
        que.offer(root);
        
        while (!que.isEmpty()) {
            int currLevelSize = que.size();
            level++;
            
            while (currLevelSize-- > 0) {
                TreeNode node = que.poll();

                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
        }
        
        return level;
    }
}
