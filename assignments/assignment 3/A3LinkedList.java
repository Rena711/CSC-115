// Name: Serena Sing
// Student number: V01018312

public class A3LinkedList implements A3List {
	private A3Node head;
	private A3Node tail;
	private int length;
	
	public A3LinkedList() {
		head = null;
		tail = null;
		length = 0;
	}
	
	public void addFront(String s) {
		A3Node n = new A3Node(s);
		if (isEmpty()){
			tail = n;
		}else{
			head.prev = n;
			n.next = head;
		}
		head = n;
		length++;
	}

	public void addBack(String s) {
		A3Node n = new A3Node(s);
		if (isEmpty()){
			head = n;
		}else{
			tail.next = n;
			n.prev = tail;
		}
		tail = n;
		length++;
	}
	
	public int size() {
		return length;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public void removeFront() {
		if (length != 0){
			A3Node temp = head;
			if (head == tail){
				tail = null;
			}else{
				head.next.prev = null;
			}
			head = head.next;
			temp.prev = null;
			length--;
		}
		
	}
	
	public void removeBack() {
		if (length != 0){
			A3Node temp = tail;
			if (head == tail){
				head = null;
			}else{
				tail.prev.next = null;
			}
			tail = tail.prev;
			temp.next = null;
			length--;
		}
		
	}
	
	public void moveToBack(int pos) {
		
		
		if (pos > 0 && pos < length && length > 1){
			int count = 0;
			A3Node cur = head;
			while (cur != null){
				cur = cur.next;
				count ++;
				if (count == pos){
					break;
				}
				
			}
			addBack(cur.getData());
			length--;
			cur.next.prev = cur.prev;
			cur.prev.next = cur.next;
			cur = null;
		
		}

		if (pos == 0){
			addBack(head.getData());
			removeFront();
		}

		
	}
	

	public void insertInto(String s) {
		
		A3Node n = new A3Node(s);
		if (isEmpty()){
			addFront(s);
		}else if (head.comesBefore(n)){
			A3Node cur = head;
			while (cur.next.comesBefore(n)){
				cur = cur.next;
				if (cur.next == null){
					break;
				}
			}
			//System.out.println(cur);
			if (cur.next == null){
				n.next = cur.next;
				n.prev = cur;
				addBack(n.getData());
			}else{
				n.next = cur.next;
				n.prev = cur;
				cur.next.prev = n;
				cur.next = n;
				length++;
			}
			
		}else{
			addFront(s);
		}
		
	}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from front to back
	 * Parameters: none
	 * Returns: nothing
	 */
	public String frontToBack() {
		String result = "{";
		A3Node cur = head;
		while (cur != null) {
			result += cur.getData();
			cur = cur.next;
		}
		result += "}";
		return result;
	}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from back to front
	 * Parameters: none
	 * Returns: nothing
	 */
	public String backToFront() {
		String result = "{";
		A3Node cur = tail;
		while (cur != null) {
			result += cur.getData();
			cur = cur.prev;
		}
		result += "}";
		System.out.println(result);
		return result;
	}
}
	