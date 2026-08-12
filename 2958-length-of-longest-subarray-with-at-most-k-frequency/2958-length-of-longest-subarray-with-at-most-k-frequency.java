class Solution 
{
    public int maxSubarrayLength(int[] nums, int k) 
    {
        int n=nums.length;
        int left=0;
        Map<Integer,Integer>M=new HashMap<>();
        int res=0;
        for(int right=0;right<n;right++)
        {
            int f=M.getOrDefault(nums[right],0);
            if(f==k) 
            {
                while(nums[left]!=nums[right])
                {
                    M.put(nums[left],M.get(nums[left])-1);
                    left++;
                }
                M.put(nums[left],M.get(nums[left])-1);
                left++;
                f--;
            }
            M.put(nums[right],f+1);
            res=Math.max(res,right-left+1);
        }
        return res;
    }
}