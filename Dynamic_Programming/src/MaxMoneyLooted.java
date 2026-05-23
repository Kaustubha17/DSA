
public class MaxMoneyLooted {

	public static int maxMoneyLooted(int[] houses,int index) {
		if(index<0)
			return 0;
		
		int included=maxMoneyLooted(houses, index-2)+houses[index];
		int notIncluded=maxMoneyLooted(houses,index-1);
		
		return Math.max(included, notIncluded);


	}


	public static int maxMoneyLooted(int[] houses) {
		return maxMoneyLooted(houses,houses.length-1);
	}

	public static void main(String[] args) {

		int a[]= {2,3,1000,2000};
		System.out.println(maxMoneyLooted(a));



	}

}
