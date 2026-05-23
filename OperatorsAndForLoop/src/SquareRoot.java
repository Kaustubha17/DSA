import java.util.Scanner;
public class SquareRoot {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int answer=0;
		for(int i=1;i<=n;i++){
			int squared=i*i;
			if(squared==n){
				System.out.print(i);
				break;
			}
			else if(squared<n){
				answer=i;
			}
			if(squared>n){
				System.out.print(answer);
				break;
			}
		}
	

	

}}
