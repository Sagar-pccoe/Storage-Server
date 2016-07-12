class StackDemo
{
	int top;
	int size;
	BinaryTree stack[];
	
	StackDemo(int s)
	{
		top=-1;
		size=s;
		stack=new BinaryTree[size];
	}
	
	boolean isEmpty()
	{
		if(top==-1)
			return true;
		else 
			return false;
	}

	boolean isFull()
	{
		if(top==size-1)
			return true;
		else
			return false;
	}
	void push(BinaryTree node)
	{
		if(isFull())
		{
			System.out.println("Stack is full.");
			return;
		}else
		{
			top++;
			stack[top]=node;
		}
	}
	
	BinaryTree pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty.");
			return null;
		}else
		{
			BinaryTree t=stack[top];
			top--;
			return t;
		}
	}
}



class BinaryTree
{
	String name;
	BinaryTree left;
	BinaryTree right;
	
	BinaryTree()
	{
		name="Unnamed";
		left=null;
		right=null;
	}
	
	BinaryTree(String name)
	{
		this.name=name;
		left=null;
		right=null;
		
	}
	
	BinaryTree createBinaryTree(String n)
	{
		File f=new File()
		String list[]=
		
	}
	
	void insert(String node)
	{
		
	}
	
	void insertInList(BinaryTree t,BinaryTree node)
	{
		BinaryTree temp=t;
		while(temp.left!=null)
			temp=temp.left;
			
			temp.left=t;
		
	}
	void find(BinaryTree t)
	{
			
	}
	
	void display(BinaryTree root)
	{
		BinaryTree temp=null;
		
		
		
	}
	
	public static void main(String args[])
	{
		
	}	

}