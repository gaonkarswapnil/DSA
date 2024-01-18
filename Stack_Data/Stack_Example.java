package Stack_Data;

/**
 *
 * @author amart
 * 
 */
import java.util.Scanner;
public class Stack_Example 
{
   int MaxSize,tos,stack[];
   void createStack(int size)
   {
       MaxSize=size;
       tos=-1;
       stack=new int[MaxSize];
   }
   void push(int e)
   {
       tos++;
       stack[tos]=e;
       System.out.println("Pushed "+e);
   }
   boolean isFull()
   {
       if(tos==MaxSize-1)
           return true;
       else
           return false;
    }
   int pop()
   {
       int temp=stack[tos];
       tos--;
       return temp;
   }
    boolean isEmpty()
   {
       if(tos==-1)
           return true;
       else
           return false;
    }
    int peek()
   {
       return stack[tos];
   }
    void printStack()
    {
        System.out.println("stack Has:");
        for(int i=tos;i>=0;i--)
            System.out.println(stack[i]);
    }
    
    
    public static void main(String args[])
    {
        int ch;
        Scanner in =new Scanner(System.in);
        Stack_Example obj=new Stack_Example();
        System.out.print("Enter size of stack:");
        int size=in.nextInt();
        obj.createStack(size);//creates array of size
        do
        {
            System.out.print("\n1.Push\n2.Pop\n3.Peek\n4.Print\n0.Exit\n:");
            ch=in.nextInt();
            switch(ch)
            {
                case 1:
                    if(obj.isFull()!=true)//if not full then push
                    {
                        System.out.print("Enter elment:");
                        int e=in.nextInt();
                        obj.push(e);
                    }
                    else
                        System.out.print("Stack Full");
                    break;
                case 2:
                    if(obj.isEmpty()!=true)//if not empty then pop
                    {
                        System.out.print("Element Poped:"+obj.pop());
                    }
                    else
                        System.out.print("Stack Empty");
                    break;
                case 3:
                    if(obj.isEmpty()!=true)//if not empty then pop
                    {
                        System.out.print("Element @ Peek is:"+obj.peek());
                    }
                    else
                        System.out.print("Stack Empty");
                    break;
                case 4:
                    if(obj.isEmpty()!=true)//if not empty then pop
                    {
                      obj.printStack();
                    }
                    else
                        System.out.print("Stack Empty");
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