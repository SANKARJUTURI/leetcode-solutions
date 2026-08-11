int hammingWeight(int n) 
{
    int r=0;
    while(n!=0)
    {
        if(n%2==1)r++;
        n/=2;
    }
    return r;
}