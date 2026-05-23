
public class CheckPermutation {

	public static boolean isPermutation(String str1, String str2) {
		if(str1.length()!=str2.length())
        return false;
        
        int arr1[]=new int[27];
        int arr2[]=new int[27];
        for(int i=0;i<str1.length();i++){
            arr1[(123-str1.charAt(i))]++;
        }
        for(int i=0;i<str2.length();i++){
            arr2[(123-str2.charAt(i))]++;
        }
        for(int i=0;i<26;i++) {
        	if(arr1[i]!=arr2[i])
        		return false;
        }
        
        
        return true;
        
	}
	
	public static void main(String[] args) {
	String str1="abc";
	String str2="bac";
	System.out.println(isPermutation(str1, str2));
		
	}

}
