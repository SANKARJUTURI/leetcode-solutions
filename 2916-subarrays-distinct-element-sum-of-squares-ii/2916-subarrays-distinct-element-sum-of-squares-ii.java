class Pair{
    long one;
    long two;
    Pair(long a,long b){
        one = a;
        two = b;
    }
}
class SegmentTree{
    Pair[] tree;
    long[] lazy;
    int n;
    long M = (long)1e9+ 7;
    SegmentTree(int n){
        this.n=n;
        tree = new Pair[4*n];
        lazy = new long[4*n];
        for(int i=0;i<4*n;i++) tree[i] = new Pair(0,0);
        //Arrays.fill(tree,new Pair(0,0));
    }
    
    long mul(long a, long b) {
        return (a*b)%M;
    }
    
    long add(long a,long b){
        return (a+b) % M;
    }
    private Pair merge(Pair l,Pair r){
        long one = (l.one + r.one)%M;
        long two = (l.two + r.two)%M;
        return new Pair(one,two);
    }
    
    public void update(int l,int r,long val){
        update(0,0,n-1,l,r,val);
    }
    public long query(int l,int r){
        Pair p = query(0,0,n-1,l,r);
        return p.two;
    }
    private void push(int idx,int l,int r){
        if(lazy[idx]!=0){
            int len = r-l+1;
            long a = lazy[idx];
            long s = a < 0 ? -1 : 1;
            a = Math.abs(a);
            long two = mul(len,a);
            two = add(two , mul(2,s*tree[idx].one)); 
            two = mul(two,a);

            long one = mul(len,s*a);

            tree[idx].one = add(tree[idx].one , one);
            tree[idx].two = add(tree[idx].two , two);
            if(l!=r){
                lazy[2*idx+1] = add(lazy[2*idx+1] , s*a);
                lazy[2*idx+2] = add(lazy[2*idx+2] , s*a);
            }
            lazy[idx] = 0;
        }
    }
    private void update(int idx,int l,int r,int p,int q,long val){
        push(idx,l,r);
        if(q<l || r<p) return;
        else if(p<=l && r<=q){
            lazy[idx] += val;
            push(idx,l,r);
            return;
        }
        
        int mid = l + (r-l)/2;
        update(2*idx+1,l,mid,p,q,val);
        update(2*idx+2,mid+1,r,p,q,val);
        tree[idx] = merge(tree[2*idx+1],tree[2*idx+2]);
    }
    
    private Pair query(int idx,int l,int r,int p,int q){
        push(idx,l,r);
        if(q<l || r<p) return new Pair(0,0);
        else if(p<=l && r<=q){
            return tree[idx];
        }
        
        int mid = l + (r-l)/2;
        return merge(query(2*idx+1,l,mid,p,q),query(2*idx+2,mid+1,r,p,q));
    }
}
class Solution {
    public int sumCounts(int[] nums) {
        int n = nums.length;
        int MAXN = (int)1e5;
        int[] last = new int[MAXN + 1];
        Arrays.fill(last,-1);
        long ans = 0;
        long M = (long)1e9+ 7;
        SegmentTree sg = new SegmentTree(n);
        for(int i=0;i<n;i++){
            int val = nums[i];
            int p = last[val];
            sg.update(0,p,-1);
            sg.update(0,i,1);
            ans = (ans + sg.query(0,i)) % M;
        
            last[val] = i;
        }
        return (int)ans;
    }
}