class Solution 
{
    public String[] createGrid(int m, int n) 
    {
        char[][] C=new char[m][n];
        Arrays.fill(C[0],'.');
        for(int i=1;i<m;i++)
        {
            Arrays.fill(C[i],'#');
            C[i][n-1]='.';
        }
        String[] res=new String[m];
        for(int i=0;i<m;i++)
        {
            res[i]=new String(C[i]);
        }
        return res;
    }
}