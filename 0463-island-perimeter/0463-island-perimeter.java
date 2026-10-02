class Solution 
{
    public int islandPerimeter(int[][] grid) 
    {
        int rows=grid.length;
        int cols=grid[0].length;
        int res=0;
        for(int row=0;row<rows;row++)
        {
            for(int col=0;col<cols;col++)
            {
                if(grid[row][col]==0)continue;
                if(row-1>=0 && grid[row-1][col]==0)res++;
                else if(row==0)res++;
                if(row+1<rows && grid[row+1][col]==0)res++;
                else if(row==rows-1)res++;
                if(col-1>=0 && grid[row][col-1]==0)res++;
                else if(col==0)res++;
                if(col+1<cols && grid[row][col+1]==0)res++;
                else if(col==cols-1)res++;
            }
        }
        return res;
    }
}