
public class IncrementDecrement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


//for(int i=7;i!=0;i--)
//{
//    System.out.print(i--);
//}


int i = 1;
while(i < 3) {
    int j = 0;
    while(j < 5) {
        j++;
        if(j == 3) {
            continue;
        }
        System.out.print(j + " ");
    }
    i++;
}


	}

}
