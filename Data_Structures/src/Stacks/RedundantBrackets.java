package Stacks;

import java.util.Stack;

public class RedundantBrackets {
	public static boolean checkRedundantBrackets(String expression) {
		Stack<Character>s =new Stack<>(); 
		for(int i=0;i<expression.length();i++) {
			if(expression.charAt(i)!=')')
				s.push(expression.charAt(i));
			else {
				int c=0;
			while(s.peek()!='(') {
				s.pop();
				c++;
			}
			s.pop();
			if(c<2) {
				return true;
			}
		}
			}

return false;
	}
	public static void main(String[] args) {
		String s="(x+y*(a-b))";
		System.out.println(checkRedundantBrackets(s));
	}

}
