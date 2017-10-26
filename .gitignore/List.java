

/*////////////////////////////////
 *                              //
 * Name:    Robert Mushkot      //
 * Cruz ID: rmushkot            //
 * List.java                    //
 *                              //
 *                              //
 * ///////////////////////////////
*/





public class List{
	private class Node{
		//Fields
		int data;
		Node next;
		Node prev;
		//Constructor
		Node(int data){
			this.data = data;
			this.next = null;
		}

		Node(){this.data = 0; this.next = null; this.prev = null;}
	
		public String toString(){
			return this.data +"";
		}
	}

	//Fields
	private Node front;
	private Node back;
	private Node cursor;
	

	private int length;
	private int index;

	// Constructor
	List(){ // Creates a new empty list.
		this.front = null;
		this.back = null; 
		this.cursor = null;
		this.length = 0;
	}
	

	// // Access functions


	int length(){ // Returns the number of elements in this List.
		int i = 0;
		Node current = front;

		while(current != null){
			current = current.next;
			i++;
		}

		this.length = i;
		return i; 
	}



	int index(){ // If cursor is defined, returns the index of the cursor element
		    //  otherwise returns -1.
		int i = 0;
		Node current = front;

                while(current != cursor && current != null){

                        current = current.next;
                        i++;

                }

                if(cursor == null){index = -1; return -1;}

		else {index = i;  return i;}
	}
	



	int front(){ // Returns front element. Pre: length()>0

		if(length() >0) return front.data;

		else{
			System.err.println("front method: Error");
			System.exit(1);

		} 

		return -1;	
	}





	int back(){ // Returns back element. Pre: length()>0

		if(length() > 0) return back.data;

		else{
                        System.err.println("back method: Error");
                        System.exit(1);

                }

		return -1;
	}

	


	int get(){ // Returns cursor element. Pre: length()>0, index()>=0

		if(length() > 0 && index()>=0) return cursor.data;

		else{
                        System.err.println("get method: Error");
                        System.exit(1);

                }		

		return -1;
	}


	boolean equals(List L){ // Returns true if and only if this List and L are the same
	//   // integer sequence. The states of the cursors in the two Lists
	//    // are not used in determining equality.
		Node list1 = this.front; 
		Node list2 = L.front;

		while (list1 != null && list2 != null){

            		if (list1.data != list2.data)
                		return false;
 
            		list1 = list1.next;
            		list2 = list2.next;
        	}
 
 	       return (list1 == null && list2 == null);	


	}







	// Manipulation procedures
	

	void clear(){ // Resets this List to its original empty state.
		
		if(length() > 0){ 
		
			front.next = null;
			front = null;
			back.prev = null;
			back = null;
		}

		cursor = null;
	}




	void moveFront(){ // If List is non-empty, places the cursor under the front element,
	//     // otherwise does nothing.
		if(length() > 0) cursor = front;
	}




	void moveBack(){ // If List is non-empty, places the cursor under the back element,
	//      // otherwise does nothing.
		if(length() > 0) cursor = back;
        }





	void movePrev(){ // If cursor is defined and not at front, moves cursor one step toward
	//       // front of this List, if cursor is defined and at front, cursor becomes
	//       // undefined, if cursor is undefined does nothing.
		if(cursor != null && cursor != front)
			cursor = cursor.prev;
		
		else if(cursor == front)
			cursor = null;
	}	


	


	void moveNext(){ // If cursor is defined and not at back, moves cursor one step toward
	//        // back of this List, if cursor is defined and at back, cursor becomes
	//         // undefined, if cursor is undefined does not:
		if(cursor != null && cursor != back)
			cursor = cursor.next;
		
		else if(cursor == back)
			cursor = null;
		
	}




	void prepend(int data){ // Insert new element into this List. If List is non-empty,
	//          // insertion takes place before front element.
		
		Node latest = new Node(data);
		
		if(length() == 0){
			front = latest;
			back = latest;
		}

		else{
			front.prev = latest;
			latest.next = front;
			front = latest;

		}


		if(length()-1 == 0) back = latest;
		
	}




	void append(int data){ // Insert new element into this List. If List is non-empty,
	//           // insertion takes place after back element.
		Node latest = new Node(data);

		if(length() == 0){
			back = latest;
			front = latest;
		}

		else{
			back.next = latest;
			latest.prev = back;
			back = latest;
		}

		if(length() - 1 == 0) front = latest;
		
	}	
		
		
		
	



	void insertBefore(int data){ // Insert new element before cursor.            // Pre: length()>0, index()>=0

		if(this.length() >0 && index() >=0){	

			Node latest = new Node(data);			
			latest.next = cursor;
			
			if(cursor == front){ //cursor is at the front
				latest.prev = null;
				front = latest;
			}
			
			else{
				latest.prev = cursor.prev;
				cursor.prev.next = latest;
			}
			
			cursor.prev = latest;
		}
		
		else{
			System.err.println("InsertBefore has broken");
			System.exit(1);
		}
	}





	void insertAfter(int data){ // Inserts new element after cursor.
	//             // Pre: length()>0, index()>=0             
        	if(this.length() >0&& index()>=0){

			Node latest = new Node(data);
			latest.prev = cursor;


			if(cursor == back){ //cursor is at the back   
				latest.next = null;	
				back = latest;

			}else{

				latest.next = cursor.next;
				cursor.next.prev = latest;

			}

			cursor.next = latest;
		}
	}



	void deleteFront(){ // Deletes the front element. Pre: length()>0
		if(length() >0 && cursor == front) cursor = null;

		if(length() > 0 && front == back) clear();

		if(length() >0){

			front = front.next;
			front.prev = null;

		}	
	}



	void deleteBack(){ // Deletes the back element. Pre: length()>0

		if(length() >0 && cursor == back) cursor = null;     

		if(length() > 0 && front == back) clear();

		if(length() >0){

			back = back.prev;
			back.next = null;

		}
	}		


           
	void delete(){ // Deletes cursor element, making cursor undefined.
	//              // Pre: length()>0, index()>=0
		if(cursor == back) deleteBack();

		if(cursor == front) deleteFront(); 
		


		else if(length() >0 && index() >=0){
			cursor.prev.next = cursor.next;

			cursor.next.prev = cursor.prev;

			cursor = null;

		}
	}



	//Other methods



	public String toString(){ // Overrides Object's toString method. Returns a String
 				// representation of this List consisting of a space
				// separated sequence of integers, with front on left.

		if(length() == 0) return "";

		String out = front.data + "";
		Node current = front.next;

		while(current != null){

			out += " " +  current;

			current = current.next;

		}

		return out;
	}




	List copy(){ // Returns a new List representing the same integer sequence as this
			// List. The cursor in the new list is undefined, regardless of the
			// state of the cursor in this List. This List is unchanged.
		List copy = new List();	
		Node current = front;

                while(current != null){

                        copy.append(current.data);

                        current = current.next;

                }

		return copy;
	}




}
