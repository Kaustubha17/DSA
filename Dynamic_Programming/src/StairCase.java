
public class StairCase {

	public static long staircase(int n) {
		if(n<0)
			return 0;
		if(n==1||n==0)
			return 1;
		
		
		long step1=staircase(n-1);
		long step2=staircase(n-2);
		long step3=staircase(n-3);
		
		return step1+step2+step3;
	}
	
	public static void main(String[] args) {
		System.out.println(staircase(10));

	}

}
