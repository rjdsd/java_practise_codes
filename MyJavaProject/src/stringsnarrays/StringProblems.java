package stringsnarrays;

import java.util.HashSet;

public class StringProblems {
	
	
	private boolean isAnagram (String s1, String s2) {
		int[] arr1 = new int[256];
		int[] arr2 = new int[256];
		int i = 0;
		for (i=0; i<256; i++) {
			arr1[i] = 0;
			arr2[i] = 0;
		}
		for(i = 0 ; i < s1.length(); i ++ ) {
			arr1[s1.charAt(i)] = arr1[s1.charAt(i)] + 1;
		}
		for(i = 0 ; i < s2.length(); i ++ ) {
			arr2[s2.charAt(i)] = arr2[s2.charAt(i)] + 1;
		}
		for (i=0; i<256; i++) {
			if(arr1[i] != arr2[i]) {
				return false;
			}
		}	
		return true;
	}
	
	
	private boolean isPalindrom(String s) {
		int i, j;
		i = 0;
		j = s.length()-1;
		while(i <= j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}	
		return true;
	}
	
	
	private boolean isPalindromIgnoreCase(String s) {
		int i, j;
		i = 0;
		j = s.length()-1;
		while(i <= j) {
			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
				return false;
			}
			i++;
			j--;
		}	
		return true;
	}
	
	
	private int findUniqueSubStrOfLenK(int k , String str ) {
		char[] arr = str.toCharArray();
		HashSet<String> set = new HashSet<String>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <= arr.length - k ; i ++) {
			sb.setLength(0);
			for(int j=i; j <= i + k -1; j++ ) {
				sb.append(arr[j]);
			}
			set.add(sb.toString());
		}
		return set.size();
	}

	public static void main(String[] args) {
		StringProblems stringProblems = new StringProblems();
		
		//System.out.println(stringProblems.isAnagram("Hello", "lloeH"));
		
		System.out.println(stringProblems.isPalindrom("NaaN"));
		
		System.out.println(stringProblems.isPalindromIgnoreCase("Nayan"));
		
		System.out.println(stringProblems.findUniqueSubStrOfLenK(4, "aaaaaaa"));
		System.out.println(stringProblems.findUniqueSubStrOfLenK(4, "abcdefgh"));
		System.out.println(stringProblems.findUniqueSubStrOfLenK(10, "aaaaaaa"));

	}

}
