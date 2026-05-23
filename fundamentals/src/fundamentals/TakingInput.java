package fundamentals;

import java.util.Scanner;

public class TakingInput {

	public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	int a=s.nextInt();
	int b=s.nextInt();
	System.out.println(a+b);

	
	String str=s.nextLine();
	System.out.println(str);

	char newChar='a';
	System.out.println('a'+1);
	}
	
}
