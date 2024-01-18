package Linked_List_Data;

import java.util.Scanner;

public class Dynamic_Stack_Example
{
    Node tos;
    void createList()
    {
        tos=null;//nullify root->assigning it null so we know when to use it
    }
    void push(int data)
    {
      Node n=new Node(data);
      if(tos==null)
          tos=n;
      else
      {
          n.next=tos;//1100
          tos=n;//root=800
          System.out.println("Pushed");
      }
    }
     
    void pop()
    {
      Node t;
      if(tos==null)
          System.out.println("Empty List");
      else
      {
          t=tos;//1:t=100
          tos=tos.next;//2:
          System.out.println("Poped:"+t.data);
      }
    }

    void peek()
    {
      if(tos==null)
          System.out.println("Stack Empty");
      else
      {
          System.out.println("@TOS: "+tos.data);
      }
    }
    void printStack()
    {
       if(tos==null)
          System.out.println("Stack Empty");
      else
      {
          Node t=tos;
          while(t!=null)
          {
              System.out.print("|"+t.data+"|->");
              t=t.next;
          }
      }
    }

    public static void main(String args[]) {
    	int ch;
        Scanner in =new Scanner(System.in);
        Dynamic_Stack_Example obj=new Dynamic_Stack_Example();
        obj.createList();//creates root=null;
        do
        {
            System.out.print("\n1.Push\n2.Pop Right\n3.Peek\n4.PrintStack\n0.Exit\n:");
            ch=in.nextInt();
            switch(ch)
            {
                case 1:
                    System.out.print("Enter elment to left:");
                    int e=in.nextInt();
                    obj.push(e);
                    break;
                case 2:
                       obj.pop();
                    break;
                case 3:
                    
                    obj.peek();
                  break;
                case 4:
                    
                    obj.printStack();
                  break;
                case 0:
                        System.out.print("Exiting code");
                        break;
                default:
                        System.out.print("Wrong input");
                        break;
            }
        }while(ch!=0);
    }
}
