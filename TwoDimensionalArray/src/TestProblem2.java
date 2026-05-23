
public class TestProblem2 {

public static String minLengthWord(String input){
		
		String res="";
		int i=0;
		int n=input.length();
		int startIdx=0;
		int minLength=Integer.MAX_VALUE;
		
		for(;i<n;i++) {
			if(input.charAt(i)==' ') {
						
				if((i-startIdx)<minLength) {
					minLength=i-startIdx;
					res=input.substring(startIdx, i);
					
				}
				startIdx=i+1;
			}
		}
		
		
		if((i-startIdx)<minLength) {
			minLength=i-startIdx;
			res=input.substring(startIdx, i);
			
		}	
		
		
		return res;

	}
	
	
	public static void main(String[]args) {
		String str="abc deabc de ghihjk uvw j";
		System.out.println(minLengthWord(str));
		
	}
}
