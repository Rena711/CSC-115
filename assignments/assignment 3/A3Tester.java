/*
 * A3Tester
 *
 * A class to test the methods required for Assignment 3
 *
 */
public class A3Tester {
    
	private static int testPassCount = 0;
	private static int testCount = 0;

    public static void main(String[] args) {
		
		/*
		Uncomment each method one at a time, 
		and implement the method in A3LinkedList.java 
		until all tests pass. It is strongly
		recommended that you add additional tests 
		to ensure the correctness of your implementation.
		*/
		
		/* Part 1: */
		testAddFront();
		testAddBack();
		testSizeAndIsEmpty();
		testRemoveFront();
		testRemoveBack();
		
		/* Part 2 */
		testMoveToBack();
		testInsertInto();
		
		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
    }
	
		
	public static void testAddFront() {
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testAddFront");
		
		list1.addFront("A");
		result = list1.frontToBack();
		displayResults(result.equals("{A}"), "testAddFront");
		
		list1.addFront("V");
		list1.addFront("A");
		list1.addFront("J");
		result = list1.frontToBack();
		//System.out.println(result);
		displayResults(result.equals("{JAVA}"), "testAddFront");
		result = list1.backToFront();
		displayResults(result.equals("{AVAJ}"), "testAddFront");
	}
	
	public static void testAddBack() {
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testAddBack");
		
		list1.addBack("F");
		result = list1.frontToBack();
		displayResults(result.equals("{F}"), "testAddBack");
		
		list1.addBack("U");
		list1.addBack("N");
		result = list1.frontToBack();
		displayResults(result.equals("{FUN}"), "testAddBack");
		result = list1.backToFront();
		displayResults(result.equals("{NUF}"), "testAddBack");
	}
	
	public static void testSizeAndIsEmpty() {
		int result = 0;
		A3LinkedList list1 = new A3LinkedList();

		result = list1.size();
		displayResults(result==0, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==true, "testSizeAndIsEmpty");
		
		list1.addFront("C");
		list1.addFront("S");
		list1.addFront("C");
		result = list1.size();
		displayResults(result==3, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty");
		
		list1.addBack("115");
		result = list1.size();
		displayResults(result==4, "testSizeAndIsEmpty");
		
	}
	
	public static void testRemoveFront() {
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		list1.addBack("P");
		list1.addBack("I");
		list1.addBack("N");
		list1.addBack("K");
		result = list1.frontToBack();
		displayResults(result.equals("{PINK}"), "testRemoveFront");
		
		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{INK}"), "testRemoveFront");
		
		/* Write additional tests here to ensure all of your pointers
		   have been updated correctly.
		
		   You should also ensure that your size and isEmpty 
		   methods work with removal as well as addition */
				
	}
	
	public static void testRemoveBack() {
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		list1.addBack("P");
		list1.addBack("I");
		list1.addBack("N");
		list1.addBack("K");
		result = list1.frontToBack();
		displayResults(result.equals("{PINK}"), "testRemoveBack");
		
		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{PIN}"), "testRemoveBack"); 

		list1.removeBack();
		result = list1.backToFront();
		displayResults(result.equals("{IP}"), "testRemoveBack");

		list1.removeBack();
		result = list1.backToFront();
		displayResults(result.equals("{P}"), "testRemoveBack"); 

		list1.removeBack();
		result = list1.backToFront();
		displayResults(result.equals("{}"), "testRemoveBack");
 
	}
	
	public static void testMoveToBack() {
		A3LinkedList list1 = new A3LinkedList();
		
		String result1;
		
		list1.addBack("a");
		list1.addBack("b");
		list1.addBack("c");
		list1.addBack("d");
		list1.addBack("e");
		list1.addBack("f");
		
		list1.moveToBack(2);
		result1 = list1.frontToBack();
		displayResults(result1.equals("{abdefc}"), "moveToBack position 2");
		
		list1.moveToBack(4);
		result1 = list1.frontToBack();
		displayResults(result1.equals("{abdecf}"), "moveToBack position 4");
		
		list1.moveToBack(5);
		result1 = list1.frontToBack();
		displayResults(result1.equals("{abdecf}"), "moveToBack position 4");
		
		list1.moveToBack(0);
		result1 = list1.frontToBack();
		displayResults(result1.equals("{bdecfa}"), "moveToBack position 4");

		list1.moveToBack(90);
		result1 = list1.frontToBack();
		displayResults(result1.equals("{bdecfa}"), "moveToBack position 4");
	}
	
	public static void testInsertInto() {
		A3LinkedList list1 = new A3LinkedList();
		A3LinkedList list2 = new A3LinkedList();
		A3LinkedList list3 = new A3LinkedList();
		
		String result1;
		
		list1.addBack("c");
		list1.addBack("s");
		list1.addBack("y");

		list3.addBack("y");
		
		list1.insertInto("h");
		result1 = list1.frontToBack();
		displayResults(result1.equals("{chsy}"), "insertInto test1");
		
		list1.insertInto("t");
		result1 = list1.frontToBack();
		displayResults(result1.equals("{chsty}"), "insertInto test3");
		
		list1.insertInto("z");
		result1 = list1.frontToBack();
		displayResults(result1.equals("{chstyz}"), "insertInto test5");

		list1.insertInto("a");
		result1 = list1.frontToBack();
		displayResults(result1.equals("{achstyz}"), "insertInto test5");

		
		list2.insertInto("b");
		result1 = list2.frontToBack();
		displayResults(result1.equals("{b}"), "insertInto test5");

		list2.addBack("y");

		
		list2.insertInto("z");
		result1 = list2.frontToBack();
		displayResults(result1.equals("{byz}"), "insertInto test5");

		list2.insertInto("a");
		result1 = list2.frontToBack();
		displayResults(result1.equals("{abyz}"), "insertInto test5");
		
		list3.insertInto("t");
		result1 = list3.frontToBack();
		displayResults(result1.equals("{ty}"), "insertInto test3");
		
	}
	
	public static void displayResults (boolean passed, String testName) {
       /* There is some magic going on here getting the line number
        * Borrowed from:
        * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
        */
        
        testCount++;
        if (passed)
        {
            System.out.println ("Passed test: " + testName);
            testPassCount++;
        }
        else
        {
            System.out.println ("Failed test: " + testName + " at line "
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
	
}
