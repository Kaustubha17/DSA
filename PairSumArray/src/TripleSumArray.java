import java.util.*;
public class TripleSumArray {
	public static int countDuplicates(int[] arr, int i,int j) {
		int count=j-i+1;
		int temp=count;
		int num=1;
		while(temp!=1) {
			num=num*temp;
			temp--;
		}
		temp=count-2;
		int den=1;
		while(temp!=1) {
			den=den*temp;
			temp--;
		}
		int fact=num/(den*2);

		return fact;
	}
	
	
	public static int startDuplicate(int arr[],int i,int j) {
		int count=0;
		int idx=i;
		while(idx<j && arr[idx]==arr[i]) {
			count++;
			idx++;
		}
		
		
		return count;
	}
	
	public static int endDuplicate(int arr[],int i,int j) {
		int count=0;
		int idx=j;
		while(idx>i && arr[idx]==arr[j]) {
			count++;
			idx--;
		}
		
		
		return count;
	}
	
	public static int pairSum(int[] arr, int num,int startIdx,int endIdx) {
		int counter=0;
		int i=startIdx;
		int j=endIdx;
		Arrays.sort(arr);
		while(i<j) {
			if(arr[i]+arr[j]<num) {
				i++;
			}
			else if(arr[i]+arr[j]>num) {
				j--;
			}
			else {
				if(arr[i]==arr[j]) {
					int duplicates=countDuplicates(arr, i,j);
					counter+=duplicates;
					i=j;
				}
				else {
					int getStartDuplicate=startDuplicate(arr,i,j);
					int getEndDuplicate=endDuplicate(arr,i,j);
					int newPairs=getStartDuplicate*getEndDuplicate;
					counter+=newPairs;
					i=i+getStartDuplicate;
					j=j-getEndDuplicate;
				}

			}
		}


		return counter;

	}
	
	
	public static int tripletSum(int[] arr, int num) {
		int counter=0;
		if(arr.length<3)
			return 0;

		Arrays.sort(arr);
		int n=arr.length;
		
		
		
		for(int i=0;i<n-1;i++) {

			int x=arr[i];
			int l=i+1;
			int r=n-1;


			while(l<r) {
				if(x+arr[l]+arr[r]<num) {
					l++;
				}
				else if(x+arr[l]+arr[r]>num) {
					r--;
				}
				else {
					if(x==arr[r])
					{
						int numberOfElements=r-i+1;
						int nC3=(numberOfElements*(numberOfElements-1)*(numberOfElements-2))/6;
						counter+=nC3;
						return counter;
					}
					else {
						counter+=pairSum(arr, num-x, l, r);					}


				}


			}
		}





		return counter;

	}









	public static void main(String[] args) {

		int arr[]= {0, 0, 0, 0, 1, 1, 2, 3, 4, 5, 6, 7, 8, -1};
		System.out.println(tripletSum(arr, 5));

	}

}
