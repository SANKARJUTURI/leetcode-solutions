class Solution {
    int n;
    char[] arr;
    Set<String> ans;
    List<String> sol;
    private void solve(int idx,String st,int cnt){
        if(idx==n){
            if(cnt==0) ans.add(st);
            return;
        }

        if(arr[idx]!='(' && arr[idx]!=')') {
            solve(idx+1,st+arr[idx],cnt);
        }else{
            
            if(cnt + (arr[idx]=='(' ? 1 : -1) >=0) 
                solve(idx+1,st+arr[idx],cnt + (arr[idx]=='(' ? 1 : -1));
            solve(idx+1,st,cnt);
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        ans = new HashSet<>();
        sol = new ArrayList<>();
        arr = s.toCharArray();
        n = arr.length;
        solve(0,"",0);
        int curr=0;
        for(String c : ans){
            if(c.length() == curr) sol.add(c);
            else if(c.length() > curr){
                sol = new ArrayList<>();
                sol.add(c);
                curr = c.length();
            }
        }
        if(sol.isEmpty()) sol.add("");
        return sol;
    }
}