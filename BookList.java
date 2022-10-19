/*
* List.java
*
*/
import java.util.Comparator;

// class List definition
public class BookList
{
	private BookInfo firstNode;
	private BookInfo lastNode;
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
        BookInfo t, x, b = new BookInfo(null, null);
        while (firstNode != null){
            t = firstNode;  firstNode = firstNode.nextNode;
            for (x = b; x.nextNode != null; x = x.nextNode)  //b is the first node of the new sorted list
                if (cmp.compare(x.nextNode.data, t.data) > 0) break;
            t.nextNode = x.nextNode; x.nextNode = t;
            if (t.nextNode==null) lastNode = t;
        }
        firstNode = b.nextNode;
    }

	public void insertAtFront( Object insertItem )
	{
		BookInfo node = new BookInfo( insertItem );
		if ( isEmpty() ) // firstNode and lastNode refer to same object
		firstNode = lastNode = node;
		else { // firstNode refers to new node
			node.nextNode = firstNode;
			firstNode = node;
			//you can replace the two previous lines with this line: firstNode = new BookInfo( insertItem, firstNode );
		}
	} // end method insertAtFront

	// insert Object at end of List
	public void insertAtBack( Object insertItem )
	{
		BookInfo node = new BookInfo( insertItem );
		if ( isEmpty() ) // firstNode and lastNode refer to same Object
		firstNode = lastNode = node;
		else { // lastNode's nextNode refers to new node
			lastNode.nextNode = node;
			lastNode = node;
			//you can replace the two previous lines with this line: lastNode = lastNode.nextNode = new BookInfo( insertItem );
		}
	} // end method insertAtBack

	// remove first node from List
	public Object removeFromFront() throws EmptyListException
	{
		if ( isEmpty() ) // throw exception if List is empty
		throw new EmptyListException( name );

		Object removedItem = firstNode.data; // retrieve data being removed

		// update references firstNode and lastNode
		if ( firstNode == lastNode )
		firstNode = lastNode = null;
		else
		firstNode = firstNode.nextNode;

		return removedItem; // return removed node data
	} // end method removeFromFront
	
	BookInfo search(int isbn){}

	// remove last node from List
	public Object removeFromBack() throws EmptyListException
	{
		if ( isEmpty() ) // throw exception if List is empty
		throw new EmptyListException( name );

		Object removedItem = lastNode.data; // retrieve data being removed

		// update references firstNode and lastNode
		if ( firstNode == lastNode )
		firstNode = lastNode = null;
		else // locate new last node
		{
			BookInfo current = firstNode;

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
		BookInfo current = firstNode;

		// while not at end of list, output current node's data
		while ( current != null )
		{
			System.out.printf( "%s ", current.data );
			current = current.nextNode;
		} // end while

		System.out.println( "\n" );
	} // end method print
} // end class List
