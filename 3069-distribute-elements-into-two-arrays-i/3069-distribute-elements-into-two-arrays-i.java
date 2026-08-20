class Solution 
{
    public int[] resultArray(int[] nums) 
    {
        int n=nums.length;
        if(n<=2)return nums;
        int[] arr1=new int[n];
        int[] arr2=new int[n];
        arr1[0]=nums[0];
        arr2[0]=nums[1];
        int a=0,b=0;
        for(int i=2;i<n;i++)
        {
            if(arr1[a]>arr2[b])
            {
                a++;
                arr1[a]=nums[i];
            }
            else
            {
                b++;
                arr2[b]=nums[i];
            }
        }
        int k=0;
        for(int i:arr1)
        {
            if(i==0)break;
            nums[k++]=i;
        }
        for(int i:arr2)
        {
            if(i==0)break;
            nums[k++]=i;
        }
        return nums;
    }
}