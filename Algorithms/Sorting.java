/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms;

/**
 *
 * @author amart
 */
public class Sorting {
    static void printArray(int a[])
    {
        for(int i=0;i<a.length;i++)
          System.out.print(a[i]+",");
    }
    
    
	static void BubbleSort(int a[ ])
	{
	  int i, j,t;
	  for(i=0;i<a.length-1;i++)//paases
	   {System.out.println("pass:"+(i+1));
	      for(j=0;j<a.length-1;j++)
		//j stops at second last
		{
			if(a[j]>a[j+1])
	              {
				t=a[j];
				a[j]=a[j+1];
				a[j+1]=t;
			 }
	       }
	   }
	}
	
	
	
	static void BubbleSort_V2(int a[ ])
	{
		 int i, j,t;
		 for(i=0;i<a.length-1;i++)//paases
		 {
			 System.out.println("\npass:"+(i+1));
			 boolean done=true;
			 for(j=0;j<a.length-i-1;j++)
				 //j stops at second last
			 {
				 if(a[j]>a[j+1])
	             {
					 t=a[j];
					 a[j]=a[j+1];
					 a[j+1]=t;
	                        done=false;
	             }
			 }
			 if(done==true)//sorted so stop
	         break;
		 }
	}
	
	static void SelectionSort(int a[ ])
	{
	 int i,j,min,pos;
	 for(i=0;i<a.length-1;i++)
	 {
		 min=a[i];
		 pos=i;
		 for( j=i+1;j<a.length;j++)
		  {
		     if(a[j]<min)
		     {
		       min=a[j];
		       pos=j;
		     }
		 }
		 a[pos]=a[i];
		 a[i]=min;
	 }
	}
	
    static void InsertionSort(int a[])
	{
		int i,j,new_element;
		for(i=0;i<a.length-1;i++)
		{
		    new_element=a[i+1];
			j=i+1;
		    while(j>0 && a[j-1]>new_element)
		     {
		       a[j]=a[j-1];
				j--;
		     }
		     a[j]=new_element;
		}
	}
    
    
    
    static void QuickSort(int a[],int start,int end)
    {
	    int i=start;
	    int j=end;
	    int pivot=start;
	    while(i<j)
	     {
			  while(a[i]<a[pivot])
				i++;
			  while(a[j]>a[pivot])
				j--;
			  if(i<j)
			  {
			    int t=a[i];
				a[i]=a[j];
				a[j]=t;
			  }
	    }
	    if(i<end)
	    	QuickSort(a,i+1,end);
	    if(j>start)
	    	QuickSort(a,start,j-1);
    }
        
    static void MergeSort(int a[],int start,int end)
    {
      if(start<end)
        {
          int mid=(start+end)/2;
    	  MergeSort(a,start,mid);
    	  MergeSort(a,mid+1,end);
    	  Merger(a,start,mid,end);
        }
     }
    static void Merger(int a[],int start,int mid,int end)
    {
	     int i,j,temp[],tindex;
	     temp=new int[a.length];
	     i=start;
	     j=mid+1;
	     tindex=start;
	     while(i<=mid && j<=end)
         {
	         if(a[i]<a[j])
	        	 temp[tindex++]=a[i++];
	         else
	        	 temp[tindex++]=a[ j++];
         }
    	 while(i<=mid)//copy leftover
    		 temp[tindex++]=a[i++];
    	 while(j<=end)//copy leftover
    		 temp[tindex++]=a[j++];
    	 for(i=start;i<=end;i++)//copy to a again
    		 a[i]=temp[i];
    }

    static void HeapSort(int a[])
    {
        int i,j,pc;
        boolean done;
        for(i=a.length-1;i>-1;i--)
        {
        	for(j=0;j<=i;j++)
        	{
        		pc=j;
        		done=false;
        		while(pc>0 && pc/2>=0 && done!=true)
                {
        			if(a[pc] >a[pc/2])
                    {
        				int t=a[pc];
        				a[pc]=a[pc/2];
        				a[pc/2]=t;
        				pc=pc/2;//move to parent
                    }
        			else
                        done=true;
                    }
              }
	          int t=a[0];
	          a[0]=a[i];
	          a[i]=t;
        }
    }

	public static void main(String args[])
	 {
	     System.out.println("\n\n======================Bubble Sort==================");

	     int a1[]={11,22,33,44,55};
	     System.out.println("Before Sort:");
	     Sorting.printArray(a1);
	     System.out.print("\n");
	     
	     Sorting.BubbleSort(a1);
    	 Sorting.BubbleSort_V2(a1);
    	 
	     System.out.println("\nAfter Sort:");
	     Sorting.printArray(a1); 
	     
	     System.out.println("\n\n======================Insertion Sort==================");

	     int a2[]={10,2,4,3,5,1};
	     System.out.println("Before Sort:");
	     Sorting.printArray(a2);
	     Sorting.InsertionSort(a2);
	     System.out.println("\nAfter Sort:");
	     Sorting.printArray(a2);
	     
	     System.out.println("\n\n======================Selection Sort==================");

	     int a3[]={3,4,10,2,5,1};
	     System.out.println("Before Sort:");
	     Sorting.printArray(a3);
	     Sorting.SelectionSort(a3);
	     System.out.println("\nAfter Sort:");
	     Sorting.printArray(a3);
	     
	     System.out.println("\n\n======================Quick Sort==================");

	     int a4[]={8,1,3,6,2,5};
	     System.out.println("Before Sort:");
	     Sorting.printArray(a4);
	     Sorting.QuickSort(a4, 0, a4.length-1);
	     System.out.println("\nAfter Sort:");
	     Sorting.printArray(a4);
	     
	     System.out.println("\n\n======================Merge Sort==================");
	     
	     int a5[]={10,3,2,6,5,8};
	     System.out.println("Before Sort:");
	     Sorting.printArray(a5);
	     Sorting.MergeSort(a5, 0, a5.length-1);
	     System.out.println("\nAfter Sort:");
	     Sorting.printArray(a5);
	     
	     System.out.println("\n\n======================Heap Sort==================");
	     
	     int a6[]={10,3,2,6,5,8};
	     System.out.println("Before Sort:");
	     Sorting.printArray(a6);
	     Sorting.HeapSort(a6);
	     System.out.println("\nAfter Sort:");
	     Sorting.printArray(a6);
	     System.out.println("\n-----------------------------------------------------");
	     

	 }

}
