
public class PrintFactorial {

	public static void printFactorial(int n,int productSoFar) {
		if(n==0)
		{
			System.out.println(productSoFar);
			return;
		}
		productSoFar=n*productSoFar;
		printFactorial(n-1, productSoFar);
	}

	public static void main(String[] args) {
		printFactorial(6, 1);

	}

}
