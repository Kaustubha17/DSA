
public class FunctionOverLoading {

	public static int sum (int a,int b) {
		// TODO Auto-generated method stub
		return a+b;
	}
	public static int sum(int a) {
		return a+1;
	}
	public static double sum(double a) {
		return a+5;
	}

	public static void main(String[] args) {

		int a=10;int b=5;
		System.out.println(sum(a,b));
		System.out.println(sum(a));
		double c=3;
		System.out.println(sum(c));

	}

}
