/*
Given two strings S and T with lengths M and N. 
  Find and return the length of their shortest 'Super Sequence'.
The shortest 'Super Sequence' of two strings is defined as the smallest 
string possible that will have both the given strings 
as its subsequences.

Ex:-
ip:
	ab
	ac

op: 3 abc

 */
public class Smallest_Super_Sequence {

	public static int smallestSuperSequence(String str1, String str2) {
		if(str1.length()==0)
			return str2.length();
		if(str2.length()==0)
			return str1.length();
		int ans;
		if(str1.charAt(0)!=str2.charAt(0)) {
			int ans1=1+smallestSuperSequence(str1.substring(1), str2);
			int ans2=1+smallestSuperSequence(str1, str2.substring(1));
			int ans3=2+smallestSuperSequence(str1.substring(1), str2.substring(1));
			ans=Math.min(Math.min(ans3 ,ans1), ans2);


		}
		else
			ans=1+smallestSuperSequence(str1.substring(1), str2.substring(1));

		return ans;

	}

	public static int smallestSuperSequence2(String str1, String str2,int i,int j,int dp[][]) {
		  if(str1.length()==0)
	            return str2.length();
	        if(str2.length()==0)
	            return str1.length();

		if(str1.length()<=i || str2.length()<=j)
			return Math.abs(i-j);

		if(dp[i][j]!=-1)
			return dp[i][j];

		int ans;
		if(str1.charAt(i)!=str2.charAt(j)) {

			int ans1=1+smallestSuperSequence2(str1, str2,i+1,j,dp);
			int ans2=1+smallestSuperSequence2(str1, str2,i,j+1,dp);
			
			ans=Math.min(ans1 ,ans2);

		}
		else
		{
			ans=1+smallestSuperSequence2(str1, str2,i+1,j+1,dp);
		}
		dp[i][j]=ans;
		return ans;

	}
	public static void main(String[] args) {
		String	str1="pqqrpt";
		String str2="qerepct";
		str1="a";
		str2="";
		/*for(int i=0;i<1000;i++)
			str1+=(char)((Math.random()+i)%26+'a');

		for(int i=0;i<1000;i++)
			str2+=(char)((Math.random()*i)%26+'a');
		*/
//		System.out.println(str1);
//		System.out.println(str2);
		int dp[][]=new int[str1.length()+1][str2.length()+1];

		for(int i=0;i<dp.length;i++)
			for(int j=0;j<dp[0].length;j++)
				dp[i][j]=-1;
		System.out.println(smallestSuperSequence2(str1, str2,0,0,dp));
		 
	}

}
