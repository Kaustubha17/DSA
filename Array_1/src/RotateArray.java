
public class RotateArray {
	  public static void rotate(int[] arr, int d) {
	        if(d==0||d==arr.length){
	            for(int i:arr){
	                System.out.print(i+" ");
	            }
	        }
	        else{
	            for(int i=d;i<arr.length;i++){
	                System.out.print(arr[i]+" ");
	            } 
	            for(int i=0;i<d;i++){
	                System.out.print(arr[i]+" ");
	            }
	        }

	    }
	public static void main(String[] args) {
int arr[]= {1, 3, 6, 11, 12, 17};
rotate(arr,4);

	}

}
