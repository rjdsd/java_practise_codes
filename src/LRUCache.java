import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class LRUCache {

	  class Node {
		    int key;
		    int val;
		    Node prev;
		    Node next;
		  }
		  
		  Hashtable<Integer, Node> pageTable = new Hashtable<Integer, Node>();
		  
		  Node head;
		  Node end;
		  
		  
		  public void add(int key, int val) {
			Node target= null;
		    if (pageTable.containsKey(key)) {
		    	target = pageTable.get(key);
		    	target.val = val;
			    if (target.next != null) {
			    	target.next.prev = target.prev;
			    }
			    if (target.prev != null) {
			    	target.prev.next = target.next;
			    }
		    } else {
		    	target =  new  Node();
		    	target.key = key;
		    	target.val = val;
		    	pageTable.put(key, target);
		    }
		    if (head != null) {
		    	head.prev = target;
		    	target.prev = null;
		    	target.next = head;
		    	head = target;
		    } else {
		    	head = target;
		    	end = target;
		    }
		    	
		   }
		  
		  
		  public int remove(int key) throws Exception {
			if (!pageTable.containsKey(key)) {
				throw  new Exception();
			} 
			else {
				Node target = pageTable.get(key);
			    if (target.next != null) {
			    	target.next.prev = target.prev;
			    }
			    if (target.prev != null) {
			    	target.prev.next = target.next;
			    }
			    if (head.equals(target)) {
			    	head = head.next;
			    }
			    if(end.equals(target)) {
			    	end = end.prev;
			    }
			    pageTable.remove(key);
			    return target.val;
			}
		  }
		  
		  public int get(int key) throws Exception {
				if (!pageTable.containsKey(key)) {
					throw  new Exception();
				} 
				Node target = pageTable.get(key);
			    if (target.next != null) {
			    	target.next.prev = target.prev;
			    }
			    if (target.prev != null) {
			    	target.prev.next = target.next;
			    }
			    if(end!= null && end.equals(target)) {
			    	end = end.prev;
			    }
				if(head != null) {
					target.next = head;
					head.prev = target;
					target.next = head;
					head = target;
				}
				return target.val;
		  }
		  
		  void evict() {
			 Node target = end;
			 pageTable.remove(target.key);
			 end = target.prev;
			 if (end == null) {
				 head = null;
			 }
		  }
		  
		  
		  public static void main (String[] args) throws java.lang.Exception
		  { 
			LRUCache code =  new LRUCache();   
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String input = "";
	        for (;;) {
	        	input = br.readLine();
	        	String [] tokens = input.split(" ");
		           switch(tokens[0]) {      
		           case "add" :
		             if (tokens.length != 3) {
		               break;
		             }
		             try {
		               code.add(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));   
		             }  catch (Exception e) {
		               break;
		             }
		          
		           case "remove" :
		             if (tokens.length != 2) {
		               break;
		             }
		             try {
		              System.out.println(code.remove(Integer.parseInt(tokens[1])));   
		             }  catch (Exception e) {
		               break;
		             }
		           case "evict" :
		             if (tokens.length != 1) {
		               break;
		             }
		             try {
		              code.evict();   
		             }  catch (Exception e) {
		               break;
		             }     
		           case "get" :
		             if (tokens.length != 2) {
		               break;
		             }
		             try {
		              int val = code.get(Integer.parseInt(tokens[1]));
		              System.out.println(val);
		             }  catch (Exception e) {
		               System.out.println("-1");
		               break;
		             }
		           case "exit" :
			             if (tokens.length != 1) {
			               break;
			             }
		           
		           default : break;
		             
		           }      
	        }
	      }

}
