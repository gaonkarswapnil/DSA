package Asiignments;

import java.util.Scanner;
import java.util.Stack;

public class A_PathExists {
	
	int v,visited[],g[][];
	
	Stack<Integer> q = new Stack<>();
    //v number of nodes
    //g is Adjacency matrix of v x v
    //visited[i] is 1:visited 0:unvisited

    void createGraph(int nodes)
    {   v=nodes;
        Scanner in=new Scanner(System.in);
        g=new int[v][v];//adj mat
        visited=new int[v];//visited array
        for(int i =0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                System.out.println("Enter value for v"+i+" to v"+j+" (999 for infinity):");
                g[i][j]=in.nextInt();

            }
        }
    }
    void printG()
    {
        for(int i =0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                System.out.print(g[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public void resetvisited()
    {
        for(int i =0;i<v;i++)
        {
            visited[i]=0;//unvisited 0 and 1 means visited
        }

    }

    public void DFS(int source)
    {
        visited[source]=1;
        System.out.println("V"+source);
        for(int i=0;i<v;i++)
        {
            if(g[source][i]==1 && visited[i]!=1)
            //neighbour and unvisited
            {
                DFS(i);
            }
        }
    }
    public boolean isPathExist(int source,int destination)
    {
    	//System.out.print(source+" ");
    	if(source==destination)
    	{
    		 q.push(source);
    		visited[source]=1;
    		return true;
    	}
        visited[source]=1;
        int flag=0;
        q.push(source);
       // System.out.println("V"+source);
        for(int i=0;i<v;i++)
        {
            if(g[source][i]==1 && visited[i]!=1)
            //neighbour and unvisited
            {
               boolean a= isPathExist(i,destination);
               if(a==false)
               {
            	   q.pop(); 
            	  
               }
               else 
               {
            	   flag=1;
            	   break;
               }
                
            }
        }
        
        if(flag==1)
        {
        	return true;
        }
        else 
        {
        	//q.pop();
        	return false;
        }
    }
    public boolean DFS_search(int source,int key)
    {
        boolean flag=false;
        if(key==source)
        {
            flag=true;
        }
        visited[source]=1;
        System.out.println("V"+source);
        for(int i=0;i<v;i++)
        {
            if(g[source][i]==1 && visited[i]!=1)//neighbour and unvisited
            {
                DFS_search(i,key);
            }
        }
        return(flag);
    }

   
    public static void main(String args[])
    {
    	Scanner s= new Scanner(System.in);
        A_PathExists  obj=new A_PathExists();
        System.out.println("Enter size of Graph");
        int size=s.nextInt();
        obj.createGraph(size);
        obj.printG();
        System.out.println("Enter source and destination To check Wether path exist between them or not");
        int source=s.nextInt();
        int destination=s.nextInt();
        
        boolean a=obj.isPathExist(source,destination);
        
        if(a==true)
        {
        	System.out.println("Path exist from "+source+"to"+destination);
        	
        	Stack<Integer> s1= new Stack<>();
        	
        	while(!obj.q.isEmpty())
        	{
        		s1.push(obj.q.pop());
        	}
        	System.out.println("Path is :");
        	while(!s1.isEmpty())
        	{
        	    System.out.print( s1.pop()+" ");
        	}
        }
        else 
        {
        	System.out.println("Path not exist from "+source+"to"+destination);
        }
    

    }

}


