class Solution 
{
    public String mostCommonWord(String paragraph, String[] banned) 
    {
        String[] words=paragraph.replaceAll("[,.!?'';]"," ").toLowerCase().split("\\s+");
        Map<String,Integer>M=new HashMap<>();
        Set<String>S=new HashSet<>();
        for(String ban:banned)
        {
            S.add(ban);
        }
        int max=0;
        String res="";
        for(String word:words)
        {
            if(S.contains(word))continue;
            int f=M.getOrDefault(word,0);
            if(f==max)
            {
                res=word;
                max++;
            }
            f++;
            M.put(word,f);
        }
        return res;
    }
}