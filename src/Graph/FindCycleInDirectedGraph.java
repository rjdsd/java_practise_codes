package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

class DirectedGraphNode {
	int val;
	int reachedFrom;
}

class DirectedGraph {
	HashMap<Integer, ArrayList<Integer>> adjList;
}

public class FindCycleInDirectedGraph {
	
	/*
	 * TestCases
	 * 
	 * 	
	 * 
	    false
	    0 1
	    1 0
  		
  		true
  		0 1 1
  		1 0 1
  		1 1 0
  		
	 	true
	 	0 0 0 1 0
	 	0 0 0 1 1
		0 0 0 1 1
		1 1 1 0 0
		0 1 1 0 0
	 * 
	 * 
	 * 
	 */
	
	
	public boolean findCycle(UndirectedGraph g) {
		Stack<Node> stk = new Stack<Node>();
		boolean[] visited = new boolean[g.adjList.size()]; 
		int i;
		for(i= 0 ; i< g.adjList.size(); i++ ) {
			visited[i] = false;
		}
		for(;;) {
			Node cur = null;
			if(!visited[0]) {
				//  start with node 0
				cur = new Node();
				cur.val = 0;
				visited[cur.val] = true;
			}
			else {
				cur = stk.pop();
				if (visited[cur.val]) {
					return true; // cycle exists
				}
			}
			visited[cur.val] = true;
			for(int child : g.adjList.get(cur.val)) {
				Node node = new Node();
				node.val = child;
				if(!visited[child]) {
					stk.push(node);
				} else {
					return true;
				}
			}
			if (stk.size() == 0) {
				break;
			}
		}
		return false;
	}
	
	private UndirectedGraph makeGraph(int[][] edges) {
		UndirectedGraph g = new UndirectedGraph();
		g.adjList = new HashMap<Integer, ArrayList<Integer>>();
		for(int i=0; i<edges.length; i++) {
			g.adjList.put(i,new ArrayList<Integer>());
			  for(int j=0;j<edges.length; j++) {
				  if(edges[i][j] == 1) {
					  g.adjList.get(i).add(j);  
				  }
			  }
		    }
		return g;
	}
	
	

	public static void main(String[] args) {
		String[] words;
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String line;
		int lineRead = 0;
		int nodeCount = 0;
		int[][] edges = new int[0][0];
		for(;;) {
			line = scan.nextLine();
			lineRead++;
			words = line.split(" ");
			if(lineRead == 1) {
				nodeCount = words.length;	
				edges = new int[nodeCount][nodeCount];
			}		
			for(int j=0; j<nodeCount; j++) {
				edges[lineRead-1][j] = Integer.parseInt(words[j]); 
			}
			if (lineRead == nodeCount) {
				break;
			}
		}
	    
	    FindCycleInDirectedGraph obj = new FindCycleInDirectedGraph();
	    UndirectedGraph g = obj.makeGraph(edges);
	    System.out.println(obj.findCycle(g));
	    scan.close();
	}



}
