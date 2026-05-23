package frazSheet.Arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class K_diff_pairs  {
	class Pair {
		private int p1;
		private int p2;
		public Pair(int p1, int p2) {
			super();
			if(p1<p2) {
				this.p1 = p1;
				this.p2 = p2;
			}
			else {
				this.p1=p2;
				this.p2=p1;
			}
		}

		@Override
		public String toString() {
			return "(" + p1 + "), (" + p2 + ")";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(p1, p2);
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return p1 == other.p1 && p2 == other.p2;
		}
		private K_diff_pairs getEnclosingInstance() {
			return K_diff_pairs.this;
		}


	}

	public int findPairs(int[] nums, int k) {

		HashMap<Integer, Integer>freq=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			freq.put(nums[i],freq.getOrDefault(nums[i], 0)+1);
		}
		Set<Pair>uniqueSet=new HashSet<>();
		if(k==0) {
			int ans=0;
			Set<Integer>keys=freq.keySet();
			for(int key:keys) {
			
				if(freq.get(key)>1) {
					ans++;
				}
				
			}
			return ans;
		}
		else {
			for(int i=0;i<nums.length;i++) {


				if(freq.containsKey(nums[i]-k)) {
					uniqueSet.add(new Pair(nums[i],nums[i]-k));
				}
				else if(freq.containsKey(nums[i]+k)) {
					uniqueSet.add(new Pair(nums[i],nums[i]+k));
				}

			}
		}
		//	      Collections.sort(uniqueSet);




		return uniqueSet.size();
	}
	public static void main(String[] args) {
		int nums[]= {1,1,1,2,2};
		int k=0;
		System.out.println(new K_diff_pairs().findPairs(nums, k));

	}

}
