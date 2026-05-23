package Weekly_Contest_318;


import java.util.PriorityQueue;


public class Total_Cost_to_Hire_K_Workers {
	public static long totalCost(int[] costs, int k, int candidates) {
		long ans=0;
		   int left = 0, right = costs.length - 1;
		PriorityQueue<Integer>priorityQueue=new PriorityQueue<>((a,b)->(costs[a]-costs[b]!=0?costs[a]-costs[b]:a-b));
		//initializing priority queue 
		for (int i = 0; i < candidates && left <= right; i++) {
	            priorityQueue.add(left++);
	            if (left <= right) priorityQueue.add(right--);
	        }
		while(k>0) {
			int index=priorityQueue.poll();
			if(left<=right&&left<costs.length&&right>=0) {
				if(index<=left) {
					priorityQueue.add(left++);
				}
				else {
					priorityQueue.add(right--);
				}
			}
			ans+=costs[index];
			k--;
			
			
			
		}
		
		return ans;
	}
	public static void main(String[] args) {
		int costs[]= {17,12,10,2,7,2,11,20,8};
		int k=3;
		int candidates=4;
		System.out.println(totalCost(costs,k,candidates ));
		/*
		 * [31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58]
11
2
		 */
	}

}
