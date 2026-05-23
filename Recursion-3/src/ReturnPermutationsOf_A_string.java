
public class ReturnPermutationsOf_A_string {

public static String[] permutationOfString(String input){
	if(input.length()==1)
	{
		String ans[]= {input};
		return ans;
	}
	String ans[]= {};
	for(int i=0;i<input.length();i++) {
		String preString;
		String postString;
		char inChar=input.charAt(i);
		if(i==0)
			preString="";
		else
			preString=input.substring(0, i);
		
		postString=input.substring(i+1);
		
		String partialAns[]=permutationOfString(preString+postString);
		String temp[]=ans;
		ans=new String[partialAns.length+temp.length];
		
		for(int j=0;j<temp.length;j++) {
			ans[j]=temp[j];
		}
		for(int j=0;j<partialAns.length;j++) {
			ans[j+temp.length]=inChar+partialAns[j];
		}
		
		
		
	}
	
	
	
return ans;
		
	}
	
	public static void main(String[] args) {
		String a="abc";
		
		String ans[]=permutationOfString(a);
		System.out.println(ans.length);
		for(String s:ans) {
			System.out.println(s);
		}
		

	}

}
