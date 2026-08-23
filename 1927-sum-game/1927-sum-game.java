class Solution
{
    public boolean sumGame(String num)
        {
                int leftSum=0,rightSum=0,leftQ=0,rightQ=0;
                        int n=num.length();
                                for(int i=0;i<n/2;i++)
                                        {
                                                    char c=num.charAt(i);
                                                                if(c=='?')
                                                                                leftQ++;
                                                                                            else
                                                                                                            leftSum+=c-'0';
                                                                                                                        c=num.charAt(n-1-i);
                                                                                                                                    if(c=='?')
                                                                                                                                                    rightQ++;
                                                                                                                                                                else
                                                                                                                                                                                rightSum+=c-'0';
                                                                                                                                                                                        }
                                                                                                                                                                                                if((leftQ+rightQ)%2==1)
                                                                                                                                                                                                            return true;
                                                                                                                                                                                                                    return leftSum-rightSum!=9*(rightQ-leftQ)/2;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        }