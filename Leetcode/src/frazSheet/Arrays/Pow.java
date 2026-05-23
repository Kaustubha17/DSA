package frazSheet.Arrays;

public class Pow {
	public double myPow(double x, int n) {
		double ans=1;
		long absN=Math.abs((long)n);
//		System.out.println(absN);
		while(absN>0) {
			if((absN&1)==1)
				ans*=x;
			absN=absN>>1;

			x*=x;
//			System.out.println(absN);
		}

		return n>0?ans:1/ans;
	}
	public static void main(String[] args) {


		System.out.println(new Pow().myPow(2.00000, -2147483648));
	}

}
