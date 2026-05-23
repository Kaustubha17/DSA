
public class ReverseWordWise {

	public static void reverse(String str) {
		int n=str.length();
		String result="";
		int i=n-1;
		int startIndex=i;
		for(;i>=0;i--) {
			if(str.charAt(i)==' ') {
				result+=str.substring(i+1,startIndex+1)+" ";
				startIndex=i-1;
			}
		}
		
		result+=str.substring(i+1,startIndex+1);
		System.out.println(result);
		
	}
	
	
	public static void main(String[] args) {
		
		String str="Welcome to my home";
//		output: home my to Welcome
		reverse(str);
		
		
		

	}

}
