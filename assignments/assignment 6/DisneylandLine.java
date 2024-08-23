/*
 * DisneylandLine
 * 
 * A class to simulate a lineup of people waiting to enter
 * Disneyland. Some people come alone and go to the back of 
 * the line, others bribe their way to a certain position. 
 * Sometimes someone buys a bunch of tickets at once so 
 * multiple people can be removed from the line and enter
 * Disneyland at the same time.
 */
public class DisneylandLine {
	List<Person> list;
	//Do not add any other fields

	public DisneylandLine() {
		//Do not change the constructor in any way
		list = new LinkedList<Person>();
	}
	
	/*
	 * Purpose: add a person to line to enter Disneyland
	 * Parameter: Person p - the person to add
	 * Returns void - nothing
	 */
	public void enterLine(Person p) {
		list.addBack(p);
	}
	
	/*
	 * Purpose: handle the first person in line
	            (allow them to purchase their ticket
				 and enter into Disneyland)
	 * Parameter: none
	 * Returns: Person - the person who gets their ticket
	 *                   and is no longer waiting in line
	 *                   or null if no one can be removed
	 *                   from the line
	 */
	public Person handleOne() throws ListEmptyException{
		/*Node cur = list.head;
		while(cur.next()!=null){
			cur=cur.next()
		}
*/
		if (list.size()>0){
			Person one = list.removeFront();
			return one;
		}else{
			return null;
		}
		
	}
	/*
	 * Purpose: handle a whole group of people waiting in line
	 *          (allow a group to buy a number of tickets 
	 *           and all enter Disneyland)
	 * Parameters: int num - the number of people
	 * Returns int - the number of people who were successfully
	 *               able to be removed from the line
	 */
	public int handleMultiple(int num) throws ListEmptyException{
		int count = 0;
		if (list.size() > 1){
			for(int i = 0; i < num; i++){
				Person mult = list.removeFront();
				count++;
			}
		}
		return count;
		 
	}
	
	/*
	 * Purpose: accept a bribe to put someone into a specific
	 *          position in the line to get into Disneyland
	 * Parameters: Person p - the person entering the line
	 *             int pos - the position they are trying to get to
	 * Returns boolean - true if person added to line, false otherwise
	 */
	public boolean premiumEntry(Person p, int pos) throws InvalidPositionException{
		try{
			list.insertAt(pos, p);
			return true; 
		}catch (InvalidPositionException e){
			return false;
		}
		
	}
	
	/*
	 * Purpose: gets the number of people in line
	 * Parameters: none
	 * Returns: int - number of people in line
	 */
	public int peopleInLine() {
		return list.size();
	}
}
	
	