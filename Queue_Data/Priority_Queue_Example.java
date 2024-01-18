package Queue_Data;

import java.util.Scanner;

/**
 *
 * @author amart
 */
public class Priority_Queue_Example {
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
       for(int i=front;i<rear;i++)
       {
           for(int j=front;j<rear;j++)
           {
               if(q[j]<q[j+1])
               {
                   int temp=q[j];
                   q[j]=q[j+1];
                   q[j+1]=temp;
               }
           }
       }
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
     public static void main(String args[])
     {
         Scanner in=new Scanner(System.in);
         System.out.println("Enter size of Queue:");
         int size=in.nextInt();
         Priority_Queue_Example   obj=new Priority_Queue_Example ();
         obj.createQueue(size);
         int ch;
         do
         {
           System.out.println("\n1.Enqueue\n2.Dequeue\n3.Print\n0.Exit\n:");
           ch=in.nextInt();//read
           switch(ch)
           {
               case 1:
                   if(!obj.isFull())
                   {
                       System.out.println("\nEnter a number:");
                       int no=in.nextInt();
                       obj.enqueue(no);

                   }
                   else
                       System.out.println("Queue is Full");
                   break;
               case 2:
                    if(!obj.isEmpty())
                   {
                       System.out.println("Dequeued "+obj.dequeue());
                   }
                   else
                       System.out.println("Queue is Empty");
                   break;
               case 3:
                    if(!obj.isEmpty())
                     {
                       System.out.println("Elements in queue are");
                       obj.printQueue();
                     }
                    else
                       System.out.println("Queue is Empty");
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
