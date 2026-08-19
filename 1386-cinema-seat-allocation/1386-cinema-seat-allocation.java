class Solution 
{
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) 
    {
        Map<Integer,Set<Integer>>M=new HashMap<>();
        for(int[] b:reservedSeats)
        {
            if(M.containsKey(b[0]))
            {
                Set<Integer>S=M.get(b[0]);
                S.add(b[1]);
                M.put(b[0],S);
            }
            else
            {
                Set<Integer>S=new HashSet<>();
                S.add(b[1]);
                M.put(b[0],S);
            }
        }
        int r=(n-M.size())*2;
        for(Set<Integer>s:M.values())
        {
            boolean left=!s.contains(2) && !s.contains(3) &&
                    !s.contains(4) && !s.contains(5);
            boolean middle=!s.contains(4) && !s.contains(5) &&
                    !s.contains(6) && !s.contains(7);
            boolean right=!s.contains(6) && !s.contains(7) &&
                    !s.contains(8) && !s.contains(9);
            if(left && right)r+=2;
            else if(left || right || middle)r+=1;
        }
        return r;
    }
}