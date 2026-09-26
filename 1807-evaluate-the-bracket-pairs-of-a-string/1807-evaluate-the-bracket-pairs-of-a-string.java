class Solution 
{
    public String evaluate(String s, List<List<String>> knowledge) 
    {
        Map<String,String>M=new HashMap<>();
        for(List<String>L:knowledge)
        {
            M.put(L.get(0),L.get(1));
        }
        StringBuilder sb=new StringBuilder();
        StringBuilder temp=new StringBuilder();
        int n=s.length();
        int i=0;
        while(i<n)
        {
            if(s.charAt(i)=='(')
            {
                i++;
                while(i<n && s.charAt(i)!=')')
                {
                    temp.append(s.charAt(i));
                    i++;
                }
                if(M.containsKey(temp.toString()))
                {
                    sb.append(M.get(temp.toString()));
                }
                else
                {
                    sb.append("?");
                }
                temp.setLength(0);
            }
            else
            {
                sb.append(s.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
}