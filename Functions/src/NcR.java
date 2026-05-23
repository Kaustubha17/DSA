import java.util.Scanner;

public class NcR {
public static int factorial(int n) {
	int result=1;
	for(int i=1;i<=n;i++) {
		result*=i;
	}
	
	return result;
	
}
	
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int r=s.nextInt();
		int factN=factorial(n);
		int factR=factorial(r);
		int factNR=factorial(n-r);
		int answer=(factN)/(factR*factNR);
		System.out.println(answer);
		

	}

}
