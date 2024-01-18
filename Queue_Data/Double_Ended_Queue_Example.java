package Queue_Data;

import java.util.Scanner;

/**
 *
 * @author amart
 */
public class Double_Ended_Queue_Example
{
  int q[],end1,end2,MaxSize;
  void createQueue(int size)
  {
      MaxSize=size;
      q=new int[MaxSize];
      end1=MaxSize/2;
      end2=end1-1;
  }
  void enqueueLeft(int data)
  {
     end1--;
     q[end1]=data;

  }
  void enqueueRight(int data)
  {
    end2++;
    q[end2]=data;
  }
   int dequeueLeft()
  {
      int temp=q[end1];
      end1++;
      return temp;
  }
    int dequeueRight()
  {
      int temp=q[end2];
      end2--;
      return temp;
  }
    boolean isFullLeft()
    {
      if(end1==0)
           return true;
      else
           return false;

    }

    boolean isFullRight()
    {
        if(end2==MaxSize-1)
           return true;
      else
           return false;
    }
    boolean isEmpty()
    {
       if(end1>end2)
           return true;
       else
           return false;
    }

    void printLR()
    {
      for(int i=end1;i<=end2;i++)
          System.out.print(q[i]+"->");
    }
    void printRL()
    {
        for(int i=end2;i>=end1;i--)
          System.out.print("<--"+q[i]);
    }
    public static void main(String args[])
     {
         Scanner in=new Scanner(System.in);
         System.out.println("Enter size of Queue:");
         int size=in.nextInt();
         Double_Ended_Queue_Example   obj=new Double_Ended_Queue_Example();
         obj.createQueue(size);
         int ch;
         do
         {
           System.out.println("\n1.Enqueue Left\n2.Enqueue Right\n3.Dequeue Left\n4.Dequeue Right\n5.Print Left to Right\n6.Print Right To Left\n0.Exit\n:");
           ch=in.nextInt();//read
           switch(ch)
           {
               case 1:
                   if(!obj.isFullLeft())
                   {
                       System.out.println("\nEnter a number:");
                       int no=in.nextInt();
                       obj.enqueueLeft(no);

                   }
                   else
                       System.out.println("Queue is Full");
                   break;
                case 2:
                   if(!obj.isFullRight())
                   {
                       System.out.println("\nEnter a number:");
                       int no=in.nextInt();
                       obj.enqueueRight(no);

                   }
                   else
                       System.out.println("Queue is Full");
                   break;
               case 3:
                    if(!obj.isEmpty())
                   {
                       System.out.println("Dequeued "+obj.dequeueLeft());
                   }
                   else
                       System.out.println("Queue is Empty");
                   break;
               case 4:
                    if(!obj.isEmpty())
                   {
                       System.out.println("Dequeued "+obj.dequeueRight());
                   }
                   else
                       System.out.println("Queue is Empty");
                   break;
               case 5:
                    if(!obj.isEmpty())
                     {
                       System.out.println("Elements in queue are");
                       obj.printLR();
                     }
                    else
                       System.out.println("Queue is Empty");
                   break;
                case 6:
                    if(!obj.isEmpty())
                     {
                       System.out.println("Elements in queue are");
                       obj.printRL();
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
