package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * Implemented using adjacency matrix
 */


public class Graphs {

	public static void dftTraversal(int adjMatrix[][],int currentVertex,boolean []visited) {
		visited[currentVertex]=true;
		System.out.print(currentVertex+" ");
		for(int i=0;i<adjMatrix.length;i++) {
			if(adjMatrix[currentVertex][i]==1 &&visited[i]==false)
			{
				//				i is neighbour of currentVertex
				dftTraversal(adjMatrix,i,visited);
			}
		}
	}

	public static void dftTraversal(int adjMatrix[][]) {
		boolean visited[]=new boolean[adjMatrix.length];

		for(int i=0;i<adjMatrix.length;i++)
			if(!visited[i])
				dftTraversal(adjMatrix, i,visited);
	}


	 public static boolean dfsSearch(int adjMatrix[][],boolean visited[],int currentNode,int targetNode){
	        if(currentNode==targetNode)
	            return true;

	        boolean ans=false;
	        visited[currentNode]=true;
	        for(int i=0;i<adjMatrix.length;i++)
	        {
	            if(adjMatrix[currentNode][i]==1 && visited[i]==false){
	                
	                ans=ans||dfsSearch(adjMatrix,visited,i,targetNode);
	            }
	        }


	        return ans;
	    }
	public static void bftTravarsal(int adjMatrix[][], int current, boolean[] visited) {

		Queue<Integer> pendingVertices = new LinkedList<>(); 
		// visited[0] = true; 
		// visited[nbr] = true;
		pendingVertices.add(current);

		while(! pendingVertices.isEmpty()){
			int currentVertex = pendingVertices.poll(); 
			System.out.print(currentVertex +" "); 
			for(int i = 0; i < adjMatrix.length; i++){ 
				if(adjMatrix[currentVertex][i] == 1 && !visited[i]){
					// i is unvisited neighbor of currentVertex 
					pendingVertices.add(i); 
					visited[i] = true;
				}
			}
		}

	}
	public static void bftTravarsal(int adjMatrix[][]) {
		boolean visited[] = new boolean[adjMatrix. length]; 
		int n=adjMatrix.length;
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				bftTravarsal(adjMatrix, i, visited);
			}
		}
	}
	public static ArrayList<Integer> bfsGetPath(int adjMatrix[][],int s,int e) {
		Queue<Integer> pendingVertices = new LinkedList<>(); 
		HashMap<Integer, Integer> map = new HashMap<>(); 
		boolean visited[] = new boolean[adjMatrix.length]; 
		visited[s] = true; 
		pendingVertices.add(s); 
		map.put(s, -1); 
		boolean pathFound = false;

		while(!pendingVertices.isEmpty()){
		int currentVertex = pendingVertices.poll(); 
		for(int i = 0; i < adjMatrix.length; i++){ 
		if(adjMatrix[currentVertex][i] == 1 && !visited[i]){
		pendingVertices.add(i); 
		visited[i] = true; 
		map.put(i, currentVertex); 
		if(i == e) {
		// Path found 
		pathFound = true; 
		break;
		}
		}
		}
		}
		if(pathFound){
		ArrayList<Integer> path = new ArrayList<>(); 
		int currentVertex = e; 
		while( currentVertex != -1){
		path.add(currentVertex); 
		int parent = map.get(currentVertex); 
		currentVertex = parent;
		}
		return path;
		}else{
		return null;
		}

	}

	public static ArrayList<Integer> getPathDFS(int[][] edges,boolean[] visited,int V1,int V2){
		if(V1==V2)
		{
			ArrayList<Integer> ans=new ArrayList<>();
			visited[V1]=true;
			ans.add(V1);
			return ans;
		}
		visited[V1]=true;
		for(int i=0;i<edges.length;i++)
		{
			if(edges[V1][i]==1 && !visited[i])
			{ 
				ArrayList<Integer> arr=getPathDFS(edges,visited,i,V2); 
				if(arr!=null)
				{
					arr.add(V1);

					return arr;
				}
			}
		}
		return null;
	}
	public static void getPathDFS(int [][]adjMatrix,int startIdx,int endIdx) {
		boolean visited[]=new boolean[adjMatrix.length];
		ArrayList<Integer> ans=getPathDFS(adjMatrix,visited, startIdx, endIdx);
		Arrays.fill(visited, false);
		System.out.println();
		if(ans!=null)
			for(int i:ans) {

				System.out.print(i+" ");
			}
	}

	public static void main(String[]args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int e=s.nextInt();
		int adjMatrix[][]=new int[n][n];

		for(int i=0;i<e;i++) {
			int v1=s.nextInt();
			int v2=s.nextInt();
			adjMatrix[v1][v2]=1;
			adjMatrix[v2][v1]=1;
		}


		for(int i=0;i<n;i++) {
			System.out.print("i:"+i+" ");
			for(int j=0;j<n;j++)
				System.out.print(adjMatrix[i][j]+" ");
			System.out.println();
		}
		//		dftTraversal(adjMatrix);
		//		bftTravarsal(adjMatrix);

//		getPathDFS(adjMatrix, 0, 3);

		ArrayList<Integer>bfsPath=bfsGetPath(adjMatrix, 0, 3);
		for(int i:bfsPath)
			System.out.print(i+" ");

	}

}
