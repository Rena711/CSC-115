public class A4Stack<T> implements Stack<T> {
	
	private A4Node<T> head;
	private A4Node<T> tail;
	private int length;

	public A4Stack() {
		head = null;
		tail = null;
		length = 0;
	}
	
	public void push(T value) {
		A4Node n = new A4Node(value);
		if (isEmpty()){
			head = n;
			tail = n;
		}else{
			n.next = head;
			head = n;
		}
		length++;
	}
	
	public T pop() {
		if (isEmpty()){
			return null;
		}else{
			T temp = head.getData();
			head = head.next;
			length--;
			return temp;
		}
		
				
	}
	
	public void popAll() {
		if (!isEmpty()){
			head.next = null;
			head = null;
			tail = null;
			length = 0;
		}
		
	}
	
	public boolean isEmpty() {
		return length == 0;	
	}
	
	public T peek() {
		if (isEmpty()){
			return null;
		}else{
			return tail.getData();
		} 	
	}
	
	/* The methods below have been completed for you.
	   Do not edit them in any way */

	public String toString() {
		String result = "{";
		String separator = "";
		
		A4Node<T> cur = head;
		while (cur != null) {
			result += separator + cur.getData().toString();
			separator = ", ";
			cur = cur.next;
		}
	
		result += "}";
		return result;
	}
	
	public String getWords() {
		return getWordsRec(head);
	}
	
	public String getWordsRec(A4Node<T> cur) {
		if (cur == null) {
			return "";
		} else if (cur.next == null) {
			return cur.getData().toString();
		}else {
			return getWordsRec(cur.next) + " " + cur.getData().toString();
		}
	}
}