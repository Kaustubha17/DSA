package frazSheet.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumAreaOfAPieceACake {
	class Pair{
		private int horizontalCoord;
		private int VerticalCoord;
		public int getHorizontalCoord() {
			return horizontalCoord;
		}

		public Pair(int horizontalCoord, int verticalCoord) {
			super();
			this.horizontalCoord = horizontalCoord;
			VerticalCoord = verticalCoord;
		}

		public void setHorizontalCoord(int horizontalCoord) {
			this.horizontalCoord = horizontalCoord;
		}
		public int getVerticalCoord() {
			return VerticalCoord;
		}
		public void setVerticalCoord(int verticalCoord) {
			VerticalCoord = verticalCoord;
		}

		@Override
		public String toString() {
			return "(" + horizontalCoord + ", " + VerticalCoord + ")";
		}

	}


	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);
		int horizonatalCutsWithBorder[]=new int[horizontalCuts.length+2];
		int verticalCutsWithBorder[]=new int[verticalCuts.length+2];


		horizonatalCutsWithBorder[0]=0;
		verticalCutsWithBorder[0]=0;

		for(int i=0;i<horizontalCuts.length;i++) {
			horizonatalCutsWithBorder[i+1]=horizontalCuts[i];
		}
		for(int i=0;i<verticalCuts.length;i++) {
			verticalCutsWithBorder[i+1]=verticalCuts[i];
		}
		horizonatalCutsWithBorder[horizonatalCutsWithBorder.length-1]=h;
		verticalCutsWithBorder[verticalCutsWithBorder.length-1]=w;




		ArrayList<ArrayList<Pair>>cakeMatrix=new ArrayList<>();
		for(int i=0;i<horizonatalCutsWithBorder.length;i++) {
			ArrayList<Pair>horizontalCoord=new ArrayList<>();
			for(int j=0;j<verticalCutsWithBorder.length;j++) {
				Pair newCord=new Pair(horizonatalCutsWithBorder[i],verticalCutsWithBorder[j]);
				horizontalCoord.add(newCord);
			}
			cakeMatrix.add(horizontalCoord);
		}


		for(int i=0;i<horizonatalCutsWithBorder.length;i++) { for(int
				j=0;j<verticalCutsWithBorder.length;j++) {
			System.out.print(cakeMatrix.get(i).get(j)); } System.out.println(); }

		System.out.println();



		long maxArea=Long.MIN_VALUE;

		for(int i=0;i<horizonatalCutsWithBorder.length-1;i++) {
			for(int j=0;j<verticalCutsWithBorder.length-1;j++) {
				Pair starting= cakeMatrix.get(i).get(j);
				Pair endingDown=cakeMatrix.get(i+1).get(j);
				Pair endingRight=cakeMatrix.get(i).get(j+1);

				//				System.out.println(starting.getHorizontalCoord());


				int horizontalDist=endingDown.getHorizontalCoord()- starting.getHorizontalCoord();
				int verticalDist=endingRight.getVerticalCoord()-starting.getVerticalCoord();
//				System.out.println((long)((long)horizontalDist*(long)verticalDist)%( 1_000_000_007));
				long partialAns=((long)((long)horizontalDist*(long)verticalDist));

				maxArea=Math.max(maxArea, partialAns);
			}
		}


		//		return maxArea%((int)Math.pow(10, 9)+7);
		return (int)(maxArea%( 1_000_000_007));

	}

	public static void main(String[] args) {
		int h=1000000000;
		int w=1000000000;
		int hC[]= {2};
		int vC[]= {2};
		/*
		 * 1000000000
1000000000
[2]
[2]
		 */

		System.out.println(new MaximumAreaOfAPieceACake().maxArea(h, w, hC, vC));


	}

}
