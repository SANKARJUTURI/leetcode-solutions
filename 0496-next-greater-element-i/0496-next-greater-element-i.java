class Solution 
{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        int n=nums1.length;
        int[] arr=new int[n];
        int m=nums2.length;
        for(int i=0;i<n;i++)
        {
            int res=-1;
            int target=nums1[i];
            int j=0;
            for(j=0;j<m;j++)
            {
                if(nums2[j]==target)break;
            }
            for(int k=j+1;k<m;k++)
            {
                if(nums2[k]>target)
                {
                    res=nums2[k];
                    break;
                }
            }
            arr[i]=res;
        }
        return arr;
    }
}