
public class FindPair {

	public static int findUnique(int[] arr){

        int n=arr.length;
        boolean pair=false;
        if(n==1){
            return arr[0];
        }
        
        
        for(int i=0;i<n;i++){
         System.out.println("i: "+i);
         pair=false;
            for(int j=0;j<n;j++){
            	System.out.print(" i: "+i+" arr[i]: " +arr[i]); System.out.print(" j: "+j+" arr[j]: "+arr[j]+" ");
             if(i==j){
                 continue;
             }
                if(arr[i]==arr[j]){
                    pair=true;
                    break;
                }
               
            }
          
            System.out.println();
            if(!pair){
                return arr[i];
            }
           
        }
        
        return -1;
    }
	
	
	public static void main(String[] args) {
	int arr[]= {3,1,4,3,4};
	
	System.out.println(findUnique(arr));
		
		

	}

}
