
public class ReverseEachWord {

	public static String reverse(String str) {
		String s="";
		int i=str.length()-1;
		while(i>=0) {
			s+=str.charAt(i);
			
			i--;
		}
		
		return s;
	}
	public static String reverseEachWord(String str) {
		String result="";
		int i=0;
		int startIdx=0;
		
		for(;i<str.length();i++) {
			if(str.charAt(i)==' ') {
				String substr=str.substring(startIdx,i);
				result+=reverse(substr)+" ";
				startIdx=i+1;
			}
		}
		String substr=str.substring(startIdx,i);
		result+=reverse(substr)+" ";
		
		
		
		return result;
	}
	
	public static void main(String[] args) {
		String str="Welcome to my home";
System.out.println(reverseEachWord(str));		

	}

}
