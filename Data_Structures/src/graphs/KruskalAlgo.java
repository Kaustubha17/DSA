package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Node implements Comparable<Node>{
	int v1;
	int v2;
	int weight;
	public Node(int v1,int v2,int w ){
		if(v2<v1) {
			int temp=v2;
			v2=v1;
			v1=temp;
		}
		this.v1=v1;
		this.v2=v2;
		this.weight=w;
		
	}
	
	public int compareTo(Node n) {
		return (this.weight-n.weight);
	}
}
public class KruskalAlgo {


	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
//		Take input
		ArrayList<Node>graph=new ArrayList<>();
		for(int i=0;i<E;i++)
		{
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			int w=sc.nextInt();
			
			Node n=new Node(v1,v2,w);
			graph.add(n);
		}
		/*
		for(Node n:graph) {
			System.out.println(n.v1+" "+n.v2+" "+n.weight);
		}
	*/	
		Collections.sort(graph);
		
	/*System.out.println("-------Sorted on weight-------");
		for(Node n:graph) {
			System.out.println(n.v1+" "+n.v2+" "+n.weight);
		}
	*/
		
		
		//Cycle detection using union find algorithm
		int parentArr[]=new int[V];
	
		for(int i=0;i<V;i++)
		parentArr[i]=i;
	
		ArrayList<Node>minimumWeightedPath=new ArrayList<>();
		for(Node n:graph) {
			int v1=n.v1;
			int v2=n.v2;
			int wi=n.weight;
			int p1=parentArr[v1];
			int p2=parentArr[v2];
			while(v1!=p1) {
				v1=parentArr[p1];
				p1=parentArr[v1];
			}
			while(v2!=p2) {
				v2=parentArr[p2];
				p2=parentArr[v2];
			}
			if(p1!=p2) {
				minimumWeightedPath.add(n);
				parentArr[v1]=parentArr[v2];
			}
			
		}
//		System.out.println("------------Ans--------------");
		
		for(Node ans:minimumWeightedPath) {
			System.out.println(ans.v1+" "+ans.v2+" "+ans.weight);
		}
		
	
	
		

}}
