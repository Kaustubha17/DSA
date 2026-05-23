import java.util.*;
public class PairSum {

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
	
	public static int pairSum(int[] arr, int num) {
		int counter=0;
		int i=0;
		int j=arr.length-1;
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

	public static void main(String[] args) {
		int arr[]= {0,6,0,0};


		System.out.println(pairSum(arr,6));

	}

}
