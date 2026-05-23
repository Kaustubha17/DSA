import java.util.Scanner;
import java.lang.Math;
public class Armstrong {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int number=n;
		int numberOfDigits=0;
		while(number!=0) {
			number=number/10;
			numberOfDigits++;
			
		}
		number=n;
		int answer=0;
		int i=0;
		while(number!=0) {
		int placeValue=number%10;
		int faceValue=(int)Math.pow(placeValue, numberOfDigits);
		answer+=faceValue;
		number=number/10;
		i++;
			
		}
		if(answer==n) {
			System.out.print(true);
		}
		else {
			System.out.print(false);
		}
	}

}
