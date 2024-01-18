package Asiignments;

import java.util.Scanner;

public class A_InfixToPostFix {
	
	int MaxSize,tos;
	char stack[];
	
	 void createStack(int size)
	 {
		 MaxSize =size;
		 tos=-1;
		 stack =new char[MaxSize];
		 
		 
	 }
	 
	 void push(char e)
	 {
		 tos++;
		 stack[tos]=e;
		// System.out.println("Pushed");
	 }
	 
	 char pop()
	 {
		 char e=stack[tos];
		 tos--;
		 return e;
		
	 }
	 
	 boolean isFull()
	 {
		  if(tos==MaxSize-1)
		  {
			  return true;
			  
		  }
		  else 
		  {
			  return false ;
		  }
	 }
	 boolean isEmpty()
	 {
		  if(tos==-1)
		  {
			  return true;
			  
		  }
		  else 
		  {
			  return false ;
		  }
	 }
	 char peek()
	 {
		 char e=stack[tos];
		 return e;
		
	 }
	int priority(char c)
	{ 
		 if(c=='{'||c=='['||c=='(')
			{
				return 4;
			}
	    else  if(c=='^')
		{
			return 3;
		}
		else if(c=='/'||c=='*')
		{
			return 2;
		}
		else if(c=='+'||c=='-')
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter Infix Expression");
		
		Scanner s= new Scanner(System.in);
		
		String s1=s.nextLine();
		A_InfixToPostFix obj= new A_InfixToPostFix();
		obj.createStack(s1.length());
		
		System.out.println("Postfix Expression is");
		
		for(int i=0;i<s1.length();i++)
		{
			if(s1.charAt(i)=='{')
			{
				obj.push('{');
				
			}
			else if(s1.charAt(i)=='[')
			{
				obj.push('[');
			}
			else  if(s1.charAt(i)=='(')
			{
				obj.push('(');
			}
			else if(s1.charAt(i)=='}')
			{
				while(obj.peek()!='{')
				{
					System.out.print(obj.pop());
				}
				obj.pop();
			}
			else if(s1.charAt(i)==']')
			{
				while(obj.peek()!='[')
				{
					System.out.print(obj.pop());
				}
				obj.pop();
			}
			else  if(s1.charAt(i)==')')
			{
				while(obj.peek()!='(')
				{
					System.out.print(obj.pop());
				}
				obj.pop();
			}
			else if(s1.charAt(i)=='^'||s1.charAt(i)=='/'||s1.charAt(i)=='*'||s1.charAt(i)=='+'||s1.charAt(i)=='–'||s1.charAt(i)=='-')
			{
				if(!obj.isEmpty())
				{
					char a=obj.peek();
				if(obj.priority(a)==4||obj.priority(s1.charAt(i))>obj.priority(a))
				{
					obj.push(s1.charAt(i));
				}
				else 
				{
					while(!obj.isEmpty()&&obj.priority(s1.charAt(i))<=obj.priority(obj.peek()))
					{
						System.out.print(obj.pop());
					}
					obj.push(s1.charAt(i));
				}
				}
				else 
				{
					obj.push(s1.charAt(i));
				}
				
			}
			else 
			{
				System.out.print(s1.charAt(i));
			}
			
		}
		
		while(!obj.isEmpty())
		{
			System.out.print(obj.pop());
		}
		
	
	}

}

