package Stack_Data;

import java.util.Scanner;

/**
 *
 * @author amart
 */
public class Two_Stack 
{
    int MaxSize,tos1,tos2,stack[];
   void createStack(int size)
   {
       MaxSize=size;
       tos1=-1;
       tos2=MaxSize;
       stack=new int[MaxSize];
   }
   void push1(int e)
   {
       tos1++;
       stack[tos1]=e;
       System.out.println("Pushed "+e);
   }
   void push2(int e)
   {
       tos2--;
       stack[tos2]=e;
       System.out.println("Pushed "+e);
   }
   boolean isFull()
   {
       if(tos1+1==tos2)
           return true;
       else
           return false;
    }
   int pop1()
   {
       int temp=stack[tos1];
       tos1--;
       return temp;
   }
    int pop2()
   {
       int temp=stack[tos2];
       tos2++;
       return temp;
   }
    boolean isEmpty1()
   {
       if(tos1==-1)
           return true;
       else
           return false;
    }
    boolean isEmpty2()
   {
       if(tos2==MaxSize)
           return true;
       else
           return false;
    }
    int peek1()
   {
       return stack[tos1];
   }
    int peek2()
   {
       return stack[tos2];
   }
    void printStack1()
    {
        System.out.println("stack1 Has:");
        for(int i=tos1;i>=0;i--)
            System.out.println(stack[i]);
    }
     void printStack2()
    {
        System.out.println("stack2 Has:");
        for(int i=tos2;i<MaxSize;i++)
            System.out.println(stack[i]);
    }
     
     
     public static void main(String args[])
    {
        int ch;
        Scanner in =new Scanner(System.in);
        Two_Stack obj=new Two_Stack();
        System.out.print("Enter size of stack:");
        int size=in.nextInt();
        obj.createStack(size);//creates array of size
        do
        {
            System.out.print("\n1.Push1\n2.Push2\n3.Pop1\n4.Pop2\n5.Peek1\n6.Peek2\n7.Print stack1\n8.Print stack 2\n0.Exit\n:");
            ch=in.nextInt();
            switch(ch)
            {
                case 1:
                    if(obj.isFull()!=true)//if not full then push
                    {
                        System.out.print("Enter elment:");
                        int e=in.nextInt();
                        obj.push1(e);
                    }
                    else
                        System.out.print("Stack1 Full");
                    break;
                 case 2:
                    if(obj.isFull()!=true)//if not full then push
                    {
                        System.out.print("Enter elment:");
                        int e=in.nextInt();
                        obj.push2(e);
                    }
                    else
                        System.out.print("Stack2 Full");
                    break;
                case 3:
                    if(obj.isEmpty1()!=true)//if not empty then pop
                    {
                        System.out.print("Element Poped:"+obj.pop1());
                    }
                    else
                        System.out.print("Stack Empty");
                    break;
                case 4:
                    if(obj.isEmpty2()!=true)//if not empty then pop
                    {
                        System.out.print("Element Poped:"+obj.pop2());
                    }
                    else
                        System.out.print("Stack2 Empty");
                    break;
                case 5:
                    if(obj.isEmpty1()!=true)//if not empty then pop
                    {
                        System.out.print("Element @ Peek int stack1 is:"+obj.peek1());
                    }
                    else
                        System.out.print("Stack Empty");
                    break;
                    case 6:
                    if(obj.isEmpty2()!=true)//if not empty then pop
                    {
                        System.out.print("Element @ Peek int stack2 is:"+obj.peek2());
                    }
                    else
                        System.out.print("Stack Empty");
                    break;
                case 7:
                    if(obj.isEmpty1()!=true)//if not empty then pop
                    {
                      obj.printStack1();
                    }
                    else
                        System.out.print("Stack1 Empty");
                    break;
                     case 8:
                    if(obj.isEmpty2()!=true)//if not empty then pop
                    {
                      obj.printStack2();
                    }
                    else
                        System.out.print("Stack2 Empty");
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