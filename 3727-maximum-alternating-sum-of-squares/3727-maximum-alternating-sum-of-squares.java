class Solution 
{
    public long maxAlternatingSum(int[] nums) 
    {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            nums[i]=Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        int left=0,right=n-1;
        long res=0;
        while(left<right)
        {
            res+=(nums[right]*nums[right]-nums[left]*nums[left]);
            right--;
            left++;
        }
        if(left==right)res+=(nums[left]*nums[right]);
        return res;
    }
}