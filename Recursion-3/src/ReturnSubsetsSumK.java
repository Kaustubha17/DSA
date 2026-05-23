
public class ReturnSubsetsSumK {
	
public static int[][] subsetsSumK(int input[], int k,int index,int []elementsSoFar) {
	if(k==0) {
		int arr[][]=new int[1][];
		arr[0]=elementsSoFar;
		return arr;
	}
	if(k<0)
		return null;
	if(index>=input.length)
		return null;
	
	int op1[][]=subsetsSumK(input, k,index+1,elementsSoFar);
	int temp[]=new int[elementsSoFar.length+1];
	for(int i=0;i<elementsSoFar.length;i++)
		temp[i]=elementsSoFar[i];
	
	temp[elementsSoFar.length]=input[index];
	int op2[][]=subsetsSumK(input, k-input[index],index+1,temp);
	int newAns[][]=new int[0][];
	if((op1==null||op1.length==0 )&& op2!=null)
		newAns= op2;
	if((op2==null||op2.length==0 )&& op1!=null) {
		newAns= op1;
	}
	else if(op1!=null&&op2!=null) {
		int p=0;
		int newLength=op1.length+op2.length;
		newAns=new int[newLength][];
		for(int i=0;i<op1.length;i++)
			newAns[i]=op1[i];
		for(int i=0;i<op2.length;i++)
			newAns[i+op1.length]=op2[i];
		
		
	}
	return newAns;

	}

	
public static int[][] subsetsSumK(int input[], int k) {
	int arr[]=new int[0];
	return subsetsSumK(input, k,0,arr);
	

	}
	
	
	public static void main(String[] args) {
int arr[]= {1,2,4,5,6,7,2};
int ans[][]=subsetsSumK(arr, 1);
//int ans[][]= {{1,2},{3,4}};

for(int i=0;i<ans.length;i++) {
	int []temp=ans[i];
	for(int j:temp)
		System.out.print(j);
	
	System.out.println();
}

		
	}

}
