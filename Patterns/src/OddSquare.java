import java.util.Scanner;

public class OddSquare {

	public static void rotate(int arr[],int rotateIdx) {
	
		
		int firstSection[]=new int[rotateIdx+1];
		int i=0;
		while(i<rotateIdx) {
			firstSection[i]=arr[i];
			i++;
		}
		i=0;
		for(int t=rotateIdx;t<arr.length;t++) {
			arr[i]=arr[t];
			i++;
		}
		int j=0;
		while(i<arr.length) {
			arr[i]=firstSection[j];
			i++;
			j++;
		}
		
	for(int k=0;k<arr.length;k++) {
		System.out.print(arr[k]+" ");
	}
	System.out.println();


	}
	
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int i=1;
		int arr[]=new int[n];
		int t=1;

		
		while(i<=n) {
			arr[i-1]=t;
			t=t+2;
			i++;
		}
	i=0;
	
	int rep=0;
	for(int k=0;k<arr.length;k++) {
		System.out.print(arr[k]+" ");
	}
	System.out.println();
	while(rep<n-1) {

		rotate(arr,1);
		rep++;
	}	
//	rotate(arr,rep);
	

}}
