class Solution 
{
    public int lastStoneWeight(int[] stones) 
    {
        PriorityQueue<Integer>P=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones)
        {
            P.offer(i);
        }
        while(P.size()>1)
        {
            int x=P.poll();
            int y=P.poll();
            if(x!=y)P.offer(Math.abs(x-y));
        }
        return P.size()==1?P.poll():0;
    }
}