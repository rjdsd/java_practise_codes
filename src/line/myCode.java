package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class DirectedGraphNode {
	int val;
}

class DirectedGraph {
	HashMap<Integer, ArrayList<Integer>> adjList;
}

public class myCode {
	
	int count=0;
	
	/*
	 * 
	 * Containing Self loop  will consider as cycle
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
	
	
	public boolean findCycle(DirectedGraph g) {
		Stack<DirectedGraphNode> stk = new Stack<DirectedGraphNode>();
		boolean[] visited = new boolean[g.adjList.size()]; 
		int i;
		for(i= 0 ; i< g.adjList.size(); i++ ) {
			visited[i] = false;
		}
		for(;;) {
			DirectedGraphNode cur = null;
			if(!visited[0]) {
				//  start with node 0
				cur = new DirectedGraphNode();
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
				DirectedGraphNode node = new DirectedGraphNode();
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
	
	
	public boolean checkFromEachNode(DirectedGraph g, int n) {
		boolean flag = false;
		for(int key : g.adjList.keySet()) {
			if(findCycleOfGivenSizeFromASpecificNode(g, key, n )) 
				return true;
		}
		return false;
	}
	
	public boolean findCycleOfGivenSizeFromASpecificNode(DirectedGraph g, int V, int n) {
		int hopCount= 0;
		Stack<DirectedGraphNode> stk = new Stack<DirectedGraphNode>();
		boolean[] visited = new boolean[g.adjList.size()]; 
		int i;
		for(i= 0 ; i< g.adjList.size(); i++ ) {
			visited[i] = false;
		}
		for(;;) {
			DirectedGraphNode cur = null;
			if(!visited[V]) {
				//  start with node V
				cur = new DirectedGraphNode();
				cur.val = 0;
				visited[cur.val] = true;
			}
			else {
				cur = stk.pop();
				if (visited[cur.val]) {
					if (hopCount == n) {
						return true; // cycle exists
					} 
					else {
						continue;
					}
				}
			}
			visited[cur.val] = true;
			hopCount++;
			for(int child : g.adjList.get(cur.val)) {
				DirectedGraphNode node = new DirectedGraphNode();
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
	
	private DirectedGraph makeGraph(int[][] edges) {
		DirectedGraph g = new DirectedGraph();
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
	
	
	  void DFS(int graph[][], boolean marked[],
              int n, int vert, int start, int nodeCount) {
		  // mark the vertex vert as visited
		  marked[vert] = true;
		  // if the path of length (n-1) is found
		  if (n == 0) {
		      // mark vert as un-visited to 
		      // make it usable again
		      marked[vert] = false;       
		      // Check if vertex vert end 
		      // with vertex start
		      if (graph[vert][start] == 1) {
		          count++;
		          return;
		      } else
		          return;
           }
		  // For searching every possible 
		  // path of length (n-1)
		  for (int i = 0; i < nodeCount; i++)
		      if (!marked[i] && graph[vert][i] == 1)
		       
		          // DFS for searching path by
		          // decreasing length by 1
		          DFS(graph, marked, n-1, i, start, nodeCount);
		   
		  // marking vert as unvisited to make it
		  // usable again
		  marked[vert] = false;
		}
	  
	  	// Count cycles of length N in an 
	    // undirected and connected graph.
	    int countCycles(int graph[][], int n, int nodeCount) {
	         
	        // all vertex are marked un-visited
	        // initially.
	        boolean marked[] = new boolean[nodeCount];
	         
	        // Searching for cycle by using 
	        // v-n+1 vertices
	        for (int i = 0; i < nodeCount - (n - 1); i++) {
	            DFS(graph, marked, n-1, i, i, nodeCount);
	             
	            // ith vertex is marked as visited
	            // and will not be visited again
	            marked[i] = true;
	        }
	         
	        return count / 2; 
	    }
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nodeCount =  Integer.parseInt(br.readLine());
		String line;
		int[][] edges = new int[nodeCount][nodeCount];
		for(int i=0 ; i<nodeCount; i++) {
			line = br.readLine();
			for(int j=0; j<nodeCount; j++) {
				edges[i][j] = line.charAt(j)-48;
			}
		}
		int targetLen = Integer.parseInt(br.readLine());
		myCode code = new myCode();
		DirectedGraph graph =  code.makeGraph(edges);
		if(code.findCycle(graph)) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
		br.close();
		System.out.println(code.countCycles(edges, targetLen, nodeCount));
		/*
		for(int i=0; i < nodeCount; i++) {
			for(int j=0; j < nodeCount; j++) {
			System.out.print(edges[i][j] + " ");
			}
			System.out.println();
		} */
		//System.out.println(targetLen);
	    /*
	    FindCycleInDirectedGraph obj = new FindCycleInDirectedGraph();
	    DirectedGraph g = obj.makeGraph(edges);
	    System.out.println(obj.findCycle(g)); */
		
	}



}
