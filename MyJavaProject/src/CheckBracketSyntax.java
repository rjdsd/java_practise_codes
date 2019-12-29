import java.util.Stack;

public class CheckBracketSyntax {
	
//  one safe way to have correct answer is to put all this code into try catch.
	//If exception return 0. 
	
   public int solution(String str) {
	// write your code in Java SE 8
	Stack<Character> stk = new Stack<Character>();
	char[] tokens = str.toCharArray();
	for (int i = 0 ; i < tokens.length; i++ ) {
		if (tokens[i] == '(' || tokens[i] == '{' || tokens[i] == '[') {
			stk.push(tokens[i]);
		}
		else if (tokens[i] == ')') {
			if(stk.size() == 0) return 0;
			while(stk.peek() != '(') {
				stk.pop();
			}
			stk.pop();
		}
		else if (tokens[i] == '}') {
			if(stk.size() == 0) return 0;
			while(stk.peek() != '{') {
				stk.pop();
			}
			stk.pop();
		}
		else if (tokens[i] == ']') {
			if(stk.size() == 0) return 0;
			while(stk.peek() != '[') {
				stk.pop();
			}
			stk.pop();
		}
	}
    if (stk.size() == 0) {
    	return 1;
    }
    return 0;
   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckBracketSyntax obj = new CheckBracketSyntax();
		System.out.println(obj.solution("(())}"));
		System.out.println(obj.solution("{"));

	}

}
