
public class CheckAB {
	public static boolean checkAB(String input) {

		if(input.length()==0)
			return true;
		
	if(input.charAt(0)=='a') {
		if(input.length()>=3 && input.charAt(1)=='b' && input.charAt(2)=='b')
		{
			return checkAB(input.substring(3));
		}
		else {
			return checkAB(input.substring(1));
		}
		
	}
	else {
	return false;	
	}





        
        
        
	}
	public static void main(String[] args) {
String s="abbb";
System.out.println(checkAB(s));
//System.out.println(s.substring(3));
	}

}
