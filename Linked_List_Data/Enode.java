/*
 * Create A menu
driven CURD operation program for employee management using linear linked list.


Linked
list maintains data: employee_id,Name,Gender,Salary


Menu:


1.register
a new employee(goes at end of list)


2.search
an employee on his/her number


3.Update
old record on employee id.


                3-àupdate---àask for id->if found


1.name 2.gender 3.salary


4.Delete
record on id
 */


package Linked_List_Data;

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
class CURD_List
{
 Scanner in=new Scanner(System.in);
 Enode root;
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
     System.out.println("Inserted");
}
 void update(int key)
 {
	 if(root==null)
         System.out.println("Empty List");
     else
     {
         Enode t=root;
		while(t!=null && t.eid!=key)
           t=t.next;
         if(t==null)
              System.out.println(key+" not found");
         else if(t.eid==key)
         {
              System.out.println(key+" found int list");
                int ch;
                do
                {
                  System.out.println("\n1.Update name\n2.Update gender\n3.Update Salary:\n0.Exit\n:");
                  ch=in.nextInt();//read
                  switch(ch)
                  {
                      case 1:
                    	  System.out.println("Old:"+t.name);
                          System.out.println("\nEnter new:");
                          t.name=in.next();
                              break;
                      case 2:
                    	  System.out.println("Old:"+t.gender);
                          System.out.println("\nEnter new:");
                          t.gender=in.next();
                              break;    
                      case 3:
                    	  System.out.println("Old:"+t.salary);
                          System.out.println("\nEnter new:");
                          t.salary=in.nextFloat();
                             break;
                      case 0:
                              System.out.println("Exiting");
                          break;
                      default:
                              System.out.println("Wrong Choice");
                          break;
                  }
                    
                }while(ch!=0);
                System.out.println("\nupdated........");
         }
       }
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
              System.out.println(t.eid+","+t.name+","+t.gender+","+t.salary);
              t=t.next;
          }
      }
}
 void delete(int key)
 {
    if(root==null)
       System.out.println("Empty List");
   else
   {
       Enode t=root;
       Enode t2=root;
       while(t!=null && t.eid!=key)
       {
           t2=t;  
           t=t.next;
       }
       if(t==null)
            System.out.println(key+" not found");
       else if(t.eid==key)
        {
            System.out.println(key+" found in record");
            if(t==root)//case1
                root=root.next;
            else if(t.next==null)//case 2
                t2.next=null;
            else//case 3
            {
                t2.next=t.next;
            }
            System.out.println("Deleted Employee with EmpID: "+t.eid);     
         }
    }
  }
 public static void main(String args[])
     {
	 Scanner in=new Scanner(System.in);
         CURD_List obj=new CURD_List();
         int eid;
         String name,gender;
         float salary;
         obj.createList();
         
            
         	int key;
            int ch;
            do
            {
              System.out.println("\n1.Insert \n2.Print all records\n3.Update Employee Detials\n4.Delete Employee\n0.Exit\n:");
              ch=in.nextInt();//read
              switch(ch)
              {
                  case 1:
                      System.out.println("\nEnter EmpID: ");
                      eid=in.nextInt();
                      System.out.println("\nEnter Name: ");
                      name=in.next();
                      System.out.println("\nEnter Gender: ");
                      gender=in.next();
                      System.out.println("\nEnter Salary: ");
                      salary=in.nextFloat();
                      obj.insert(eid, name, gender,salary);
                      break;
                  case 2:
            	  	  obj.printList();
                      break;    
                  case 3:
                	  System.out.println("\nEnter EmpID: ");
                      key=in.nextInt();
            	  	  obj.update(key);
                      break;
                  case 4:
                	  System.out.println("\nEnter EmpID: ");
                      key=in.nextInt();
                      obj.delete(key);
                      break;    
                  case 0:
                          System.out.println("Exiting");
                      break;
                  default:
                          System.out.println("Wrong Choice");
                      break;
              }
                
            }while(ch!=0);
     }

}
