package Stacks;

import java.util.Stack;

public class MinimumBracketReversal {
	public static int countBracketReversals(String input) {
	if(input.length()%2!=0 ||input.length()==0)
		return -1;
		
		int count=0;
		Stack<Character> s=new Stack<>();
		for(int i=0;i<input.length();i++) {
			char c=input.charAt(i);
			if(c=='{')
				s.push(input.charAt(i));
			else if(c=='}'&& s.size()!=0 && s.peek()=='{' )
				s.pop();
			else
				s.push(c);
		}
		
		
		while(!s.isEmpty()) {
			char c=s.pop();
			char t=s.pop();
			if(t=='}' && c=='{') {
				count+=2;
			}
			
			else if(t=='{' && c=='{')
				count+=1;
			else if(t=='}' && c=='}')
				count+=1;
			
		}
		
		
		return count;
	}
	public static void main(String[] args) {
		String s="}}}{{{";
		System.out.println(countBracketReversals(s));

	}

}
