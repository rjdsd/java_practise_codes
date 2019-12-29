package leetcodeproblems;



public class StringProblems {
	
	// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[256];
        int[] lastIndex = new int[256];
        int max = 0, cur = 0;
        for(int i=0; i<26; i++){
            count[i] = 0;
            lastIndex[i] = 0;
        }
        char [] charSet = s.toCharArray();
        for (int i = 0 ; i < charSet.length ; i++) {
        	if(count[charSet[i]] == 1) {
        		cur = Math.min(cur+1, i - lastIndex[charSet[i]]);
        	} 
        	else {
        		count[charSet[i]] = 1;
        		cur++;
        	}
        	lastIndex[charSet[i]] = i;
        	//System.out.println(cur);
        	if(cur > max) {
    			max = cur;
    		}
        }
        return max;
    }

	public static void main(String[] args) {
		StringProblems prob = new StringProblems();
		System.out.println(prob.lengthOfLongestSubstring("DabcaDefgh"));//8
		System.out.println(prob.lengthOfLongestSubstring("tmmzuxt"));//5
		System.out.println(prob.lengthOfLongestSubstring("abcabcbb"));//3
	}

}
