
public class PrintMinInArray {

	public static void printMin(int arr[],int index,int minSoFar) {
		if(index==arr.length) {
			System.out.println(minSoFar);
			return;
		}
		minSoFar=Math.min(arr[index], minSoFar);
		printMin(arr, index+1, minSoFar);
	}
	
	public static void main(String[] args) {
int arr[]= {1,2,3,-1,34};
printMin(arr, 0,Integer.MAX_VALUE);
	}

}
