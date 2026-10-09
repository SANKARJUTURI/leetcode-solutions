class Solution {
    public int minInsertions(String st) {
        int cnt = 0;
        int min = 0;
        int n = st.length();
        int i=0;
        StringBuilder s = new StringBuilder();
        while(i<n){
            char c = st.charAt(i);
            if(c==')'){
                s.append(c);
                if((i+1<n && st.charAt(i+1)==')')) {
                    i+=2;
                }
                else {
                    min++;
                    i++;
                }
            }
            else {
                s.append(c);
                i++;
            }
        }
        for(char c : s.toString().toCharArray()){
            if(c=='(') cnt++;
            else cnt--;
            if(cnt<0){
                min++;
                cnt=0;
            }
        }
        min += 2*cnt;
        return min;
    }
}