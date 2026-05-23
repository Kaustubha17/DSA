
public class PrintSubSequence {

	public static void printSubSequence(String input,String resultSoFar) {
		if(input.length()==0) {
			System.out.println(resultSoFar);
			return;
		}
		
		printSubSequence(input.substring(1), resultSoFar+input.charAt(0));
		printSubSequence(input.substring(1), resultSoFar);

	}
	
	public static void main(String[] args) {
		printSubSequence("abc", "");

	}

}
