/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree_Data;

import java.util.Scanner;

/**
 *
 * @author amart
 */

public class Tree_Example
{
    Dnode root;
    void createTree()
    {
        root=null;
    }
    void insertData(Dnode r,Dnode n)
    {
        if(root==null)
            root=n;
        else
        {
            if(n.data<r.data)//left
            {
                if(r.left==null)
                    r.left=n;
                else
                    insertData(r.left,n);
            }
            else
            {
                if(r.right==null)
                    r.right=n;
                else
                    insertData(r.right,n);
            }
        }
    }
    void inorder(Dnode r)
    {
        if(r!=null)
        {
            inorder(r.left);//l
            System.out.print(r.data+",");//p
            inorder(r.right);//r
        }
    }
    void preorder(Dnode r)
    {
    	if(r!=null)
    	{
    		System.out.print(r.data+",");//p
    		preorder(r.left);//l
    		inorder(r.right);//r
    	}
    }

    void postorder(Dnode r)
    {
    	if(r!=null)
    	{
    		inorder(r.left);//l		
    		inorder(r.right);//r
    		System.out.print(r.data+",");//p
    	}
    	
    }
    
    
    boolean isBalanced(Dnode r)
    {
        if(r==null)
            return true;
        else
        {
            int right=getHeight(r.right);
            int left=getHeight(r.left);
            if(Math.abs(left - right)<=1)//+1,0,-1
                return true;
            else
                return false;

        }
    }
    int getHeight(Dnode r)
    {
        if(r==null)
            return 0;
        else
        {
            int LeftHeight=getHeight(r.left);
            int RightHeight=getHeight(r.right);
            return (Math.max(LeftHeight, RightHeight)+1);
        }

    }
    int numberOfLeafNode(Dnode r) {
        if (r == null)
            return 0;
        else if (r.left == null && r.right == null) // is leaf node or not
            return 1;
        else
            return numberOfLeafNode(r.left) + numberOfLeafNode(r.right);
    }
    
    
     public static void main(String[] args)
     {
    	 Scanner in = new Scanner(System.in);
         Tree_Example t=new Tree_Example();

         int ch;
         do
         {
             System.out.print("\n1.Insert Elements\n2.Inorder\n3.Preorder\n4.Postorder\n5.Height\n6.Is Tree Balanced\n7.Number oo Leaf Node\n8.Print all from choice 2 to 7 \n0.Exit\n:");
             ch=in.nextInt();
             switch(ch)
             {
                 case 1:
                	 System.out.println("------------------------------------------");
                	 System.out.print("\nNumber of element:");
                     int size=in.nextInt();
                     for(int i=0;i<size;i++)
                     {
                    	 System.out.print("Enter element "+i+" :");
                         int e=in.nextInt();
                         
                    	 Dnode n1 =new Dnode(e);
                         t.insertData(t.root,n1);
                     }
                	 System.out.println("------------------------------------------");
                     break;
                 case 2:
                	 System.out.println("------------------------------------------");
                	 System.out.println("\nInorder is:");
                     System.out.print("\t  |");
                     t.inorder(t.root);
                     System.out.print("|\n");
                     System.out.println("------------------------------------------");
                     break;
                 case 3:
                	 System.out.println("------------------------------------------");
                	 System.out.println("\nPreorder is:");
		             System.out.print("\t  |");
		             t.preorder(t.root);
		             System.out.print("|\n");
		             System.out.println("------------------------------------------");
                     break;
                 case 4:
                	 System.out.println("------------------------------------------");
                	 System.out.println("\nPostorder is:");
                     System.out.print("\t  |");
                     t.postorder(t.root);
                     System.out.print("|\n");
                     System.out.println("------------------------------------------");
                     break;
                 case 5:
                	 System.out.println("------------------------------------------");
                   System.out.println("\nHeight is:\t"+(t.getHeight(t.root)-1));
                   System.out.println("------------------------------------------");
                	 break;
                 case 6:
                	 System.out.println("------------------------------------------");
                     System.out.println("\nIs Tree Balanced:\t"+t.isBalanced(t.root));
                     System.out.println("------------------------------------------");
                	 break;
                 case 7:
                	 System.out.println("------------------------------------------");
                     System.out.println("\nNumber of Leaf Node:\t"+t.numberOfLeafNode(t.root));
                     System.out.println("------------------------------------------");
                     break;
                 case 8:
                	 System.out.println("------------------------------------------");
                	 System.out.println("\nInorder is:");
                     System.out.print("\t  |");
                     t.inorder(t.root);
                     System.out.print("|");
                     
                     System.out.println("\nPreorder is:");
                     System.out.print("\t  |");
                     t.preorder(t.root);
                     System.out.print("|");

                     System.out.println("\nPostorder is:");
                     System.out.print("\t  |");
                     t.postorder(t.root);
                     System.out.print("|\n");

                     System.out.println("\nHeight is:\t"+(t.getHeight(t.root)-1));
                     
                     System.out.println("\nIs Tree Balanced:\t"+t.isBalanced(t.root));

                     System.out.println("\nNumber of Leaf Node:\t"+t.numberOfLeafNode(t.root));
                	 System.out.println("------------------------------------------");
                     break;
                 case 0:
                         System.out.print("Exiting code");
                         break;
                 default:
                         System.out.print("Wrong input");
                         break;
             }
         }while(ch!=0);
         
         
//         Dnode n1=new Dnode(100);
//         t.insertData(t.root,n1);
//         Dnode n2=new Dnode(50);
//         t.insertData(t.root,n2);
//         Dnode n3=new Dnode(20);
//         t.insertData(t.root,n3);
//          Dnode n4=new Dnode(60);
//         t.insertData(t.root,n4);
//         Dnode n5=new Dnode(110);
//         t.insertData(t.root,n5);
//         Dnode n6=new Dnode(120);
//         t.insertData(t.root,n6);
//         Dnode n7=new Dnode(130);
//         t.insertData(t.root,n7);
//         System.out.println("\nHeight is:");
//         System.out.print("\t  |");
//         t.inorder(t.root);
//         System.out.print("|");
//         
//         System.out.println("\nHeight is:");
//         System.out.print("\t  |");
//         t.preorder(t.root);
//         System.out.print("|");
//
//         System.out.println("\nHeight is:");
//         System.out.print("\t  |");
//         t.postorder(t.root);
//         System.out.print("|\n");
//
//         System.out.println("\nHeight is:\t"+(t.getHeight(t.root)-1));
//         
//         System.out.println("\nIs Tree Balanced:\t"+t.isBalanced(t.root));
//
//         System.out.println("\nNumber of Leaf Node:\t"+t.numberOfLeafNode(t.root));

         
         
     }
}
