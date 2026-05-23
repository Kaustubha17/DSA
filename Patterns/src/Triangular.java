import java.util.Scanner;

public class Triangular {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int i=1;
		int k=1;
		while(i<=n) {
			int j=1;
			while(j<=i) {
//				System.out.print(i);
//				System.out.print(j);
				System.out.print(k);
				k++;
				j++;
			}
			i++;
			k=i;
			
			
			System.out.println();
			
		}
		

	}

}
