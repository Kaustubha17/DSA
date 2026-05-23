
public class ReturnSubSequences {

	public static String[] printSubSequences(String word) {
		if(word.length()==0)
		{
			String ans[]= {""};
			return ans;
		}
		String partialAns[]=printSubSequences(word.substring(1));
		String ans[]=new String[2*partialAns.length];
		for(int i=0;i<partialAns.length;i++)
		{
			ans[i]=partialAns[i];
		}
		for(int i=0;i<partialAns.length;i++)
		{
			ans[i+partialAns.length]=word.charAt(0)+partialAns[i];
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		String arr[]=printSubSequences("abc");
		for(String s:arr) {
			System.out.print(s+" ");
		}
		
	}

}
