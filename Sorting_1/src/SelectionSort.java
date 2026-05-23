
public class SelectionSort {
public static void selectionSort(int[] arr) {
    	
        int n=arr.length;
        int i=0;
        while(i<n-1){
            
            int minIdx=i;
            int j=i+1;
            while(j<n){
                if(arr[minIdx]>arr[j]){
                    minIdx=j;
                }
                j++;
            }
            int temp=arr[i];
            arr[i]=arr[minIdx];
            arr[minIdx]=temp;
            i++;
        }
        
        
    }   
	public static void main(String[] args) {
		int arr[]= {1,22,3,5,6,7};
		selectionSort(arr);
		for(int i:arr) {
			System.out.println(i);
		}
}

}
