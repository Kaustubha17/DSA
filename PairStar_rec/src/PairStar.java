
public class PairStar {

	 public static String addStars(String s) { 
if(s.length()==0)
	return "";

if(s.length()==1)
	return s;

char firstChar=s.charAt(0);
String lastChar=addStars(s.substring(1));
		 if(firstChar==lastChar.charAt(0))
		 {
			 return firstChar+"*"+lastChar;
		 }
		 return firstChar+lastChar;
	    }
	public static void main(String[] args) {
		String s="hello";
		System.out.println(addStars(s));
	}

}
