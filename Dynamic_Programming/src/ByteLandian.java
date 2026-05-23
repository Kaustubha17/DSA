import java.util.HashMap;

public class ByteLandian {

	public static long bytelandian(long n, HashMap<Long, Long> memo) {
     memo.put((long) 0,(long) 0);
 long arr[]=new long[(int)n+1];
 
 
 arr[0]=(long)0;
 
    	 
	/*
	 * for(int j=1;j<=n;j++) { long nBy2=j/2; long nBy3=j/3; long nBy4=j/4; long
	 * sum=memo.get(nBy2)+memo.get(nBy3)+memo.get(nBy4); long
	 * maxValue=Math.max(j,sum); memo.put((long)j, maxValue);
	 * 
	 * }
	 */
 
 for(int j=1;j<=n;j++) {
	 int nBy2=j/2;
	 int nBy3=j/3;
	 int nBy4=j/4;
	 long sum=arr[nBy2]+arr[nBy3]+arr[nBy4];
	 long maxValue=Math.max((long)j,sum);
	 arr[j]= maxValue;
	 
 }
     
     
		
		return arr[(int)n];
	}

	public static long bytelandianRec(long n, HashMap<Long, Long> memo) {
		
		if(n==0)
		{
			return (long) 0;
		}
		long nBy2=n/2;
		long nBy3=n/3;
		long nBy4=n/4;
		long sum1;
		long sum2;
		long sum3;
		
//		n/2
		if(!memo.containsKey(nBy2)) {
			sum1=bytelandianRec(nBy2, memo);
			memo.put(nBy2, sum1);
		}
		else
		{
			sum1=memo.get(nBy2);
		}
		
//		n/3
		if(!memo.containsKey(nBy3)) {
			sum2=bytelandianRec(nBy3, memo);
			memo.put(nBy3, sum2);
		}
		else
		{
			sum2=memo.get(nBy3);
		}
//		n/4
		
		if(!memo.containsKey(nBy4)) {
			sum3=bytelandianRec(nBy4, memo);
			memo.put(nBy4, sum3);
		}
		else
		{
			sum3=memo.get(nBy4);
		}
		
		return Math.max(n, sum1+sum2+sum3);
		
	}
	
	
	public static void main(String[] args) {
		
		 HashMap<Long, Long> memo=new HashMap<>();
		 System.out.println(bytelandianRec(1000000, memo));
	}

}
