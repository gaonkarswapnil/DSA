package Linked_List_Data;

import java.util.Scanner;

import Queue_Data.Linear_Queue_Example;

public class Dynamic_Queue_Example
{
    Node rear,front;
    
    void createQueue()
    {
        front=rear=null;//nullify root->assigning it null so we know when to use it
    }
    void enqueue(int e)
    {
      Node n=new Node(e);
      if(rear==null)
          front=rear=n;
      else
      {
        rear.next=n;
        rear=n;
      }
      System.out.println("Enqueued");
    }
    void dequeue()
    {
      
      if(front==null)
          System.out.println("Empty List");
      else
      {
    	  Node t=front;//1
          if (front==rear)
          {
              front=rear=null;
          }
          else
          {
          front=front.next;//2
          System.out.println(t.data+" dequeued");
          }
      }
    }

    void printQueue()
    {
       if(front==null)
          System.out.println("Empty List");
      else
      {
          Node t=front;
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
        Dynamic_Queue_Example obj=new Dynamic_Queue_Example();
        obj.createQueue();//creates root=null;
        do
        {
            System.out.print("\n1.Enqueue\n2.Dequeue\n3.Print Queue\n0.Exit\n:");
            ch=in.nextInt();
            switch(ch)
            {
                case 1:
                    System.out.print("Enter elment to left:");
                    int e=in.nextInt();
                    obj.enqueue(e);
                    System.out.println("Enqueued");
                    break;
                case 2:
                    obj.dequeue();
                 break;
                case 3:
                    
                      obj.printQueue();
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
