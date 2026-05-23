
public class RemoveDuplicates {
	public static String removeConsecutiveDuplicates(String str) {

        String result="";
        result+=str.charAt(0);
        for(int i=0;i<str.length();i++) {
        	if(result.charAt(result.length()-1)!=str.charAt(i))
        		result+=str.charAt(i);
        	
        }
        
        return result;
       
       
	}
	public static void main(String[] args) {
		String str="aaaba";
		
		System.out.println(removeConsecutiveDuplicates(str));
	}

}
