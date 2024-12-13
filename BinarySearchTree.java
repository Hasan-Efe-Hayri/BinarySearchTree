
public class BinarySearchTree {
	
	Node root;
	
	public BinarySearchTree()
	{
		this.root = null;
	}
	
	public boolean Add(int value)
	{
		Node temp = new Node(value);
		boolean result = this.Add(temp);
		return result;
	}
	
	private boolean Add(Node tNode) 
	{
		if(root == null) 
		{
			this.root = tNode;
			return true;
		}
		else 	
		{
			Node parent = null;
			Node current = this.root;
			int direction = 0;
			
			while(current != null)
			{
				if(tNode.getData() == current.getData())
				{
					return false;
				}
				else if (tNode.getData() > current.getData()) 
				{
					parent = current;
					current = current.getRightChild();
					direction = 1;
				}
				else if(tNode.getData() < current.getData())
				{
					parent = current;
					current = current.getLeftChild();
					direction = 0;
				}
			}//END-OF-WHİLE

			if(direction == 1) 
			{
				parent.setRightChild(tNode);
			}
			else 
			{
					parent.setLeftChild(tNode);
			}
			return true;
		}
	}
	
	public boolean delete(int value)
	{
		Node tNode = new Node(value);
		boolean result = delete(tNode);	
		return result;
	}
	
	private boolean delete(Node tNode)
	{
		if(this.root == null)
		{
			System.out.println("Ağaçta hiç düğüm yok!");
			return false;
		}
		Node current = root;
		Node parent = null;
		
		while(current != null && current.getData() != tNode.getData())
		{
			parent = current;
			
			if(current.getData() < tNode.getData())
			{
				current = current.getRightChild();
			}
			else
			{
				current = current.getLeftChild();
			}
		}
		if(current == null)
		{
			System.out.println( tNode.getData() + " Bu değer ağaçta yok!");
			return false;
		}
		
	    if (current.getLeftChild() != null && current.getRightChild() != null) 
	    {
	        Node successor = current.getRightChild();
	        Node successorParent = current;

	        while (successor.getLeftChild() != null) 
	        {
	            successorParent = successor;
	            successor = successor.getLeftChild();
	        }

	        current.setData(successor.getData());

	        if (successorParent.getLeftChild() == successor) {
	            successorParent.setLeftChild(successor.getRightChild());
	        } 
	        else 
	        {
	            successorParent.setRightChild(successor.getRightChild());
	        }

	        return true;
	    }

	    Node child = (current.getLeftChild() != null) ? current.getLeftChild() : current.getRightChild();

	    if (parent == null) 
	    {
	        root = child;
	    } 
	    else if (parent.getLeftChild() == current) 
	    {
	        parent.setLeftChild(child);
	    } 
	    else 
	    {
	        parent.setRightChild(child);
	    }
	    return true;
	}
}