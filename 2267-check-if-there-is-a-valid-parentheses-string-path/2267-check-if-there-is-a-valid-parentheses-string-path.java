class Solution 
{
    public boolean hasValidPath(char[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;
        int p=n+m-1;
        if(p%2==1 || grid[0][0]!='(' || grid[n-1][m-1]!=')')return false;
        boolean[][][] dp=new boolean[n][m][p+1];
        dp[0][0][1]=true;
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            {
                int c=grid[i][j]=='('?1:-1;
                if(i>0) 
                {
                    for(int b=0;b<=p;++b) 
                    {
                        if(!dp[i-1][j][b]) 
                        {
                            continue;
                        }
                        int next=b+c;
                        if(next>=0) 
                        {
                            dp[i][j][next]=true;
                        }
                    }
                }
                if(j>0) 
                {
                    for(int b=0;b<=p;++b) 
                    {
                        if(!dp[i][j-1][b]) 
                        {
                            continue;
                        }
                        int next=b+c;
                        if(next>=0) 
                        {
                            dp[i][j][next]=true;
                        }
                    }
                }
            }
        }
        return dp[n-1][m-1][0];
    }
}
