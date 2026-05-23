import java.util.Scanner;

public class DiamondStar {

	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		int n=s.nextInt();

		int n1=(n+1)/2;
		int n2=n/2;
		int i=1;
//		First half
		while(i<=n1) {
//			Print Spaces
			int spaces=1;
			while(spaces<=(n1-i) ) {
				System.out.print(" ");
				spaces++;
			}
//			Print Stars
			int stars=1;
			while(stars<=(2*i-1)) {
			System.out.print("*");
			stars++;
			}
			i++;
			System.out.println();
		}
		
//		Second half
		i=n2;
		while(i>=0) {
			int spaces=1;
			while(spaces<=(n2-i+1)) {
				System.out.print(" ");
				spaces++;
			}
			int stars=1;
			while(stars<=(2*i-1)) {
				System.out.print("*");
				stars++;
			}
			
			
			
			i--;
			System.out.println();
		}
		
		


	}

}
