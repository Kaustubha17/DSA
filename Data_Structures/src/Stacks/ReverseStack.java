package Stacks;

import java.util.Stack;

public class ReverseStack {
public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		if(input.size()==0)
			return;
		
		int element=input.pop();
		reverseStack(input, extra);
		while(!input.isEmpty()) {
			extra.push(input.pop());
		}
		input.push(element);
		while(!extra.isEmpty()) {
			input.push(extra.pop());
		}
		
        
	}

	public static void main(String[] args) {
		Stack<Integer> input=new Stack<>();
		input.push(10);
		input.push(12);
		input.push(13);
		Stack<Integer>helper=new Stack<>();
		reverseStack(input,helper);
		while(!input.isEmpty()) {
			System.out.println(input.pop());
		}
		
	}

}
