package StackQueue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueWithMin {
	
	Queue<Integer> queue;
	
	Queue<Integer> minValQ;
	
	
	private void init() {
		this.queue = new LinkedList<Integer>();
		this.minValQ = new LinkedList<Integer>();
	}

	public static void main(String[] args) throws IOException {
		QueueWithMin obj = new QueueWithMin();
		obj.init();

		String[] words;
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		
		String line;
		int oprnd;
		boolean found = false;
		for(;;) {
			line = scan.nextLine();
			words = line.split(" ");
			if (line.equals("exit")) {
				break;
			}
			switch(words[0]) {
			case "add" :
				oprnd = Integer.parseInt(words[1]);
				obj.queue.add(oprnd);
				while(obj.minValQ.peek()!=null && obj.minValQ.peek() > oprnd ) {
					obj.minValQ.poll(); //  remove
				}
				obj.minValQ.add(oprnd);
				break;
			case "remove":
				oprnd = obj.queue.poll();
				System.out.println(oprnd);
				found = false;
				if(oprnd == obj.minValQ.peek()) {
					obj.minValQ.poll();
				}
				break;
			case "min":
				System.out.println(obj.minValQ.peek());
			case "exit":
				break;
			
			}

		} 
		scan.close();
		
		
	}
}

