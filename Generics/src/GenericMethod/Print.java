package GenericMethod;

public class Print {

	public  static<T extends PrintInterface> void printArray(T arr[]) {
		for(int i=0;i<arr.length;i++) {
			arr[i].print() ;
		}
	}
	
	
	public static void main(String[] args) {
/*		Integer arr[]=new Integer[5];
		for(int i=0;i<5;i++) {
			arr[i]=i+1;
		}
		printArray(arr);
		
		String array[]=new String[5];
		for(int i=0;i<5;i++) {
			array[i]="sbd";
		}
		printArray(array);
	*/
		
		Vehicle[] v=new Vehicle[5];
		for(int i=0;i<5;i++) {
			v[i]=new Vehicle(10*i,10+10*i);
		}
		printArray(v);
		
	}
	
}
