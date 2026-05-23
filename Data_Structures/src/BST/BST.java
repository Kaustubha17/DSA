package BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Trees.BinaryTreeNode;

public class BST {

	private BinaryTreeNode<Integer>root;
	private int size;

	private static boolean isPresentHelper(BinaryTreeNode<Integer>node,int x) {

		if(node==null)
			return false;

		if(node.data==x)
			return true;

		if(node.data<x) {
			return isPresentHelper(node.right,x);
		}
		else {
			return isPresentHelper(node.left,x);
		}
	}

	public boolean isPresent(int x) {

		return isPresentHelper(root,x);
	}

	private static BinaryTreeNode<Integer>insert(BinaryTreeNode<Integer>node,int x){
		if(node==null) {
	
			BinaryTreeNode<Integer>newRoot=new BinaryTreeNode<>(x);
			return newRoot;
		}
		if(x>=node.data) {
			node.right= insert(node.right, x);
			return node;
		}
		else {
			BinaryTreeNode<Integer>leftNode=insert(node.left, x);
			node.left=leftNode;
			return node;

		}
	}


	public void insert(int x) {
		ArrayList<Integer>a=new ArrayList<>();
				
		root=insert(root,x);
		size++;
	}

	private static int getMin(BinaryTreeNode<Integer> root) {
//used in delete function
		if(root==null) {
			return Integer.MAX_VALUE;
		}
		//		System.out.println(root.data);
		int  leftPair=getMin(root.left);
		int rightPair=getMin(root.right);

		int min=Math.min(Math.min(leftPair, rightPair),root.data);
		

		
		return min;
	}
	
	private static BSTDeleteReturn deleteHelper(BinaryTreeNode<Integer>node,int x) {
		if(node==null)
			return new BSTDeleteReturn(null,false);

		if(node.data<x) {
			BSTDeleteReturn outputRight=deleteHelper(node.right, x);
			node.right=outputRight.root;
			outputRight.root=node;
			return outputRight;
		}
		if(node.data>x) {
			BSTDeleteReturn outputLeft=deleteHelper(node.left, x);
			node.left=outputLeft.root;
			outputLeft.root=node;
			return outputLeft;
		}

		else {
//			node does'nt have children
			if(node.left==null &&node.right==null) {
				return new BSTDeleteReturn(null, true);
			}
//			node has only one children on one side
			
//			only left children
			if(node.left!=null&&node.right==null) {
				return new BSTDeleteReturn(node.left, true);
			}
//			only right children
			if(node.left==null&&node.right!=null) {
				return new BSTDeleteReturn(node.right, true);
			}
//			node has children on both side
			
			else {
				int rightMin=getMin(node.right);
//				moving right data up
				node.data=rightMin;
//				
				BSTDeleteReturn outputRight=deleteHelper(node.right, rightMin);
				node.right=outputRight.root;
				return new BSTDeleteReturn(node, true);
			}
			
		}

		
	}

	public boolean deleteData(int x) {
		
	/*		
	 * 	1.root is null return null
	 * 
	 * 	2.root.data<x 
	 * 			newRight=deleteNode(root.right)
	 * 			root.right=newRight
	 * 	
	 * 3.root.data>x 
	 * 			newLeft=deleteNode(root.left)
	 * 			root.left=newRight
	 * 
	 * 4.root.data==x
	 * 			Three situations in this case
	 * 				1.When no children
	 *  				return null;
	 * 				2 a.When only left children are present
	 * 					then return root.left
	 * 				2 b.When only right children are present
	 * 					return root.right
	 * 				3.When both left and right children are present
	 * 					getMinimum from root.right
	 * 						replace it with root.data
	 * 							delete the the minimum data node recursively
	 * 								get the right new node from above step and attach it to the root
	 * 
	 * 
	 * 				
	 * 	
	 */
	
		
		BSTDeleteReturn output= deleteHelper(root, x);
		root=output.root;
		if(output.deleted) {
			size--;
		}
		return output.deleted;


	}

	public int size() {
		return size;
	}

	private static void printTreeHelper(BinaryTreeNode<Integer>node) {
		if(node==null)
			return;
		if(node.left!=null &&node.right!=null)
			System.out.println(node.data+":"+" L:"+node.left.data+" R:"+node.right.data);
		else if(node.left!=null &&node.right==null)
			System.out.println(node.data+":"+" L:"+node.left.data);
		else if(node.left==null &&node.right!=null)
			System.out.println(node.data+":"+" R:"+node.right.data);
		else
			System.out.println(node.data+":");

		printTreeHelper(node.left);
		printTreeHelper(node.right);

	}

	public void printTree() {
		printTreeHelper(root);
	}
}
