package lib;
//CREATED  BY  MEHUL, ANISH & AYUSH	//

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

public class library {
	
	int IssueBook_id[]=new int[100];
	 int Book_id[]=new int[100];
    String Book_name[]= new String[100];
    String Book_type[]= new String[100];
    String Book_subject[]= new String[100];
    String Issue_date[]=new String[100];
    int n;
    static Date x = null;
	static Date y=null;
    int Book_quantity[]=new int[100];
	private Scanner l;
	private Scanner a;
     
	//FUNCTION FOR ADDING A BOOK//
	
	public void addbook(){
    	 
    	 System.out.println("NUMBER OF BOOK YOU WANT TO ENTER-");
    	 Scanner sc=new Scanner(System.in);
    	 n=sc.nextInt();
    	 for(int i=0;i<n;i++){
    	 System.out.println("enter book id-");
    	 Book_id[i]= sc.nextInt();
    	 System.out.println("\nenter book name-"); 
    	 sc.nextLine();
    	 Book_name[i]= sc.nextLine();
    	 System.out.println("\nenter book type-");
    	 Book_type[i]= sc.nextLine();
    	 System.out.println("\nenter the number of copies-");
    	 Book_quantity[i]= sc.nextInt();
    	 sc.nextLine();
    	 System.out.println("\nenter book subject-");
    	 Book_subject[i]= sc.nextLine();
         System.out.println("\nBOOK INSERTED SUCESSFULLY!!");
    	 }
     }
	
	// FUNCTION TO DISPLAY AVIALBLE BOOKS//
	
      public void display(){
    	 System.out.println("BOOKS AVAILABLE ARE-");
    	 for(int i=0;i<n;i++){
    	 System.out.println("\nBOOK_ID- "+Book_id[i]);
    	 System.out.println("BOOK_NAME-"+Book_name[i]);
    	 System.out.println("BOOK_TYPE- "+Book_type[i]);
    	 System.out.println("BOOK_quantity- "+Book_quantity[i]);
    	 System.out.println("BOOK_subject- "+Book_subject[i]);
     }}
      
      // FUNCTION TO SEARCH BOOK //
      
       public void search() throws Exception{
    	   
        System.out.println("\nenter the book_name to search ");
        Scanner in= new Scanner(System.in);
        int count=0;
        String d;
        String search= in.nextLine();
         for(int i=0;i<n;i++){
         if( search.equalsIgnoreCase(Book_name[i])){
          System.out.println("AVAILABLE");
          System.out.println("\nDO YOU WANT TO ISSUE?");
          d=in.next();
           if(d.equalsIgnoreCase("yes"))
        	   issue();
         count++;
         break;
         }
         }
          if(count==0){
        	 System.out.println("NOT AVAILABLE");
         }
        	 
         }
        	 
      // FUNCTION FOR ISSUEING A BOOK//
       
         public Date issue() throws ParseException{ 
    	   SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
        	l = new Scanner(System.in);
        	System.out.println("enter issue date-");
        	String startdate= l.next();
        	
        	 Date dateBefore = myFormat.parse(startdate);
        	System.out.println("Enter the no of books you want to issue");
        	int var=l.nextInt();
        	
        	for(int i=0;i<var;i++)
        	{System.out.println("Enter the book id you want to issue");
        		IssueBook_id[i]=l.nextInt();
        		if(IssueBook_id[i]==Book_id[i])
        			System.out.println("Book is Issued");
        		else
        			System.out.println("Book not Found");
        	}
        	
        	return dateBefore;
        	
        }
         
         // FUNCTION FOR SUBMITTING A BOOK//
         
       public void submission() throws ParseException{
    	   SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
    	   a = new Scanner(System.in);
    	   System.out.println("enter Submission date-");
       	String enddate = a.next();
       Date dateAfter= myFormat.parse(enddate);
    	   System.out.println("Enter the no of books you have to return");
    	  int value=a.nextInt();
    	  int count=0;
    	  for(int i=0;i<value;i++){
    	      System.out.println("Enter the book id");
    	      int v1=a.nextInt();
    		  if(v1==(Book_id[i]))
    			  { 
    			  System.out.println("BOOK NAME-"+Book_name[i]);
    			  count++;}
    			  else
    				  {System.out.println("Match Not Found");}
    		 
    		  v1=0;
    			  
    	  }
    	   check(x,dateAfter);
    	  System.out.println(count+" Book have been returned");     	  
    	        
    	 
       	
       }
       
       // FUNCTION FOR CHECKING LATE SUBMISSION//
       
    public void check(Date a,Date b){
	   long difference = b.getTime() - a.getTime();
	   double daysBetween = (difference / (1000*60*60*24));
	   if(daysBetween==30){
		   System.out.println("YOU HAVE BEEN FINED OF 50 RUPEES");
	   }
	   else if(daysBetween>30 && daysBetween<=60){
		   System.out.println("YOU HAVE BEEN FINED 100 RUPEES");
	   }
	   else
		   System.out.println("YOU HAVE TO PAY THE PRICE OF THE BOOK");
   }
       
         // MAIN FUNCTION//
    
    
    public static void main(String[] args)throws Exception{
    	
    	library in = new library();
    	Scanner s=new Scanner(System.in);
    	int n;
    	int ch;
       
        double z;
   
    	while(true){
    	System.out.println("\n1.ADD BOOK\n2.DISPLAY BOOK\n3.SEARCH BOOK\n4.ISSUE BOOK\n5.RETURN BOOK\n6.EXIT");
    	ch=s.nextInt();
    	
    	switch(ch){
    	case 1:
    		in.addbook();
    		break;
    	case 2:
    		in.display();
    		break;
    	case 3:
    		in.search();
    		break;
    	case 4:
    	    x=in.issue();
    		break;
    	case 5:
    		in.submission();
    		break;
    	
    	case 6: System.out.println("\nThanks for choosing us\nvisit again!!");
    		    System.exit(0);
    
    	
      }
    	}
    }
}
	// CREATED  BY  MEHUL, ANISH & AYUSH	//
   

