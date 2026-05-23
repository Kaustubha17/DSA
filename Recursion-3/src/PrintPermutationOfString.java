
public class PrintPermutationOfString {

	public static void permutations(String input,String resultSoFar){
		if(input.length()==0)
		{
			System.out.println(resultSoFar);
		return;
		}
		for(int i=0;i<input.length();i++) {
			String preString;
			String postString;
			char inChar=input.charAt(i);
			if(i==0)
				preString="";
			else
				preString=input.substring(0, i);
			
			postString=input.substring(i+1);
			permutations(preString+postString,resultSoFar+inChar);
		}
		
	}
	
	
	public static void permutations(String input){
		permutations(input,"");
	}
	
	public static void main(String[] args) {
permutations("abc");
		

	}

}
