package Stacks;

import java.util.Stack;

public class StackUse {



	public static void main(String[]args) throws StackEmptyException,StackFullException {
		//		StackUsingArray s=new StackUsingArray();
		//		s.push(10);
		//		System.out.println(s.top());
		//		System.out.println(s.pop());
		////		System.out.println(s.pop());
		//		System.out.println(s.size());
		//		
		//		System.out.println(s.isEmpty());


		StackUsingLL<String>s1=new StackUsingLL<>();
		
		s1.push("you?");
		s1.push("how are ");
		s1.push("Hello ");
			

		while(!s1.isEmpty()) {
			System.out.println(s1.pop());

		}
//		System.out.println(s1.pop());
System.out.println(s1.size());
//	System.out.println(s1.pop());

Stack<Integer> stack=new Stack<>();
stack.push(5);
stack.push(10);
stack.push(15);
System.out.print(stack.pop()+stack.size());
/*
System.out.println(stack.size());
System.out.println(stack.capacity());
System.out.println(stack.peek());
System.out.println(stack.pop());
*/
	}
}
