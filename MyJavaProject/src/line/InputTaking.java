package line;

import java.io.IOException;
import java.util.Scanner;

public class InputTaking {

	public static void main(String[] args) throws IOException {
		String[] words;
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		/*
		String line;
		for(;;) {
			line = scan.nextLine();
			words = line.split(" ");
			if (line.equals("exit")) {
				break;
			}
			switch(words[0]) {
			case "add" : 
				System.out.println("Add Instruction" + Integer.parseInt(words[1]));
				break;
			case "remove":
				System.out.println("Remove Instruction" + Integer.parseInt(words[1]));
				break;
			
			}

		} */
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
	    for(int i=0; i<nodeCount; i++) {
		  for(int j=0;j<nodeCount; j++) {
			  System.out.println(edges[i][j]);
		  }
	    }
		
		
	}
}

