class Solution 
{
    public int findCenter(int[][] edges) 
    {
        int n=edges.length;
        int[] F=new int[n+1];
        for(int[] edge:edges)
        {
            int u=edge[0];
            int v=edge[1];
            F[u-1]++;
            F[v-1]++;
            if(F[u-1]>1)return u;
            if(F[v-1]>1)return v;
        }
        return -1;
    }
}