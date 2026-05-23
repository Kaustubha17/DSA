package frazSheet.Arrays;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class ContainerWithMostWater {
	public static int maxArea(int[] height) {
		int leftToRight[]=new int[height.length];
		int rightToLeft[]=new int[height.length];
		int i=0;
		int j=height.length-1;
		leftToRight[i]=height[i];
		rightToLeft[j]=height[j];
		i++;
		j--;

		for(;i<height.length;i++) {
			
			leftToRight[i]=Math.max(height[i], leftToRight[i-1]);
		}

		for(;j>=0;j--) {
			rightToLeft[j]=Math.max(height[j],rightToLeft[j+1]);
		}

		int ans=0;
		i=0;
		j=height.length-1;

		while(i<height.length && j>=0 && i<j ) {
			ans=Math.max(ans, (Math.min(leftToRight[i],rightToLeft[j])*(j-i)));
		
		if(leftToRight[i]>rightToLeft[j]) {
			j--;
		}
		else
			i++;
		}
		return ans;
	}
	public static void main(String[] args) {
		int heights[]= {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(heights));
	}

}
