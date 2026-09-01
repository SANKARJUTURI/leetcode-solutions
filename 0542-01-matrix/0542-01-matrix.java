class pair
{
    int i,j,v;
    pair(int i,int j,int v)
    {
        this.i=i;
        this.j=j;
        this.v=v;
    }
}
class Solution 
{
    public int[][] updateMatrix(int[][] mat) 
    {
        int m=mat.length;
        int n=mat[0].length;
        int[][] res=new int[m][n];
        boolean[][] visit=new boolean[m][n];
        Queue<pair>Q=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    Q.offer(new pair(i,j,0));
                    visit[i][j]=true;
                }
            }
        }
        while(!Q.isEmpty())
        {
            int s=Q.size();
            for(int k=0;k<s;k++)
            {
                pair p=Q.poll();
                int i=p.i;
                int j=p.j;
                int v=p.v;
                if(i-1>=0 && !visit[i-1][j])
                {
                    Q.offer(new pair(i-1,j,v+1));
                    visit[i-1][j]=true;
                    res[i-1][j]=v+1;
                }
                if(i+1<m && !visit[i+1][j])
                {
                    Q.offer(new pair(i+1,j,v+1));
                    visit[i+1][j]=true;
                    res[i+1][j]=v+1;
                }
                if(j-1>=0 && !visit[i][j-1])
                {
                    Q.offer(new pair(i,j-1,v+1));
                    visit[i][j-1]=true;
                    res[i][j-1]=v+1;
                }
                if(j+1<n && !visit[i][j+1])
                {
                    Q.offer(new pair(i,j+1,v+1));
                    visit[i][j+1]=true;
                    res[i][j+1]=v+1;
                }
            }
        }
        return res;        
    }
}