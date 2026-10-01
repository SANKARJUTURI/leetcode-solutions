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
    public int minDiffInBST(TreeNode root) 
    {
        List<Integer>L=new ArrayList<>();
        inOrder(root,L);
        int ans=L.get(1)-L.get(0);
        for(int i=2;i<L.size();i++)
        {
            ans=Math.min(ans,L.get(i)-L.get(i-1));
        }
        return ans;
    }
    private void inOrder(TreeNode root,List<Integer>L)
    {
        if(root.left!=null)inOrder(root.left,L);
        L.add(root.val);
        if(root.right!=null)inOrder(root.right,L);
    }
}