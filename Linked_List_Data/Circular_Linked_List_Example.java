package Linked_List_Data;

import java.util.Scanner;

/**
 *
 * @author amart
 */
public class Circular_Linked_List_Example
{
    Node root,last;
    void createList()
    {
        root=last=null;//both null init
    }
    void insertLeft(int data)
    {
      Node n=new Node(data);
      if(root==null)
      { root=last=n;
        last.next=root;
      }
      else
      {
          n.next=root;//1
          root=n;//2
          last.next=root;//3
      }
    }
     void insertRight(int data)
    {
      Node n=new Node(data);
       if(root==null)
      {
          root=last=n;
          last.next=root;
      }
      else
      {
        last.next=n;//1
        last=n;//2
        last.next=root;//3
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
          if(root==last)
           {root=last=null;}
          else
          {
              root=root.next;//2:
              last.next=root;//3
          }
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
          while(t!=last)//2
          {
              t2=t;
              t=t.next;
          }
          if(t==root)//single node
          { root=last=null;}
          else
          {   last=t2;//3
              last.next=root;//4
          }//3
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
          do
          {
              System.out.print("|"+t.data+"|->");
              t=t.next;
          }while(t!=root);
      }
    }
    public static void main(String args[])
     {
         Scanner in=new Scanner(System.in);
         Circular_Linked_List_Example obj=new Circular_Linked_List_Example();
         obj.createList();
         int ch;
         do
         {
           System.out.println("\n1.Insert Left\n2.Insert Right\n3.Delete Left\n4.Delete Right\n5.Print List\n0.Exit\n:");
           ch=in.nextInt();//read
           switch(ch)
           {
               case 1:
                       System.out.println("\nEnter a number:");
                       int e=in.nextInt();
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
