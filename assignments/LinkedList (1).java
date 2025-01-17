class ListEmptyException extends Exception {}
class InvalidPositionException extends Exception {}

public class LinkedList<T> implements List<T> {
	private int numElements;
	private Node<T> head;
	private Node<T> tail;

	public LinkedList() {
		head = null;
		tail = null;
		numElements = 0;
	}

	public void addFront (T val) {
		Node<T> n = new Node<T>(val);
		if (head != null) {
			n.next = head;
		} else {
			tail = n;
		}
		head = n;
		numElements++;
	}

	public void addBack (T val) { 
		Node<T> n = new Node<T>(val);
		if (head == null) {
			head = n;
		} else {
			tail.next = n;
		}
		tail = n;
		numElements++;
	}

	public int size (){
		return numElements;
	}
	
	public void insertAt(int position, T val) throws InvalidPositionException {
		if (position == 0) {
			addFront(val);
		} else if (position == numElements) {
			addBack(val);
		} else {
			Node<T> cur = head;
			for (int i = 0; i < position-1; i++) {
				cur = cur.next;
			}
			// Now cur is pointing the node in the position
			// one before the place we want to insert.
			Node<T> n = new Node<T>(val);
			try{
				n.next = cur.next;
				cur.next = n;
				numElements++;
			}catch (NullPointerException e){
				throw new InvalidPositionException();
			}
			
		}
	}
	
	public T removeFront() throws ListEmptyException {
			if (head == null) {
				return null;
			}
			T toReturn = head.getData();
			if (head.next == null) {
				tail = null;
			}
		
			numElements--;
			head = head.next;
			try{
				return toReturn;
			}catch(NullPointerException e ){
				throw new ListEmptyException();
			}
			
		
		
	}
	
	public T removeBack() throws ListEmptyException {
		if (head == null) {
			return null;
		}
		T toReturn = tail.getData();
		if (head.next == null) {
			head = null;
			tail = null;
		} else {
			Node<T> cur = head;
			while (cur.next != tail) {
				cur = cur.next;
			}
			cur.next = null;
			tail = cur;
		}
		numElements--;
		try{
			return toReturn;
		}catch(NullPointerException e){
			throw new ListEmptyException();
		}
	}

	/* Parameters: nothing
	 * Purpose: create a string representation of list
	 * Returns: (String) the string representation
	 */
	public String toString() {
		if (head == null) {
			return "{}";
		}
		String s = "{"+head.getData().toString();
		Node<T> cur = head.next;
		while (cur != null) {
			s += " " + cur.getData().toString();
			cur = cur.next;
		}
		s += "}";
		return s;
	}
    
}




