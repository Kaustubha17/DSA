
public class EditDistance {

	/*
	 * public static int editDistance(String s, String t,int i,int j) {
	 * 
	 * if(i==s.length()||j==t.length()) { return Math.abs(j-i); }
	 * if(s.charAt(i)==t.charAt(j)) { return editDistance(s, t, i+1, j+1); } else {
	 * 
	 * int ans1=1+editDistance(s, t, i+1, j+1);//this relates to replacement int
	 * ans2=1+editDistance(s, t, i+1, j);//this relates to deletion in s string int
	 * ans3=1+editDistance(s, t, i, j+1);//this relates to insertion in s string
	 * return Math.min(ans3, Math.min(ans1, ans2)); }
	 * 
	 * }
	 */
	
	 public static int editDist(String str1, String str2,int m,int n) {
			
		 // insert all characters of second string into first
	        if (m == 0)
	            return n;
	 
	        // If second string is empty, the only option is to
	        // remove all characters of first string
	        if (n == 0)
	            return m;
	 
	        // If last characters of two strings are same,
	        // nothing much to do. Ignore last characters and
	        // get count for remaining strings.
	        if (str1.charAt(m - 1) == str2.charAt(n - 1))
	            return editDist(str1, str2, m - 1, n - 1);
	 
	        // If last characters are not same, consider all
	        // three operations on last character of first
	        // string, recursively compute minimum cost for all
	        // three operations and take minimum of three
	        // values.
	        return 1 + Math.min(Math.min(editDist(str1, str2, m, n - 1), editDist(str1, str2, m - 1, n)), editDist(str1, str2, m - 1,n - 1)    );
			
	    }
	
	public static void main(String[] args) {
		String str1="abc";
		String str2="adc";
	System.out.println(editDist(str1, str2,str1.length(),str2.length()));

	}

}
