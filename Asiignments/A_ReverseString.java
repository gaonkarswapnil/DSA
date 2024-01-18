package Asiignments;

import java.util.Scanner;

public class A_ReverseString {
	
	int  MaxSize,tos;
	char stack[];
	String Reverse="";
	
	 void createStack(int size)
	 {
		 MaxSize =size;
		 tos=-1;
		 stack =new char [MaxSize];
		 
		 
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
	 
	 void ReverseString()
	 {
		 
		// System.out.println("Stack has");
		 for(int  i=tos;i>=0;i--)
		 {
			 Reverse+=stack[i];
		 }
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter String For Reverse");
		Scanner in=new Scanner(System.in);
		String s= in.nextLine();
		A_ReverseString obj =new A_ReverseString();
		int size=s.length();
		obj.createStack(size);
		
		
		for(int i=0;i<s.length();i++)
		{
			obj.push(s.charAt(i));
		}
		
		//System.out.print("Reversed String is:  ");
		obj.ReverseString();
		
		int flag=0;
		for(int i=0;i<size;i++)
		{
			if(s.charAt(i)!=obj.Reverse.charAt(i))
			{
				flag=1;
				break;
			}
		}
		
		if(flag==0)
		{
			System.out.println("String is Palindrom");
		}
		else 
		{
			System.out.println("String is Not Palindrome");
		}

	}

}

