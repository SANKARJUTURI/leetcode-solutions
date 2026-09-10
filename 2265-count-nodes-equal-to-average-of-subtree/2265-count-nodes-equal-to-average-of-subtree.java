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
    int count;
    public int averageOfSubtree(TreeNode root) 
    {
        count=0;
        check(root);
        return count;
    }
    private int[] check(TreeNode node)
    {
        if(node==null)return new int[]{0,0};
        int[] left=check(node.left);
        int[] right=check(node.right);
        int total=left[1]+right[1]+1;
        int val=left[0]+right[0]+node.val;
        if(val/total==node.val)count++;
        return new int[]{val,total};
    }
}