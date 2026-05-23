package fundamentals;
import java.util.Scanner;
public class Exercise1 {
	public static void main(String[] args) {

/*
		Scanner inputToBe=new Scanner(System.in);

		String inputChar=inputToBe.next();
		int toBeChecked=inputChar.charAt(0);

		if(toBeChecked>96&&toBeChecked<124)
		{
			System.out.print(-1);
		}
		else if(toBeChecked>64&&toBeChecked<92){
			System.out.print(1);
		}
		else{
			System.out.print(0);
		}

*/
		   int x=5;
		    int y=5;
		    while((x=5)==y)
		    {
		        System.out.println((x=5)==y);
		        x++;
		        y++;
		    }

	}
}
