package geeksforgeeks;

public class SubSetSumRecursion {
	
	 static boolean isSubsetSum(int set[], int n, int sum) {
		 if(sum == 0 ) {
			 return true;
		 }
		 else if(n == 0) {
			 return false;
		 }
		 else {
			 return isSubsetSum(set, n-1, sum-set[n-1]) || isSubsetSum(set, n-1, sum);
		 }
	 }

	public static void main(String[] args) {
		int set[] = {0,0,-1}; 
        int sum = -1; 
        int n = set.length; 
        if (isSubsetSum(set, n, sum) == true) 
            System.out.println("Found a subset"
                          + " with given sum"); 
        else
            System.out.println("No subset with"
                               + " given sum");

	}

}
