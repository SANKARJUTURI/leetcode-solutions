
class Solution {
    private boolean sorted(int[] arr){
        int n = arr.length;

        for(int i=0;i<n-1;i++){
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
    }
    private boolean check(int[] nums,int n,int k){
        if(k==1) return sorted(nums);
        int[] large = new int[n/k];
        int[] small = new int[n/k];
        Arrays.fill(small,Integer.MAX_VALUE);
        boolean bp = false;
        for(int i=0;i<n;i++){
            if(i%k==0) bp = false;

            large[i/k] = Math.max(large[i/k],nums[i]);
            small[i/k] = Math.min(small[i/k],nums[i]);
            if(( i+1 < n && nums[i] > nums[i+1]) || ((i+1)%k==0 && nums[i] > nums[i-k+1])){
                if(bp) return false;
                bp = true;
            }
        }
        if(!sorted(large) || !sorted(small)) return false;
        
        for(int i=0;i<n/k - 1;i++){
            if(large[i] > small[i+1]) return false;
        }
        return true;
    }
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans=0;
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                boolean is = check(nums,n,i);
                if(is) ans += i;
                if(n/i != i) {
                    is = check(nums,n,n/i);
                    if(is) ans += n/i;
                }
            }
        }
        return ans;
    }
}