package Stacks;

import java.util.Stack;

public class BracketsBalanced {

public static boolean isBalanced(String expression) {
        
        Stack<Character>stack=new Stack<>();
    
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)=='{'||expression.charAt(i)=='('||expression.charAt(i)=='['){
              stack.push(expression.charAt(i));  
            }
//            check pairs
            else if(expression.charAt(i)==')') {
         
            	char last;
				try {
					last = stack.peek();
				} catch (Exception e) {
					return false;
				}
       
            if(last=='(')
            	stack.pop();
            else return false;
            }
            else if(expression.charAt(i)==']') {
                char last;
				try {
					last = stack.peek();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					return false;
				}
                if(last=='[')
                	stack.pop();
                else return false;
                }
            else if(expression.charAt(i)=='}') {
                char last;
				try {
					last = stack.peek();
				} catch (Exception e) {
					return false;
					
				}
                if(last=='{')
                	stack.pop();
                else return false;
                }

        }
        if(stack.size()==0)
        	return true;
        
        else
        	return false;
        
        
        
    }
	
	
	public static void main(String[] args) {
		String s="()]";
System.out.println(isBalanced(s));
	}

}
