
public class PrintKeyPad {

	public static String keys[]= {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

	public static void printKeypad(int n,String ansSoFar[]) {
		if(n==0) {

			for(String s:ansSoFar) {
			System.out.print(s+" ");
			}
			return;
		}
		int lastDigit=n%10;
		String digitsToBeAdded=keys[lastDigit-2];

		if(ansSoFar.length==0)
		{
			ansSoFar=new String[digitsToBeAdded.length()];
			for(int i=0;i<digitsToBeAdded.length();i++)
				ansSoFar[i]=digitsToBeAdded.charAt(i)+"";

			printKeypad(n/10, ansSoFar);
		}
		else {
			String temp[]=new String[ansSoFar.length*digitsToBeAdded.length()];
			int k=0;
			for(int i=0;i<digitsToBeAdded.length();i++)
				for(int j=0;j<ansSoFar.length;j++)
				{
					temp[k]=digitsToBeAdded.charAt(i)+ansSoFar[j];

					k++;
				}

			ansSoFar=temp;
			printKeypad(n/10, temp);
		}




	}

	public static void main(String[] args) {
		String s[]={};

		printKeypad(237,s );

	}

}
