
public class RemoveChar {
	public static String removeAllOccurrencesOfChar(String str, char ch) {
		String res="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=ch)
                res+=str.charAt(i);
                                     }
        
        return res;
        
	}
	public static void main(String[] args) {
		

	}

}
