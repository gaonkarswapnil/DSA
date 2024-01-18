package Queue_Data;

import java.util.Scanner;

import Stack_Data.Stack_Example;

/**
 *
 * @author amart
 */
public class Linear_Queue_Example
{
    int front,rear,MaxSize,q[];
    void createQueue(int size)
    {
        MaxSize=size;
        front=0;
        rear=-1;
        q=new int[MaxSize];
    }
    void enqueue(int e)//entry on queue
   {
       rear++;
       q[rear]=e;
       System.out.println("Enqueued "+e);
   }
    boolean isFull()
   {
       if(rear==MaxSize-1)
           return true;
       else
           return false;
    }
    int dequeue()
   {
       int temp=q[front];
       front++;
       return temp;
   }
     boolean isEmpty()
   {
       if(front>rear)
           return true;
       else
           return false;
    }
     void printQueue()
    {
        System.out.println("Queue Has:");
        for(int i=front;i<=rear;i++)
            System.out.print(q[i]+" - ");
    }
     
     public static void main(String args[]) {
    	 int ch;
         Scanner in =new Scanner(System.in);
         Linear_Queue_Example obj=new Linear_Queue_Example();
         System.out.print("Enter size of Queue:");
         int size=in.nextInt();
         obj.createQueue(size);//creates array of size
         do
         {
             System.out.print("\n1.EnQueue\n2.DeQueue\n3.Print\n0.Exit\n:");
             ch=in.nextInt();
             switch(ch)
             {
                 case 1:
                     if(obj.isFull()!=true)//if not full then push
                     {
                         System.out.print("Enter elment:");
                         int e=in.nextInt();
                         obj.enqueue(e);
                     }
                     else
                         System.out.print("Queue Full");
                     break;
                 case 2:
                     if(obj.isEmpty()!=true)//if not empty then pop
                     {
                         System.out.print("Element Dequeued:"+obj.dequeue());
                     }
                     else
                         System.out.print("Queue Empty");
                     break;
                 case 3:
                     if(obj.isEmpty()!=true)//if not empty then dequeue
                     {
                       obj.printQueue();
                     }
                     else
                         System.out.print("Queue Empty");
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