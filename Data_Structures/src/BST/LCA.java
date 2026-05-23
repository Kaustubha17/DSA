package BST;

import java.util.ArrayList;
import java.util.Collections;

import Trees.BinaryTreeNode;

public class LCA {

	public static boolean checkIfNodeIsPresent(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node) {
		if (root == null)
			return false;
		if (root.data == node.data)
			return true;

		return checkIfNodeIsPresent(root.left, node) || checkIfNodeIsPresent(root.right, node);
	}

	public static ArrayList<Integer> pathToA = new ArrayList<>();
	public static ArrayList<Integer> pathToB = new ArrayList<>();

	public static void pathToNodeA(BinaryTreeNode<Integer> root, int a) {
		if (root == null)
			return;

		pathToA.add(root.data);
		if (root.data == a)
			return;
		else if (root.data > a)
			pathToNodeA(root.left, a);
		else
			pathToNodeA(root.right, a);
	}

	public static void pathToNodeB(BinaryTreeNode<Integer> root, int b) {
		if (root == null)
			return;

		pathToB.add(root.data);
		if (root.data == b)
			return;
		else if (root.data > b)
			pathToNodeB(root.left, b);
		else
			pathToNodeB(root.right, b);

	}
	
	

	public static int getLCAUtil(BinaryTreeNode<Integer> root, int a, int b) {
		if (root.data == a || root.data == b)
			return root.data;
		else {
			pathToNodeA(root, a);
			pathToNodeB(root, b);

			int aSize = pathToA.size() - 1;
			int bSize = pathToB.size() - 1;

			Collections.sort(pathToA);
			Collections.sort(pathToB);
			
			  System.out.println("A:"); 
			  for (int i : pathToA) 
				  System.out.print(i + " ");
			 System.out.println();
			 System.out.println("B:");
			  
			 for(int i:pathToB)
				 System.out.print(i+" ");
			 System.out.println();



			int i=0; int j=0; 
			while(i<aSize&&j<bSize){ 
				if(pathToA.get(i)==pathToB.get(j))
					break; 
				else if(pathToA.get(i)>pathToB.get(j)) 
					j++; 
				else 
					i++;

			} return pathToA.get(i);




		}

	}
	
	public static boolean bIsChildOfA(BinaryTreeNode<Integer> root,int a,int b){
        if(root==null)
            return false;
        
        
        if(root.data==a)
            return checkIfNodeIsPresent(root,new BinaryTreeNode<Integer>(b));
        
        if(root.data<a)
           return bIsChildOfA(root.right,a,b);
        else
            return bIsChildOfA(root.left,a,b);
        
    }

	public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
		if (root == null)
			return -1;
		boolean aIsPresent = checkIfNodeIsPresent(root, new BinaryTreeNode<Integer>(a));
		boolean bIsPresent = checkIfNodeIsPresent(root, new BinaryTreeNode<Integer>(b));

		if (!aIsPresent && !bIsPresent)
			return -1;
		else if (!aIsPresent)
			return b;
		else if (!bIsPresent)
			return a;
		else {
			System.out.println(bIsChildOfA(root, a, b));
			
			return getLCAUtil(root, a, b);
		}

	}

}
