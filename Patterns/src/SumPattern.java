import java.util.Scanner;

public class SumPattern {

	public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	int n=s.nextInt();
	int i=1;

	while(i<=n) {
		int j=2;
		int sum=1;
		if(i==1) {
			System.out.print("1=1");	
		}
		else {
			System.out.print("1");
		while(j<=i) {
			
			System.out.print("+"+j);
			sum=sum+j;
			j++;
		}
		System.out.print("="+sum);
		}
		
		
		
		
		i++;
		System.out.println();
	}
	
	
	}

}
