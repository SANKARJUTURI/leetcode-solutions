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
    int res;
    public int maxAncestorDiff(TreeNode root) 
    {
        res=-1;
        MD(root.left,root.val,root.val);
        MD(root.right,root.val,root.val);
        return res;
    }
    private void MD(TreeNode root,int min,int max)
    {
        if(root==null)return;
        int r=root.val;
        res=Math.max(res,Math.max(Math.abs(r-min),Math.abs(r-max)));
        if(root.left!=null)MD(root.left,Math.min(min,r),Math.max(max,r));
        if(root.right!=null)MD(root.right,Math.min(min,r),Math.max(max,r));
    }
}