import java.util.Scanner;

public class HalfDiamondPattern {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int i=1;
		System.out.println("*");
		while(i<=n) {
			int j=1;
			System.out.print("*");
			while(j<=i) {
				System.out.print(j);
				j++;
			}
			j=j-2;
			while(j>0) {
				System.out.print(j);
				j--;
			}
					
			System.out.print("*");

			i++;
			System.out.println();
			
		}
		i=1;
		int n2=n-1;
		while(i<=n2) {
			System.out.print("*");
			int j=1;
			while(j<=(n2-i+1)) {
				System.out.print(j);
				j++;
			}
			j=j-2;
			while(j>0) {
				System.out.print(j);
				j--;
			}
			System.out.print("*");
			i++;
			System.out.println();
		}
		
		
		
		System.out.print("*");	
	}}
