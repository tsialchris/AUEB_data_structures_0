
//The book class with get and set isbn methods
class BookInfo  implements  Comparable<BookInfo> 
{
	public int isbn;
	private int copies;
	public BookInfo next;
	
	BookInfo( int isbn )
	{
		this( isbn, null );
	} 
	
	BookInfo( int isbn, BookInfo node )
	{
		this.isbn = isbn;
		next = node;
	}

	int getCopies() {
		return copies;
	}
	void setCopies(int copies) {
		this.copies = copies;
	}
	
	public int compareTo(BookInfo other) {
        return Integer.compare(this.isbn, other.isbn);
    }

} 