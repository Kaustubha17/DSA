package frazSheet.Arrays;

import java.util.Stack;
class heightAndIndex{
	private	int height;
	private	int index;
	public heightAndIndex(int height, int index) {
		super();
		this.height = height;
		this.index = index;
	}
	public int getHeight() {
		return height;
	}
	public int getIndex() {
		return index;
	}

}

public class Largest_Rectangle_In_Histogram {

	public int largestRectangleArea(int[] heights) {
		int ans=Integer.MIN_VALUE;

		Stack<heightAndIndex>s=new Stack<>();
		for(int i=0;i<heights.length;i++) {
//			print_stack(s,i);
			if(s.isEmpty()) {
				s.add(new heightAndIndex(heights[i],i));
			}
			else{
				if(heights[i]>=s.peek().getHeight()) {
					s.add(new heightAndIndex(heights[i],i));
				}
				else {

					heightAndIndex heightAndIndexVar=s.peek();
					int height=heightAndIndexVar.getHeight();
					int index=heightAndIndexVar.getIndex();
					while(!s.isEmpty()&&s.peek().getHeight()>heights[i]) {
						heightAndIndexVar=s.peek();
						height=heightAndIndexVar.getHeight();
						index=heightAndIndexVar.getIndex();
						int tempArea=height*(i-index);
						ans=Math.max(ans, tempArea);
						s.pop();
					}

					s.add(new heightAndIndex(heights[i],index));

				}
			}
		}
		int n=heights.length;
		while(!s.isEmpty()) {
			heightAndIndex newComb=s.pop();
			int height=newComb.getHeight();
			int index=newComb.getIndex();
			int temp=height*(n-index);
			ans=Math.max(ans, temp);
		}
		

//		System.out.println("/////////////////");
//		print_stack(s,10);
		return ans;
	}
	public void print_stack(Stack<heightAndIndex>s,int t) {
		System.out.print("index: "+t+"|");
		for(heightAndIndex hAndI:s) {
			System.out.print(hAndI.getHeight()+" and index is "+hAndI.getIndex()+" ");

		}
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[]= {2};

		System.out.println(new Largest_Rectangle_In_Histogram().largestRectangleArea(arr));

	}

}
