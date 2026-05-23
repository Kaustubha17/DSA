package frazSheet.Arrays;

public class TotalDuration60 {
	public static int numPairsDivisibleBy60(int[] time) {
		int ans=0;
		int arr[]=new int[60];

		for(int i=0;i<time.length;i++) {
			arr[time[i]%60]=arr[time[i]%60]+1;
		}

		int num30=arr[30];
		for(int i=1;i<arr.length;i++) {
			int q=arr[60-i];
			int a=arr[i];
			if(q!=0 && a!=0)
			{
				System.out.println(60-i+" "+i);
			}
			
			ans+=q*a;
		}
System.out.println(ans);
		ans=ans-(num30*num30);

		ans=ans/2;

		int incDue30=(num30*(num30-1))/2;

		ans+=incDue30;
		if(arr[0]>1)
		ans+=arr[0];
		return ans;
	}

	public static int numPairsDivisibleBy60Iter(int[] time) {
		int ans=0;
		for(int i=0;i<time.length-1;i++) {
			for(int j=i+1;j<time.length;j++)
			{
				if((time[i]+time[j])%60==0)
				{
					System.out.println(time[i]+" "+time[j]);
					ans++;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int time[]= {60,60,60,60,60,60,60,60,60,60,60,60,60
				,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,
				60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60
				,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,
				60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60
				,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60
				,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60
				,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60
				,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60
				,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,
				60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,
				60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,
				60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,
				60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,
				60};
		System.out.println(numPairsDivisibleBy60(time));
//		System.out.println(numPairsDivisibleBy60Iter(time));

	}

}
