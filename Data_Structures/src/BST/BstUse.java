package BST;

import Trees.BinaryTreeNode;
import java.util.*;
public class BstUse {
	static ArrayList<Integer>a=new ArrayList<>();
	
	
	public static class LinkedListNode<T> { 

		T data; LinkedListNode<T> next;
		public LinkedListNode(T data)
		{ 
			this.data = data;
		} 

	}

	public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {

		if(root==null)
			return false;

		if(k==root.data)
			return true;

		if(k>root.data){
			return searchInBST(root.right,k);

		}

		return searchInBST(root.left,k);

	}

	public static void printBetweenK1AndK2(BinaryTreeNode<Integer>root,int k1,int k2) {
		if(root==null)
			return;

		if(root.data>k2) {
			printBetweenK1AndK2(root.left, k1, k2);
		}
		if(root.data<k1) {
			printBetweenK1AndK2(root.right, k1, k2);
		}
		if(root.data<=k2 && root.data>=k1) {
			printBetweenK1AndK2(root.left, k1, k2);
			System.out.println(root.data);
			printBetweenK1AndK2(root.right, k1, k2);
		}

	}

	public static boolean isBSTUtil(BinaryTreeNode<Integer>root,int max,int min) {
		if(root==null)
			return true;
		if(root.data>max)
			return false;
		if(root.data<min)
			return false;

		return isBSTUtil(root.left,root.data-1,min)&&isBSTUtil(root.right, max, root.data+1);

	}

	public static boolean isBST(BinaryTreeNode<Integer> root) {
		return isBSTUtil(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
	}


	public static BinaryTreeNode<Integer>SortedArrayToBSTUtil(int arr[],int si,int ei){
		if(si<0||ei>=arr.length||si>ei)
			return null;
		if(si==ei)
			return new BinaryTreeNode<>(arr[si]);

		int mid=(ei-si)/2;
		//		System.out.println("si: "+si+" mid: "+mid+" ei: "+ei);
		BinaryTreeNode<Integer>root=new BinaryTreeNode<>(arr[si+mid]);
		root.left=SortedArrayToBSTUtil(arr, si,si+mid-1);
		root.right=SortedArrayToBSTUtil(arr, si+mid+1,ei);

		return root;
	}

	public static BinaryTreeNode<Integer> SortedArrayToBST(int []arr,int n) {
		BinaryTreeNode<Integer>root=SortedArrayToBSTUtil(arr, 0,arr.length-1);

		return root;
	}

	public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
		if(root==null)
			return null;

		LinkedListNode<Integer>node=new LinkedListNode<>(root.data);
		if(root.left==null&&root.right==null){
			return node;
		}

		LinkedListNode<Integer> leftTail=constructLinkedList(root.left);
		if(leftTail!=null){

			LinkedListNode<Integer>temp=leftTail;

			while(temp.next!=null){
				temp=temp.next;
			}

			temp.next=node;

		}


		LinkedListNode<Integer> rightHead=constructLinkedList(root.right);

		node.next=rightHead;


		if(leftTail!=null)
			return leftTail;
		else 
			return node;

	}

	public static int printPath(BinaryTreeNode<Integer>root,int target) {
		if(root==null)
			return -1;
		
		if(root.data==target) {
			return 0;
		}
		
		
		int a=printPath(root.left, target);
		int b=printPath(root.right, target);
		if(a==0) {
			System.out.println(root.data);
			return 0;
		}
		else if(b==0) {
			System.out.println(root.data);
			return 0;
		}
		else {
			return -1;
		}
	}
	
	public static ArrayList<Integer> nodeToRootPath(BinaryTreeNode<Integer>root,int x){
		if(root==null)
			return null;
		
		if(root.data==x) {
			ArrayList<Integer>ans=new ArrayList<>();
			 ans.add(x);
			 return ans;
		}
		
		
		ArrayList<Integer>leftArray=nodeToRootPath(root.left, x);
		
		if(leftArray!=null) {
			leftArray.add(root.data);
			return leftArray;
		}
		
		
		ArrayList<Integer>rightArray=nodeToRootPath(root.right, x);
		if(rightArray!=null) {
			rightArray.add(root.data);
			return rightArray;
		}
		return null;
		
	}
	
	
	public static ArrayList<Integer> getPathBST(BinaryTreeNode<Integer> root, int data){
		if(root==null)
            return null;
        
        if(root.data==data){
        ArrayList<Integer>ans=new ArrayList<Integer>();
            ans.add(data);
            return ans;
        }
        
        if(data<root.data){
            ArrayList<Integer>leftArray=getPathBST(root.left,data);
            if(leftArray!=null){
                leftArray.add(root.data);
                return leftArray;
                }
            
        }
        else{
            ArrayList<Integer>rightArray=getPathBST(root.right,data);
            if(rightArray!=null){
                rightArray.add(root.data);
                return rightArray;
        }
        }
            
        return null;
        
        
        
	}
	
	
	public static void main(String[] args) {
		/*
		 * int arr[]= {11,12,13,14,15};
		 * 
		 * BinaryTreeNode<Integer>root=SortedArrayToBST(arr, 5);
		 * ArrayList<Integer>path=nodeToRootPath(root, 10); if(path!=null) for(int
		 * i:path) System.out.println(i+" ");
		 */
//		System.out.println(LCA.getLCA(root, 14, 15));
//		printPath(root,9);

		
		BST b=new BST();
		b.insert(5);
		b.insert(2);
		b.insert(7);
		b.insert(1);
		b.insert(3);
		b.insert(6);
		b.insert(8);
		
		
		b.printTree();
		
		System.out.println(b.isPresent(5));
		b.deleteData(5);
		System.out.println(b.isPresent(5));
		
		b.printTree();
		
		
		
	}

}
