package Stack_Data;

/**
 *
 * @author amart
 */
import java.util.Scanner;
class Max_Stack
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
        Max_Stack Normal_stack=new Max_Stack();
         Max_Stack Max_stack=new Max_Stack();
         Normal_stack.createStack(16);
         Max_stack.createStack(16);
         do
        {
            System.out.print("\n1.Push\n2.Pop\n3.Peek\n4.Print\n5.Max\n0.Exit\n:");
            ch=in.nextInt();
            switch(ch)
            {
                case 1:
                    if(Normal_stack.isFull()!=true)//if not full then pushj
                    {
                        System.out.print("Enter elment:");
                        int e=in.nextInt();
                        if(Max_stack.isEmpty())
                        { System.out.print("Max updated:");
                            Max_stack.push(e);
                        }
                        else if(e>Max_stack.peek())
                        { System.out.print("Max updated:");
                            Max_stack.push(e);
                        }
                        Normal_stack.push(e);
                        }
                    else
                        System.out.print("Stack Full");
                    break;
                case 2:
                    if(Normal_stack.isEmpty()!=true)//if not empty then pop
                    {
                        if (Normal_stack.peek()==Max_stack.peek())
                            System.out.print("Max Stack also poped:"+Max_stack.pop());
                        System.out.print("poped:"+Normal_stack.pop());
                        
                    }
                    else
                        System.out.print("Stack Empty");
                    break;
                case 3:
                    if(Normal_stack.isEmpty()!=true)//if not empty then pop
                    {
                        System.out.print("Element @ Peek is:"+Normal_stack.peek());
                    }
                    else
                        System.out.print("Stack Empty");
                    break;
                    case 5:
                    if(Max_stack.isEmpty()!=true)//if not empty then pop
                    {
                        System.out.print("Max Element @ is:"+Max_stack.peek());
                    }
                    else
                        System.out.print("Stack Empty");
                    break;
                case 4:
                    if(Normal_stack.isEmpty()!=true)//if not empty then pop
                    {
                      Normal_stack.printStack();
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
         
      