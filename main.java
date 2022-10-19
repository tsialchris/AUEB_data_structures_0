import java.io.*;
import java.util.*;

public class main {
   public static void main(String[] args) {
	   int counter=0;
	   ST tree = new ST();
	   int input=0;
	   Treenode head=new Treenode(1,"athens");
	   while(input !=9){
	   System.out.println("MAIN MENU");
	   System.out.println("1:INSERT A WARHOUSE");
	   System.out.println("2:INSERT A BOOK IN A WARHOUSE");
	   System.out.println("3:REMOVE A WAREHOUSE");
	   System.out.println("4:REMOVE A BOOK IN A WARHOUSE");
	   System.out.println("5:SEARCH WARHOUSE");
	   System.out.println("6:SEARCH A BOOK IN A WAREHOUSE");
	   System.out.println("7:SEARCH A BOOK");
	   System.out.println("8:PRINT ALL THE WARHOUSES");
	   System.out.println("9:EXIT THE PROGRAM");
	   System.out.println("PRESS A NUMBER:");
	   
	   
			Scanner read = new Scanner(System.in);
			input = read.nextInt();
	   while(input>0  || input<8){
			Scanner s0 = new Scanner(System.in);
			input = s0.nextInt();
	   }
	   
	   if (input ==1){
		
	  /* }
	   else{*/
			Scanner s1 = new Scanner(System.in);
			int nodeid = s1.nextInt();
			Scanner s2 = new Scanner(System.in);
			String name = s2.nextLine();
	   
	   tree.insertWarehouse(head,nodeid, name);
	   }
	   
	   
	   tree.Print(head);
	   }
	}
}