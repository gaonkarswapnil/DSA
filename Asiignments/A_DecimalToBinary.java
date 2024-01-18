package Asiignments;

import java.util.Scanner;

public class A_DecimalToBinary {
	
	int MaxSize,tos,stack[];
	
	 void createStack(int size)
	 {
		 MaxSize =size;
		 tos=-1;
		 stack =new int[MaxSize];
		 
		 
	 }
	 
	 void push(int e)
	 {
		 tos++;
		 stack[tos]=e;
		// System.out.println("Pushed");
	 }
	 
	 int pop()
	 {
		 int e=stack[tos];
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
	 int peek()
	 {
		 int e=stack[tos];
		 return e;
		
	 }
	 
	 void printStack()
	 {
		 
		 //System.out.println("Stack has");
		 for(int i=tos;i>=0;i--)
		 {
			 System.out.print(stack[i]);
		 }
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("Enter Number For Decimal To Binary Convertion");
		
		Scanner s= new Scanner(System.in);
		int number =s.nextInt();
		int n=number;
		A_DecimalToBinary obj= new A_DecimalToBinary();
		int a=(int) ((int) Math.log(n)/Math.log(2))+1;
		obj.createStack(n);
		
		while(number!=0)
		{
			int r=number%2;
			number/=2;
			
			obj.push(r);
			
		}
		
		System.out.println("Decimal To Binary of Number"+n+"is :");
		obj.printStack();
		
	}

}
