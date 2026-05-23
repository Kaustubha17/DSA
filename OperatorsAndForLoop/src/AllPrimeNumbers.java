import java.util.Scanner;

public class AllPrimeNumbers {
	public static boolean isPrime(int n){
		if(n==2)
		{
			return true;
		}
		for(int i=2;i<n;i++) {
			if(n%i==0) {
				return false;
			}
		}



		return true;

	}


	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		int n=s.nextInt();

		for(int i=2;i<=n;i++) {
			if(isPrime(i)) {
				System.out.println(i);
			}
		}


	}}
