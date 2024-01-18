package Linked_List_Data;

import java.util.Scanner;

public class Linear_Linked_List_Example 
{
    Node root;
    void createList()
    {
        root=null;//nullify root->assigning it null so we know when to use it
    }
    void insertLeft(int data)
    {
      Node n=new Node(data);
      if(root==null)
          root=n;
      else
      {
          n.next=root;//1100
          root=n;//root=800
      }
    }
     void insertRight(int data)
    {
      Node n=new Node(data);
      if(root==null)
          root=n;
      else
      {
         Node t=root;//1
         while(t.next!=null)//2
             t=t.next;
         t.next=n;//3
      }
    }
    void deleteLeft()
    {
      Node t;
      if(root==null)
          System.out.println("Empty List");
      else
      {
          t=root;//1:t=100
          root=root.next;//2:
          System.out.println("Deleted:"+t.data);
      }
    }
     void deleteRight()
     {
      if(root==null)
          System.out.println("Empty List");
      else
      {
          Node t,t2;
          t=t2=root;//1:t=100
          while(t.next!=null)//2
          {
              t2=t;
              t=t.next;
          }
          if(t==root)//single node
              root=null;
          else
             t2.next=null;//3
          System.out.println("Deleted:"+t.data);
      }
    }
     
    void printList()
    {
       if(root==null)
          System.out.println("Empty List");
      else
      {
          Node t=root;
          while(t!=null)
          {
              System.out.print("|"+t.data+"|->");
              t=t.next;
          }
      }
    }
    void searchList(int key)
    {
       if(root==null)
          System.out.println("Empty List");
      else
      {
          Node t=root;
          while(t!=null && t.data!=key)
            t=t.next;
          if(t==null)
               System.out.println(key+" not found");
          else if(t.data==key)
               System.out.println(key+" found int list");
          
      }
    }
    void deleteKey(int key)
    {
       if(root==null)
          System.out.println("Empty List");
      else
      {
          Node t=root;
          Node t2=root;
          while(t!=null && t.data!=key)
          {
              t2=t;  
              t=t.next;
          }
          if(t==null)
               System.out.println(key+" not found");
          else if(t.data==key)
           {
               System.out.println(key+" found int list");
               if(t==root)//case1
                   root=root.next;
               else if(t.next==null)//case 2
                   t2.next=null;
               else//case 3
               {
                   t2.next=t.next;
               }
               System.out.println("Deleted:"+t.data);     
          }
      }
    }
     @SuppressWarnings("unused")
	void insertAt(int position,int data)
    {
      Node n=new Node(data);
      if(root==null)
          root=n;
      else
      {
         Node t=root;//1
         Node t2=root;
         int p=0;
         if(position==0)//before root insert left
         {
             n.next=root;
             root=n;
         }
         else if(p<position)
         {
             while(t.next!=null && p<position)//2
                {
                 t2=t;
                 t=t.next;
                 p++;
                }
             if(t==null)
             {
                 System.out.println("Position not found");
             }
             else//delete
             {
                 t2.next=n;
                 n.next=t;
             }
                 System.out.println("inserted");
         }
      }
    }       
     
    public static void main(String args[])
     {
         Scanner in=new Scanner(System.in);
         Linear_Linked_List_Example obj=new Linear_Linked_List_Example();
         obj.createList();
         int ch,e,pos;
         do
         {
           System.out.println("\n1.Insert Left\n2.Insert Right\n3.Delete Left\n4.Delete Right\n5.Print List\n6.Search a key\n7.Delete on Key:\n8.Insert at\n0.Exit\n:");
           ch=in.nextInt();//read
           switch(ch)
           {
               case 1:
                       System.out.println("\nEnter a number:");
                       e=in.nextInt();
                       obj.insertLeft(e);
                       break;
               case 2:
                       System.out.println("\nEnter a number:");
                       e=in.nextInt();
                       obj.insertRight(e);
                       break;    
               case 3:
                      obj.deleteLeft();
                      break;
               case 4:
                      obj.deleteRight();
                      break;
               case 5:
                      System.out.println("\nelements in list:");
                      obj.printList();
                       break;
               case 6:
                       System.out.println("\nEnter a number to search:");
                       e=in.nextInt();
                       obj.searchList(e);
                       break;
               case 7:
                       System.out.println("\nEnter a number to delete:");
                       e=in.nextInt();
                       obj.deleteKey(e);
                       break;
                case 8:
                       System.out.println("\nEnter position and element:");
                       pos=in.nextInt();
                       e=in.nextInt();
                       obj.insertAt(pos,e);
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
