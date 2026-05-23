package DP;

public class Divisor_Game {

	public static boolean helper(int n,boolean player) {

		if(n%2==0)
			return player;
		else 
			return !player;

	}


	public static boolean divisorGame(int n) {

		return helper(n, true);  
	}

	public static void main(String[] args) {
		System.out.println(divisorGame(887));


	}

}
