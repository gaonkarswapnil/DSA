package Asiignments;

import java.util.Scanner;

class Enode
{
    int eid;
    String name,gender;
    float salary;
    Enode next;
    Enode(int eid,String name,String gender,float salary)
    {
        this.eid=eid;
        this.name=name;
        this.gender=gender;
        this.salary=salary;
        next=null;
    }
}
public class A_CURD_List
{
 Enode root;
 static int id=1;
 void createList()
 {
     root=null;
 }
 void insert(int eid,String name,String gender,float salary)
 {
     Enode n=new Enode(eid,name,gender,salary);
     if(root==null)
          root=n;
      else
      {
         Enode t=root;//1
         while(t.next!=null)//2
             t=t.next;
         t.next=n;//3
      }
     System.out.println("Your id is :"+eid+"  Data is inserted");
}
 void update(Enode t)
 {
	
          Scanner in=new Scanner(System.in);
          System.out.println("\n1.Update name\n2.Update gender\n3.Update Salary:");
          int i_ch=in.nextInt();
          if(i_ch==1)
          {
                System.out.println("Old:"+t.name);
                System.out.println("\nEnter new:");
                t.name=in.next();
          }
          else if(i_ch==2)
          {
                System.out.println("Old:"+t.gender);
                System.out.println("\nEnter new:");
                t.gender=in.next();
          }
          else if(i_ch==3)
          {
                System.out.println("Old:"+t.salary);
                System.out.println("\nEnter new:");
                t.salary=in.nextFloat();
          }
                System.out.println("\nupdated........");
          }

 void printList()
    {
       if(root==null)
          System.out.println("Empty List");
      else
      {
          Enode t=root;
          while(t!=null)
          {
        	  System.out.println("Data of employee :"+"id:"+t.eid+", name:"+t.name+", gender:"+t.gender+",salary :"+t.salary);
              t=t.next;
          }
      }
}
   void search(int id1) {
		// TODO Auto-generated method stub
		
	 
	 Enode t=root;
	 
	   int flag=0;
	   while(t!=null)
	   {
		   if(t.eid==id1)
		   {
			   flag=1;
			   System.out.println("Data of employee :"+"id:"+t.eid+", name:"+t.name+", gender:"+t.gender+",salary :"+t.salary);
			   break;
		   }
		   t=t.next;
	   }
	   if(flag==0)
	   {
		   System.out.println("Invalid id re-enter id");
	   }
	}
   private Enode isPresent(int id2) {
		// TODO Auto-generated method stub
	   
	   Enode t=root;
		 
	   int flag=0;
	   while(t!=null)
	   {
		   if(t.eid==id2)
		   {
			   flag=1;
			   
			   break;
		   }
		   t=t.next;
	   }
	   if(flag==1)
	   {
		   return t ;
	   }
		return null;
	}
   private void delete(int e) {
		// TODO Auto-generated method stub
	   
	   Enode t=root;
	   Enode t1=root;
		 
	   int flag=0;
	   while(t!=null)
	   {
		  
		   if(t.eid==e)
		   {
			   if(t==root&&t1==root)
			   {
				   root=t.next;
			   }
			   else if(t.next==null)
			   {
				   t1.next=null;
			   }
			   else 
			   {
				   t1.next=t.next;
			   }
			  
			   
			  
			  System.out.println("Node Deleted Succesfully "); 
			   break;
		   }
		   t1=t;
		  t=t.next;
	   }

		
	}
 public static void main(String args[])
     {
         Scanner in=new Scanner(System.in);
         A_CURD_List obj=new A_CURD_List();
         obj.createList();
//        System.out.println("Select from following \n1.Register\n2.Search \n3.Update\n4.Delete\n"); 
//         int choice=in.nextInt();
         
         int choice;
         do {
        	 System.out.println("Select from following \n1.Register\n2.Search \n3.Update\n4.Delete\n\0.Exit"); 
              choice=in.nextInt();
       
         
         if(choice==1)
         {
        	 System.out.println("Enter Employee Name\n");
        	 Scanner s =new Scanner(System.in);
        	 String name=s.nextLine();
        	 System.out.println("Enter Employee Gender\n");
        	 String gender =s.nextLine();
        	 System.out.println("Enter Employee Salary\n");
        	 int salary =in.nextInt();
        	 obj.insert(id++, name, gender, salary);
        	 
        	 
         }
         else if(choice==2)
         {
        	 System.out.println("Enter Employee id for search\n");
        	 int id1 =in.nextInt();
        	 obj.search(id1);
        	 
        	
        	 
         }
         else if(choice==3)
         {
        	 
         
        	 System.out.println("Enter Employee id for Update\n");
        	 int id2 =in.nextInt();
        	 
        	 Enode e=obj.isPresent(id2);
        	 if(e==null)
        	 {
        		 System.out.println("Enter Valid id");
        	 }
        	 else 
        	 {
        		 obj.update(e);
        	 }
        	 
        	 
         }
         else if(choice ==4)
         {
        	 System.out.println("Enter Employee id for Delete \n");
        	 int id3 =in.nextInt();
        	 
        	 Enode e1=obj.isPresent(id3);
        	 if(e1==null)
        	 {
        		 System.out.println("Enter Valid id");
        	 }
        	 else 
        	 {
        		 obj.delete(e1.eid);
        	 }
        	 
        	 
         }
         else if(choice!=0)
         {
        	 System.out.println("Enter Valid Choice "); 
         }
        	
        	 
        
         }while(choice!=0);
        
           
     }


}

