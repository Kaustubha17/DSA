
public class KeyPadCode {

	public static String keys[]= {"abc","def","ghi","jkl","mno","pqr","stu","vwx","yz"};

	public static String[] keypad(int n){
		if(n==0)
		{
			String s[]= {""};
			return s;
		}
		String partialAns[]=keypad(n/10);
		int lastDigit=n%10;
		String ans[];

		if(partialAns.length!=0)
			ans=new String[partialAns.length*(keys[lastDigit-2].length())];
		else
			ans=new String[keys[lastDigit-2].length()];

		int k=0;
		for(int i=0;i<keys[lastDigit-2].length();i++)
			for(int j=0;j<partialAns.length;j++) {
				ans[k]=partialAns[j]+keys[lastDigit-2].charAt(i);
				k++;
			}
			
		
		
		return ans;
	}

	public static void main(String[] args) {
		String ans[]=keypad(2);
		System.out.println(ans.length);
		for(String s:ans)
			System.out.print(s+" ");

	}

}
