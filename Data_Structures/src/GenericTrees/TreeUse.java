package GenericTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {

	public static void printTree(TreeNode<Integer>root) {
		if(root==null)
			return;

		System.out.println(root.data);
		for(int i=0;i<root.children.size();i++) {
			TreeNode<Integer>child=root.children.get(i);
			printTree(child);
		}

	}

	public static void printTreeDetailed(TreeNode<Integer> root){
		//Special case not base case
		if(root==null){
			return ;
		}
		System.out.print(root.data+": ");
		for(int i=0; i<root.children.size(); i++){
			System.out.print(root.children.get(i).data+ ",");
		}
		System.out.println();
		for(int i=0;i<root.children.size();i++){
			TreeNode<Integer> child= root.children.get(i);
			printTreeDetailed(child);
		}
	}

	public static int numberOfNodes(TreeNode<Integer>root) {
		if(root==null)
			return 0;
		int count=1;
		for(int i=0;i<root.children.size();i++) {
			int childCount=numberOfNodes(root.children.get(i));
			count+=childCount;
		}
		return count;
	}

	public static int sumOfAllNode(TreeNode<Integer> root){
		if(root==null)
			return 0;

		int sum=root.data;
		for(int i=0;i<root.children.size();i++) {
			int sumOfChild=sumOfAllNode(root.children.get(i));
			sum+=sumOfChild;
		}
		return sum;

	}

	public static TreeNode<Integer> takeInputLevelWise(){
		Scanner s=new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData=s.nextInt();
		if(rootData==-1)
			return null;

		TreeNode<Integer>rootNode= new TreeNode<Integer>(rootData);

		Queue<TreeNode<Integer>>q=new LinkedList<>();
		q.add(rootNode);
		while(!q.isEmpty()) {
			TreeNode<Integer>parentNode=q.poll();
			System.out.println();

			System.out.println("Enter number of "+parentNode.data + "'s children");
			int numberOfChildren=s.nextInt();
			int i=1;
			while(numberOfChildren>0) {
				System.out.println("Enter data for "+parentNode.data+"'s "+i+" child");
				numberOfChildren--;
				i++;
				int childData=s.nextInt();
				TreeNode<Integer>child=new TreeNode<Integer>(childData);
				q.add(child);
				parentNode.children.add(child);
			}

		}


		return rootNode;

	}

	public static void main(String[] args) {
		/*TreeNode<Integer>root=new TreeNode<Integer>(4);
		TreeNode<Integer>node1=new TreeNode<Integer>(2);
		TreeNode<Integer>node2=new TreeNode<Integer>(3);
		TreeNode<Integer>node3=new TreeNode<Integer>(1);
		TreeNode<Integer>node4=new TreeNode<Integer>(5);
		TreeNode<Integer>node5=new TreeNode<Integer>(6);


		root.children.add(node1);
		root.children.add(node2);
		root.children.add(node3);

		node2.children.add(node4);
		node2.children.add(node5);
		 */

		//		for(TreeNode<Integer>i:root.children) {
		//			System.out.println(i.data);
		//		}

				
		TreeNode<Integer>root=takeInputLevelWise();
		printTreeDetailed(root);
//		System.out.println(numberOfNodes(root));
//		System.out.println(sumOfAllNode(root));
	}
}
