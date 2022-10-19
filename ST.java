import java.io.*;
class ST {

public ST(){}
private class TreeNode {
int id; // unique id of the node
	String city; //city where the node is located
	Treenode l = null;// pointer to left subtree
	Treenode r = null;// pointer to right subtree
	int N=0;//number of nodes in the subtree starting at THE HEAD TreeNode
	List booklist; // sorted linked list of the books
	// stored in this TreeNode
	public Treenode(int nodeid,String city){
		
		id = nodeid;
		this.city = city;
		
	}
}
private TreeNode head;




void insertWarehouse(Treenode h,int nodeid, String name){
	
	 insertR(h, nodeid,name);  
	
	
}
void insertBookAtWarehouse(int nodeid, int isbn, int copies){}
void removeWarehouse(int nodeid){}
void removeBook(int nodeid, int isbn){}
void searchByWarehouse(int nodeid){}
void searchBookInWarehouse(int nodeid, int isbn){}
void searchBook(int isbn){}
void PrintTree(PrintStream stream){
	
}
public void Print(Treenode h) {
	
	if(h == null){
		return;
	}
	
	Print(h.l);
	System.out.println(h.id);
	Print(h.r);
	
}

private Treenode insertR(Treenode h, int nodeid, String city) {
	if (h == null) return new Treenode(nodeid, city);
	if (Math.random()*(h.N+1) < 1.0) return insertT(h, nodeid, city);
	if (nodeid<h.id) h.l = insertR(h.l, nodeid, city);
	else h.r = insertR(h.r, nodeid, city);
	h.N++; return h;
}
private Treenode insertT(Treenode h, int nodeid, String city) {
if (h == null) return new Treenode(nodeid, city);
if (nodeid < h.id) {
h.l = insertT(h.l, nodeid,city); 
h = rotR(h); } 
else {
h.r = insertT(h.r, nodeid,city);
h = rotL(h); }
return h; 
} 
private Treenode rotR(Treenode h) {
Treenode x = h.l; h.l = x.r; x.r = h; return x; }
private Treenode rotL(Treenode h) {
Treenode x = h.r; h.r = x.l; x.l = h; return x; }




Treenode search(int nodeid) {
	
	return null;
}





}