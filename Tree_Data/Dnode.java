package Tree_Data;

public class Dnode {

	int data;
	Dnode left;
	Dnode right;
	Dnode(int data){
		this.data=data;
		this.left=null;//next=null
		this.right=null;//prev=null
	}
}
