import java.util.Scanner;

public class ZeroesStarsPattern {

	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int i=1;
		
		
		while(i<=n) {
			int j=1;
			int diff=n-i+1;
			int star=i;
			int numberOfStars=3;
			while(j<=(2*n+1)) {
				
				if(j==star && numberOfStars!=0) {
					System.out.print("*");
					star=star+diff;
					numberOfStars--;
				}
				else {
					System.out.print("0");
				}
				j++;
				
				
			}
			
			
			
			i++;
			System.out.println();
		}
		
		
	

}}
