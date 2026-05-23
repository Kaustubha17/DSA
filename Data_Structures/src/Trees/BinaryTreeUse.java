package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {

	public static BinaryTreeNode<Integer> takeInputBetter(boolean isRoot,int parentData,boolean isLeft){
		if(isRoot) {
			System.out.println("Enter root data");

		}
		else {
			if(isLeft)
				System.out.println("Enter left child of "+parentData);
			else
				System.out.println("Enter right child of "+parentData);		
		}

		Scanner s=new Scanner(System.in);
		int rootData=s.nextInt();
		if(rootData==-1) {
			return null;
		}
		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootData);
		BinaryTreeNode<Integer> leftChild=takeInputBetter(false,root.data,true);
		BinaryTreeNode<Integer> rightChild=takeInputBetter(false,root.data,false);
		root.left=leftChild;
		root.right=rightChild;
		return root;

	}

	public static BinaryTreeNode<Integer> takeInput(){
		System.out.println("Enter root data");
		Scanner s=new Scanner(System.in);
		int rootData=s.nextInt();
		if(rootData==-1) {
			return null;
		}
		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootData);
		BinaryTreeNode<Integer> leftChild=takeInput();
		BinaryTreeNode<Integer> rightChild=takeInput();
		root.left=leftChild;
		root.right=rightChild;
		return root;

	}


	public static void printTreeDetailed(BinaryTreeNode<Integer>root) {
		if(root==null)
			return;
		if(root.left!=null &&root.right!=null)
			System.out.println(root.data+":"+" L:"+root.left.data+" R:"+root.right.data);
		else if(root.left!=null &&root.right==null)
			System.out.println(root.data+":"+" L:"+root.left.data);
		else if(root.left==null &&root.right!=null)
			System.out.println(root.data+":"+" R:"+root.right.data);
		else
			System.out.println(root.data+":");

		printTreeDetailed(root.left);
		printTreeDetailed(root.right);


	}

	public static void printTree(BinaryTreeNode<Integer>root) {

		System.out.println(root.data);

		printTree(root.left);
		printTree(root.right);


	}



	public static int numberOfNodes(BinaryTreeNode<Integer> root) {
		if(root==null)
			return 0;



		int leftnodes=numberOfNodes(root.left);
		int rightnodes=numberOfNodes(root.right);

		return leftnodes+rightnodes+1;

	}

	public static int largest(BinaryTreeNode<Integer> root) {
		if(root==null)
			return -1;

		int leftLargest=largest(root.left);
		int rightLargest=largest(root.right);
		return	Math.max(root.data,Math.max(leftLargest, rightLargest));
	}


	public static int heightOfTree(BinaryTreeNode<Integer>root) {
		if(root==null)
			return 0;


		int leftMax=heightOfTree(root.left);
		int rightMax=heightOfTree(root.right);

		return(1+Math.max(leftMax, rightMax));

	}


	public static int numberOfLeaves(BinaryTreeNode<Integer>root) {

		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return 1;

		return numberOfLeaves(root.left)+numberOfLeaves(root.right);
	}


	public static void printAtDepthK(BinaryTreeNode<Integer>root,int k) {
		if(root==null)
			return;

		if(k==0)
		{
			System.out.print(root.data+" ");
			return;
		}
		printAtDepthK(root.left, k-1);
		printAtDepthK(root.right, k-1);
	}


	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root,boolean isRoot) {

		if(root==null)
			return;
		if(!isRoot){
			if(root.left!=null && root.right==null)
				System.out.print(root.left.data+" ");
		}
		else if(root.left==null && root.right!=null) {
			System.out.print(root.right.data+" ");
		}

		printNodesWithoutSibling(root.left,false);
		printNodesWithoutSibling(root.right,false);

	}

	public static BinaryTreeNode<Integer> removeLeafNodes(BinaryTreeNode<Integer> root) {
		if(root==null)
			return null;

		if(root.right==null && root.left==null)
			return null;

		root.left= removeLeafNodes(root.left);
		root.right=removeLeafNodes(root.right);
		return root;

	}

	public static BinaryTreeNode<Integer> mirrorBinaryTreeCorrect(BinaryTreeNode<Integer> root){

		if(root==null)
			return root;

		BinaryTreeNode<Integer> left= mirrorBinaryTreeCorrect(root.left);
		BinaryTreeNode<Integer> right=mirrorBinaryTreeCorrect(root.right);
		root.left=right;
		root.right=left;

		return root;

	}

	public static void mirrorBinaryTreeMySolution(BinaryTreeNode<Integer> root){

		if(root==null)
			return;

		BinaryTreeNode<Integer> toBeRight=root.left;
		BinaryTreeNode<Integer> toBeLeft=root.right;

		root.left=toBeLeft;
		root.right=toBeRight;

		mirrorBinaryTreeMySolution(root.left);
		mirrorBinaryTreeMySolution(root.right);
	}

	public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer>root) {

		if(root==null) {
			BalancedTreeReturn balancedTree=new BalancedTreeReturn(0,true);
			return balancedTree;
		}

		BalancedTreeReturn leftOutput=isBalancedBetter(root.left);
		BalancedTreeReturn rightOutput=isBalancedBetter(root.right);
		boolean isBal=true;
		int height=1+Math.max(leftOutput.height, rightOutput.height);

		if(Math.abs(leftOutput.height-rightOutput.height)>1) {
			isBal=false;

		}
		if(!leftOutput.isBalanced||!rightOutput.isBalanced) {
			isBal=false;
		}
		BalancedTreeReturn balancedTree=new BalancedTreeReturn(height,isBal);
		return balancedTree; 
	}


	public static boolean isBalanced(BinaryTreeNode<Integer> root) {
		//		Code compplexity n^2  in worst case(in linked list kind of structure)
		//		and nlogn if fully balanced
		//		so complexity can be written as n*h where h is the height of tree
		if(root==null)
			return true;

		int leftHeight=heightOfTree(root.left);
		int rightHeight=heightOfTree(root.right);

		if(Math.abs(leftHeight-rightHeight)>1) {
			return false;
		}

		boolean leftBalanced=isBalanced(root.left);
		boolean rightBalanced=isBalanced(root.right);

		return leftBalanced && rightBalanced;
	}


	public static BinaryTreeDiaSolution diameterOfBinaryTreeBetter(BinaryTreeNode<Integer> root){
		if(root==null)
		{
			BinaryTreeDiaSolution ans=new BinaryTreeDiaSolution(0,0);
			return ans;
		}

		BinaryTreeDiaSolution left=diameterOfBinaryTreeBetter(root.left);
		BinaryTreeDiaSolution right=diameterOfBinaryTreeBetter(root.right);

		int h=left.height+right.height+1;
		int ld=left.diameter;
		int rd=right.diameter;
		int dia=Math.max(Math.max(h,ld),rd);

		BinaryTreeDiaSolution ans=new BinaryTreeDiaSolution(h,dia);

		return ans;


	}


	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
		if(root==null)
			return 0;
		int leftHeight=heightOfTree(root.left);
		int rightHeight=heightOfTree(root.right);

		int leftDia=diameterOfBinaryTree(root.left);
		int rightDia=diameterOfBinaryTree(root.right);

		return Math.max((leftHeight+rightHeight+1), Math.max(leftDia, rightDia));


	}

	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		System.out.println("Enter root data");
		Scanner s=new Scanner(System.in);
		int rootData=s.nextInt();

		if(rootData==-1) {
			return null;
		}

		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootData);
		Queue<BinaryTreeNode<Integer>>pendingChildren=new LinkedList<>();
		pendingChildren.add(root);

		while(!pendingChildren.isEmpty()) {
			BinaryTreeNode<Integer>front=pendingChildren.poll();
			System.out.println("Enter left child of "+front.data);
			int left=s.nextInt();
			if(left!=-1) {
				BinaryTreeNode<Integer>leftChild=new BinaryTreeNode<>(left);
				front.left=leftChild;
				pendingChildren.add(leftChild);
			}
			else {
				front.left=null;
			}

			System.out.println("Enter right child of "+front.data);
			int right=s.nextInt();
			if(right!=-1) {
				BinaryTreeNode<Integer>rightChild=new BinaryTreeNode<>(right);
				front.right=rightChild;
				pendingChildren.add(rightChild);
			}
			else {
				front.right=null;
			}

		}
		return root;

	}

	public static void printLevelWise(BinaryTreeNode<Integer> root) {

		if(root==null)
			return;

		Queue<BinaryTreeNode<Integer>>q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			BinaryTreeNode<Integer>polled=q.poll();
			if(polled.left==null && polled.right!=null)
				System.out.println(polled.data+":"+"L:-1"+",R:"+polled.right.data);
			else if(polled.right==null && polled.left!=null)
				System.out.println(polled.data+":"+"L:"+polled.left.data+",R:-1");
			else if(polled.right==null && polled.left==null)
				System.out.println(polled.data+":"+"L:-1"+",R:-1");
			else
				System.out.println(polled.data+":"+"L:"+polled.left.data+",R:"+polled.right.data);
			if(polled.left!=null)
				q.add(polled.left);
			if(polled.right!=null)
				q.add(polled.right);
		}


	}

	static int preIndex = 0;
	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder,int startIdx,int endIdx) {		
		if(startIdx>endIdx)
			return null;
		//	    preIndex keeps track of root node from preOrder array
		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(preOrder[preIndex++]);

		if(startIdx==endIdx)
			return root;

		//		Finding index of root elem in inorder
		int rootIdxInInOrder=0;

		for(int i=0;i<=endIdx;i++) {
			if(root.data==inOrder[i]) {
				rootIdxInInOrder=i;
				break;
			}
		}


		root.left=buildTree(preOrder, inOrder, startIdx, rootIdxInInOrder-1);
		root.right=buildTree(preOrder, inOrder, rootIdxInInOrder+1, endIdx);


		return root;

	}

	public static BinaryTreeNode<Integer> buildTreeAlternate(int[] preOrder, int[] inOrder,int siPre,int eiPre,int siIn,int eiIn) {
		if(siPre>eiPre)
			return null;
		int rootData=preOrder[siPre];

		BinaryTreeNode<Integer>root=new BinaryTreeNode<>(rootData);
		if(siPre==eiPre)
			return root;

		/*
		 * 		PreOrder is in the following format:	root -->left -->right
		 * 		InOrder is in the following format:		left -->root -->right
		 * 	
		 * 		So easily we have:- 
		 * 					siPreLeft=siPre+1
		 * 					siInLeft=siIn
		 * 					eiPreRight=eiPre
		 * 					eiInRight=eiIn
		 * 
		 * 		For finding siInRight and eiInLeft we need to find position
		 * 		of root in inorder 
		 * 
		 * siPreRight,,eiPreLeft
		 */

		int rootIndex=-1;
		for(int i=siIn;i<=eiIn;i++) {
			if(inOrder[i]==rootData) {
				rootIndex=i;
				break;
			}
		}

		int siPreLeft=siPre+1;
		int siInLeft=siIn;
		int siInRight=rootIndex+1;
		int eiInLeft=rootIndex-1;
		int eiPreRight=eiPre;
		int eiInRight=eiIn;



		int leftSubtreeLength=eiInLeft- siInLeft+1;
		int eiPreLeft=siPreLeft+leftSubtreeLength-1;
		int siPreRight=eiPreLeft+1;


		BinaryTreeNode<Integer>left=buildTreeAlternate(preOrder, inOrder, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
		BinaryTreeNode<Integer>right=buildTreeAlternate(preOrder, inOrder, siPreRight, eiPreRight, siInRight, eiInRight);
		root.left=left;
		root.right=right;
		return root;

	}

	public static BinaryTreeNode<Integer> buildTreePostOrder(int[] postOrder, int[] inOrder,int siPost,int eiPost,int siIn,int eiIn) {
		if(siPost<eiPost)
			return null;
		int rootData=postOrder[siPost];

		BinaryTreeNode<Integer>root=new BinaryTreeNode<>(rootData);
		if(siPost==eiPost)
			return root;

		/*
		 * 		PostOrder is in the following format:	left -->right -->root
		 * 		InOrder is in the following format:		left -->root -->right
		 * 	
		 * 		So easily we have:- 
		 * 					siPostRight=siPost+1
		 * 					siInLeft=siIn
		 * 					eiPostLeft=eiPost
		 * 					eiInRight=eiIn
		 * 
		 * 		For finding siInRight and eiInLeft we need to find position
		 * 		of root in inorder 
		 * 
		 * siPreRight,,eiPreLeft
		 */

		int rootIndex=-1;
		for(int i=siIn;i<=eiIn;i++) {
			if(inOrder[i]==rootData) {
				rootIndex=i;
				break;
			}
		} 



		int siPostRight=siPost-1;


		int siInRight=rootIndex+1;
		int eiInRight=eiIn;


		int eiPostLeft=eiPost;

		int siInLeft=siIn;
		int eiInLeft=rootIndex-1;

		int rightSubtreeLength=eiInRight-siInRight+1;
		int eiPostRight=siPostRight-rightSubtreeLength+1;
		int siPostLeft=eiPostRight-1;

		BinaryTreeNode<Integer>left=buildTreePostOrder( postOrder,  inOrder, siPostLeft, eiPostLeft, siInLeft, eiInLeft);
		BinaryTreeNode<Integer>right=buildTreePostOrder( postOrder,  inOrder, siPostRight, eiPostRight, siInRight, eiInRight);

		root.left=left;
		root.right=right;
		return root;
	}

	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {

		if(root==null)
			return;


		BinaryTreeNode<Integer> newLeft=new BinaryTreeNode<Integer>(root.data);
		newLeft.left=root.left;
		root.left=newLeft;
		insertDuplicateNode(newLeft.left);
		insertDuplicateNode(root.right);
	}



	public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {

		if(root==null) {
			return new Pair<Integer,Integer>(Integer.MAX_VALUE,Integer.MIN_VALUE);
		}
		//		System.out.println(root.data);
		Pair<Integer,Integer> leftPair=getMinAndMax(root.left);
		Pair<Integer,Integer> rightPair=getMinAndMax(root.right);

		int max=Math.max(Math.max(leftPair.maximum, rightPair.maximum),root.data);
		int min=Math.min(Math.min(leftPair.minimum, rightPair.minimum),root.data);

		Pair<Integer,Integer>newPair=new Pair(min,max);
		return newPair;
	}



	
	
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k,String s) {
		if(root==null) {
			
			return;
		}
		s+=root.data+" ";
		if(root.left==null && root.right==null && k-root.data==0)
			System.out.println(s);
		
		rootToLeafPathsSumToK(root.left, k-root.data,s);
		
		rootToLeafPathsSumToK(root.right, k-root.data,s);
		}
	
	
	public static BinaryTreeNode<Integer>insert(BinaryTreeNode<Integer>node,int x){
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

	public static void main(String[] args) {
		/*
		 * BinaryTreeNode<Integer> root=new BinaryTreeNode<>(1); BinaryTreeNode<Integer>
		 * rootLeft=new BinaryTreeNode<>(2); BinaryTreeNode<Integer> rootRight=new
		 * BinaryTreeNode<>(3); root.left=rootLeft; root.right=rootRight;
		 * 
		 * BinaryTreeNode<Integer> twoRight=new BinaryTreeNode<>(4);
		 * BinaryTreeNode<Integer> threeLeft=new BinaryTreeNode<>(5);
		 * 
		 * rootLeft.right=twoRight; rootRight.left=threeLeft;
		 */


		//		BinaryTreeNode<Integer> root=takeInputBetter(true,0,false);
		//		System.out.println(numberOfNodes(root));
		//				System.out.println(heightOfTree(root));
		//				System.out.println(numberOfLeaves(root));
		//				printAtDepthK(root, 2);
		//		printTreeDetailed(root);
		//		root=removeLeafNodes(root);



		//		BinaryTreeNode<Integer>root=takeInputLevelWise();
		int []a= {1,2,4,5,3,6,7};
		int []b= {4,2,5,1,6,3,7};

		BinaryTreeNode<Integer>root=buildTree(a,b,0,a.length-1);

		System.out.println();
		//		printTreeDetailed(root);
		printLevelWise(root);
		//		System.out.println();
//		System.out.println(getMinAndMax(root).maximum+" "+getMinAndMax(root).minimum);
		insert(root, 10);
		
		System.out.println("****************************");
		printLevelWise(root);
		System.out.println("****************************");
		insert(root,8);
		
		printLevelWise(root);
		System.out.println("****************************");
		insert(root,0);
		
		printLevelWise(root);
		
		
		//		mirrorBinaryTreeCorrect(root);
		//		System.out.println(isBalanced(root));
		//		System.out.println(isBalancedBetter(root).isBalanced);
		//		System.out.println(diameterOfBinaryTreeBetter(root).diameter);
	}

}
