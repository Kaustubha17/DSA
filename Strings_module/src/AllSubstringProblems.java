
public class AllSubstringProblems {

	public static void main(String[] args) {
	String str1="ab";
	for(int i=0;i<str1.length();i++) {
		for(int j=i;j<str1.length();j++) {
			System.out.println(str1.substring(i, j)+str1.charAt(j));
		}
	}
	

	}

}
