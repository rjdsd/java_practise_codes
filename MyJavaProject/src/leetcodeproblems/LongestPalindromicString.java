//https://leetcode.com/problems/longest-palindromic-substring/
class longestPalindromicString {
    public String longestPalindrome(String s) {
        if(s.equals("")){
            return "";
        }
        int maxLength = 0;
        int startIndex, endIndex;
        startIndex = endIndex = 0;        
        int[][] palindromLength = new int[s.length()][s.length()];
        for(int i=0; i<s.length();i++){
            palindromLength[i][i] = 1;
            if(i<s.length()-1 && s.charAt(i) == s.charAt(i+1) ){
                palindromLength[i][i+1] = 2;
                maxLength = 2;
                startIndex = i;
                endIndex = i+1;
            }
        }
        for(int i=s.length()-2; i>=0; i--){
            for(int j=i+1; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && palindromLength[i+1][j-1] >= 1 ){
                    palindromLength[i][j] = palindromLength[i+1][j-1] + 2;
                }
                if(palindromLength[i][j] > maxLength){
                        maxLength = palindromLength[i][j];
                        startIndex = i;
                        endIndex = j;
                }
            }
        }
        return(s.substring(startIndex,endIndex+1));
    }
}