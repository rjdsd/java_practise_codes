import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindIfBinaryNumberIsDivisibleBy3 {
	
	int[] rem = new int[100];
	
	public void checkDivisibilityBy3(String binaryNum) {
		int sum = 0;
		for(int i = binaryNum.length()-1; i >= 0; i-- ) {
			if (binaryNum.charAt(i) == '1') {
				sum += rem[binaryNum.length()-1-i];
			}
		}
		if(sum%3 == 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		
		
	}
	
	public void init() {
		rem[0] = 1;
		//  avoid branching by if
		for (int i = 1; i < rem.length; i = i+2 ) {
			rem[i] = 2;
		}
		for (int i = 2; i < rem.length; i = i+2 ) {
			rem[i] = 1;
		}
	}

	public static void main(String[] args) {
		FindIfBinaryNumberIsDivisibleBy3 obj = new FindIfBinaryNumberIsDivisibleBy3();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseCOunt = 0;
		obj.init();
		try {
			testCaseCOunt = Integer.parseInt(br.readLine());
			for(int i=0; i < testCaseCOunt; i++) {
				obj.checkDivisibilityBy3(br.readLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//obj.checkDivisibilityBy3("1001");
		//obj.checkDivisibilityBy3("1100");
		//obj.checkDivisibilityBy3("1010");
		
	}

}
