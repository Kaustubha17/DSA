import java.util.Scanner;

public class CheckNumberSequence {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		boolean answer=true;
		boolean switchCase=false;

		int prev=s.nextInt();
		for(int i=1;i<n;i++) {
			int current=s.nextInt();
			if(!switchCase) {

				if(prev<=current) {
					switchCase=true;
				}
				prev=current;
			}
			else {
				if(prev>=current) {
					answer=false;
					break;
				}
				prev=current;
			}




		}
		System.out.print(answer);




	}}
