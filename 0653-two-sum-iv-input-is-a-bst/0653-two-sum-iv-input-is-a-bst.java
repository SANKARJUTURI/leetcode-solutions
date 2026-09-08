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
class Solution 
{
    Set<Integer>S=new HashSet<>();
    public boolean findTarget(TreeNode root, int k) 
    {
        if(root==null)return false;
        if(S.contains(k-root.val))return true;
        S.add(root.val);
        boolean f=false;
        return findTarget(root.left,k) || findTarget(root.right,k);
    }
}