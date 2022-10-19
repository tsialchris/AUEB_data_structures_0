/*
* The linked list of the books
*
*/
import java.util.Comparator;

// class List definition
public class List
{
	private ListNode firstNode;
	private ListNode lastNode;
	private String name; // string like "list" used in printing
       protected Comparator cmp;	

	// constructor creates empty List with "listName" as the name
	public List()
	{
              this("list", new DefaultComparator());
	} // end List no-argument constructor

	// constructor creates an empty List with a name
	public List( String listName, Comparator cmp)
	{
		name = listName;
		firstNode = lastNode = null;
              this.cmp = cmp;		
	} // end List one-argument constructor

    public void sort(){
        ListNode t, x, b = new ListNode(null, null);
        while (firstNode != null){
            t = firstNode;  firstNode = firstNode.nextNode;
            for (x = b; x.nextNode != null; x = x.nextNode)  //b is the first node of the new sorted list
                if (cmp.compare(x.nextNode.data, t.data) > 0) break;
            t.nextNode = x.nextNode; x.nextNode = t;
            if (t.nextNode==null) lastNode = t;
        }
        firstNode = b.nextNode;
    }

	public void insertAtFront( BookInfo insertItem )
	{
		ListNode node = new ListNode( insertItem );
		if ( isEmpty() ) // firstNode and lastNode refer to same BookInfo
		firstNode = lastNode = node;
		else { // firstNode refers to new node
			node.nextNode = firstNode;
			firstNode = node;
			//you can replace the two previous lines with this line: firstNode = new ListNode( insertItem, firstNode );
		}
	} // end method insertAtFront

	// insert BookInfo at end of List
	public void insertAtBack( BookInfo insertItem )
	{
		ListNode node = new ListNode( insertItem );
		if ( isEmpty() ) // firstNode and lastNode refer to same BookInfo
		firstNode = lastNode = node;
		else { // lastNode's nextNode refers to new node
			lastNode.nextNode = node;
			lastNode = node;
			//you can replace the two previous lines with this line: lastNode = lastNode.nextNode = new ListNode( insertItem );
		}
	} // end method insertAtBack

	// remove first node from List
	public BookInfo removeFromFront() throws EmptyListException
	{
		if ( isEmpty() ) // throw exception if List is empty
		throw new EmptyListException( name );

		BookInfo removedItem = firstNode.data; // retrieve data being removed

		// update references firstNode and lastNode
		if ( firstNode == lastNode )
		firstNode = lastNode = null;
		else
		firstNode = firstNode.nextNode;

		return removedItem; // return removed node data
	} // end method removeFromFront
	
	ListNode search(int isbn){
		return null;
	}

	// remove last node from List
	public BookInfo removeFromBack() throws EmptyListException
	{
		if ( isEmpty() ) // throw exception if List is empty
		throw new EmptyListException( name );

		BookInfo removedItem = lastNode.data; // retrieve data being removed

		// update references firstNode and lastNode
		if ( firstNode == lastNode )
		firstNode = lastNode = null;
		else // locate new last node
		{
			ListNode current = firstNode;

			// loop while current node does not refer to lastNode
			while ( current.nextNode != lastNode )
			current = current.nextNode;

			lastNode = current; // current is new lastNode
			current.nextNode = null;
		} // end else

		return removedItem; // return removed node data
	} // end method removeFromBack

	// determine whether list is empty
	public boolean isEmpty()
	{
		return firstNode == null; // return true if List is empty
	} // end method isEmpty

	// output List contents
	public void print()
	{
		if ( isEmpty() )
		{
			System.out.printf( "Empty %s\n", name );
			return;
		} // end if

		System.out.printf( "The %s is: ", name );
		ListNode current = firstNode;

		// while not at end of list, output current node's data
		while ( current != null )
		{
			System.out.printf( "%s ", current.data );
			current = current.nextNode;
		} // end while

		System.out.println( "\n" );
	} // end method print
} // end class List
