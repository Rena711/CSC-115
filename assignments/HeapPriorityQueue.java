/*
* HeapPriorityQueue.java
*
* An implementation of a minimum PriorityQueue using a heap.
* based on the implementation in "Data Structures and Algorithms
* in Java", by Goodrich and intamassia
*
* inthis implementation will throw a Runtime, HeapEmptyException
*	if the heap is empty and removeMin is called.
*
* inthis implementation will throw a Runtime, HeapFullException
*	if the heap is full and insert is called.
*
*/
public class HeapPriorityQueue implements PriorityQueue {

	protected final static int DEFAULT_SIZE = 10000;
	
	protected int[] storage;
	protected int currentSize;
	int rootIndex; // should be 0 or 1 depending on implementation

	/*
	 * Constructor that initializes the array to hold DEFAULT_SIZE elements
	 */
	public HeapPriorityQueue() {
		this.storage = new int[DEFAULT_SIZE + 1];
		this.currentSize = 0;
		this.rootIndex = 1;
		
		// if using a 1-based implementation, remember to allocate an 
		// extra space in the array since index 0 is not used. 
	}
	
	/*
	 * Constructor that initializes the array to hold size elements
	 */
	public HeapPriorityQueue(int size) {
		this.storage = new int[size + 1];
		this.currentSize = 0;
		this.rootIndex = 1;
		
		// if using a 1-based implementation, remember to allocate an 
		// extra space in the array since index 0 is not used. 
	}

	public void swap(int parentIndex, int index){
		int temp = storage[parentIndex];
		storage[parentIndex] = storage[index];
		storage[index] = temp;

	}

	public void insert (int element) throws HeapFullException {
		if (isFull()){
			throw new HeapFullException();
		}
		storage[currentSize + 1] = element; 
		bubbleUp(currentSize + 1);
		currentSize++;
				
			
		// When inserting the first element, choose whether to use 
		// a 0-based on 1-based implementation. Whatever you choose,
		// make sure your implementation for the rest of the program
		// is consistent with this choice.		
    }
	
	private void bubbleUp(int index) {
		int parentIndex = index / 2;
		while(storage[parentIndex] > storage[index]){
			swap(parentIndex, index);
			index = parentIndex;
			parentIndex = parentIndex/2;
		}
	}
			
	public int removeMin() throws HeapEmptyException {
		if (isEmpty()){
			throw new HeapEmptyException();
		}else{
			int temp = storage[rootIndex];
			if (currentSize == 1){
				currentSize--;
				return temp;
			}else{
				storage[rootIndex] = storage[currentSize]; 
				bubbleDown(rootIndex);
				currentSize--;
				return temp; 
			}
		}
		
	}
	
	private void bubbleDown(int index) {
		int leftChild = 2 * index;
		int rightChild = (2 * index) + 1;
		while((leftChild < currentSize && storage[index] > storage[leftChild])|| ( rightChild < currentSize && storage[index] > storage[rightChild])){
			if (storage[leftChild] < storage[rightChild]){
				swap(index, leftChild);
				index = leftChild;
			}else{
				swap(index, rightChild);
				index = rightChild;
			}
			leftChild = 2 * index;
			rightChild = (2 * index) + 1;
			
			
	
		}
			
	}

	public boolean isEmpty(){
		return currentSize==0; // so it compiles
	}
	
	public boolean isFull() {
		if (currentSize == storage.length - 1){
			return true;
		}
		return false;
	}
	
	public int size () {
		return currentSize;
	}

	public String toString() {
		String s = "";
		String sep = "";
		if (rootIndex == 0) {
			for (int i = 0; i < currentSize; i++) {
				s += sep + storage[i];
				sep = " ";				
			}
		} else if (rootIndex == 1) {
			for(int i=1; i<=currentSize; i++) {
				s += sep + storage[i];
				sep = " ";
			}
		}
		return s;
	}
}
