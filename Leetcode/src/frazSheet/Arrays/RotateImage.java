package frazSheet.Arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class RotateImage {
public static void rotate(int[][] matrix) {
    HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();    
	for(int i=0;i<matrix.length;i++) {
		ArrayList<Integer>arr=new ArrayList<>();
		for(int j=0;j<matrix.length;j++) {
			arr.add(matrix[i][j]);	
		}
		map.put(i,arr);
	}
	for(int i=0;i<matrix.length;i++) {
		ArrayList<Integer>arr=map.get(i);
		int col=matrix.length-i-1;
		for(int j=0;j<matrix.length;j++) {
			matrix[j][col]=arr.get(j);
		}
	}
	
	
    }
	public static void main(String[] args) {
		int input[][]= {{1,2,3},{4,5,6},{7,8,9}};
		
		rotate(input);
		
		for(int i[]:input) {
			for(int a:i) {
				System.out.print(a+" ");
			}
			System.out.println();
		}

	}

}
