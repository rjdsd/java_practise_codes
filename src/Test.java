import java.util.Hashtable;

public class Test {
	
	private int findCountOfSetBits(int i) {
		int setBitCount = 0;
		while(i > 0) {
			if (i%2 == 1) {
				setBitCount++;
			}
			i = i >> 1;
		}
		System.out.println(setBitCount);
		return setBitCount;
	}
	
	private void findXorOfAllInRange(int M, int N) {
		int val = M;
		for(int i = M+1; i <= N; i++) {
			val = val ^ i;
		}
		System.out.println(val);
	}
	
	  
	  public int solution2(int[] A) {
	        // write your code in Java SE 8
		  boolean [] flag = new boolean[A.length+1];
		  for(int i=0; i < A.length; i++) {
			  if ( A[i] > 0 && A[i] < flag.length) {
				  flag[A[i]] = true; 
			  }
		  }
		  for (int i=1; i<=A.length; i++) {
			  if(!flag[i]) {
				  return i;
			  }
		  }
		  return flag.length;
	    }
	  
	    public int solution3(int N) { // write your code in Java SE 8
	    	int totalBitCount = 0;
	    	int totalZeroBitCount = 0;
	    	int [] count = {0,0,0,0,0,0,0,0,0,0};
	    	int temp1 = N;
	    	int rem = 0;
	    	int res;
			while(temp1 > 0) {
				totalBitCount++;
				rem = temp1 % 10;
				temp1 = temp1/10;
				if(rem == 0) {
					totalZeroBitCount++;
				}
				count[rem]= count[rem]+1; 
			}
			res = fact(totalBitCount);
			for (int i=0; i <= 9; i++) {
				if (count[i] > 1) {
					res = res / fact(count[i]);
				}
			}
			if(totalZeroBitCount == totalBitCount -1 ) {
				return 1;
			}
			if (totalZeroBitCount == 0) {				
				return res;
			} else {
				int nonZeroBit = totalBitCount - totalZeroBitCount;
				int val = fact(totalBitCount -1 );
				for (int i = 1; i<=9; i++) {
					if (count[i] > 1) {
						val = val / fact(count[i]);
					}
				}
				return res - val;
			}}
	  
	    
	   public int fact(int n) {
		   if (n <= 1) return 1;
		   else return n * fact(n-1);
	   }
  

	public static void main(String[] args) {
		Test t = new Test();
		Hashtable<Integer, String> table = new  Hashtable<Integer, String>();
		//t.findCountOfSetBits(7);
		//t.findXorOfAllInRange(5, 8);
		//int [] A = {1, 3, 6, 4, 1, 2};
		//int [] A = {7,5,4,6,3,2,1};
		//System.out.println(t.solution2(A));
		//System.out.println(t.solution3(000));
		
	
	}

}
