
public class CoinTower {
	
	
	
	
	public static String findWinner(int n, int x, int y) {
		 boolean[] dp = new boolean[n + 1];
	      
	       for(int i=0;i<=n;i++)
	    	   dp[i]=false;
	     
	        // Initial values
	        dp[0] = false;
	        dp[1] = true;
	      
	        // Computing other values.
	        for (int i = 2; i <= n; i++) {
	      
	            // If A losses any of i-1 or i-x
	            // or i-y game then he will
	            // definitely win game i
	            if (i - 1 >= 0 && dp[i - 1] == false)
	                dp[i] = true;
	            else if (i - x >= 0 && dp[i - x] == false)
	                dp[i] = true;
	            else if (i - y >= 0 && dp[i - y] == false)
	                dp[i] = true;
	      
	            // Else A loses game.
	            else
	                dp[i] = false;
	        }
	      
	        // If dp[n] is true then A will
	        // game otherwise  he losses
	        if(dp[n])
	        	return "Beerus";
	        
	        return "Whis";
	}

	public static boolean findWinnerRec(int noOfCoins, int a, int b)
	{

	    // If noOfCoins = 0, then return false, since we don't have any coins.
	    if (noOfCoins == 0)
	    {
	        return false;
	    }

	    boolean ans = false;

	    // Trying all three options.
	    if (noOfCoins >= a && !findWinnerRec(noOfCoins - a, a, b))
	    {
	        ans = true;
	    }

	    if (noOfCoins >= b && !findWinnerRec(noOfCoins - b, a, b))
	    {
	        ans = true;
	    }

	    if (noOfCoins >= 1 && !findWinnerRec(noOfCoins - 1, a, b))
	    {
	        ans = true;
	    }

	    // Return the ans.
	    return ans;
	}
	
	public static void main(String[] args) {
		if(findWinnerRec(1000,2,3))
	System.out.println("Hello");

	}

}
