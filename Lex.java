
/*////////////////////////////////
 *				//
 * Name:    Robert Mushkot      //
 * Cruz ID: rmushkot		//
 * Assignment Lex.java		//
 * 				//
 *				//
 * ///////////////////////////////
*/


import java.io.*;
import java.util.Scanner;
   
class Lex{
   public static void main(String[] args) throws IOException{
	Scanner in1 = null;
	PrintWriter out = null;
	String line = null;
	int lineNumber = 0;
	int i = 0;
	

	if(args.length < 2){
		System.err.println("Usage:Lex infile outfile");
		System.exit(1);
	}
      
	
	in1 = new Scanner(new File(args[0]));
	Scanner in2 = new Scanner(new File(args[0]));
	out = new PrintWriter(new FileWriter(args[1]));

	
	while(in1.hasNextLine()){// counts number of lines in the input file.
		lineNumber++;
		in1.nextLine();
	}
	

	String[] words = new String[lineNumber];//creates the array of words from the input file.


	
	while(in2.hasNextLine()){ // adds the lines from the input file to an  array.
		words[i] = in2.nextLine();
		i++;
	}

	List list = new List();
	list.append(0);

	//Method for indirect sorting. This method is based on the insertion sort algorith.
	for(int j = 1; j < words.length; j++){
		list.moveFront();
		System.out.println("Test " + j);

		while (words[j].compareTo(words[list.get()]) > 0){ // while the word does not come before the next word
			if(list.length() == 1) list.append(j); 
			if(list.length()  == list.index() +1  ) list.append(j); // if the end of the list then append the word index
			list.moveNext();
		}
	 

		if(words[j].compareTo(words[list.get()]) < 0)
			list.insertBefore(j);
	
	}
	
	list.moveFront();
	while(list.index()>=0){ // traverses through the sorted list and adds each string to the out file
		int x = list.get();
		out.println(words[x]);
		list.moveNext();
	}

	in1.close();
	in2.close();
	out.close();

   }
}
	
