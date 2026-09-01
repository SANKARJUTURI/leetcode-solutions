class Solution 
{
    public boolean validPath(int n, int[][] edges, int source, int destination) 
    {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer>Q=new LinkedList<>();
        boolean[] visit=new boolean[n];
        visit[source]=true;
        Q.offer(source);
        while(!Q.isEmpty())
        {
            int s=Q.size();
            for(int i=0;i<s;i++)
            {
                int x=Q.poll();
                if(x==destination)return true;
                for(int j:adj.get(x))
                {
                    if(!visit[j])
                    {
                        Q.offer(j);
                        visit[j]=true;
                    }
                }
            }
        }
        return false;
    }
}