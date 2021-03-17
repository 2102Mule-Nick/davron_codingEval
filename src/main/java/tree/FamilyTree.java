package tree;

public class FamilyTree {
	Node root;

	public FamilyTree()
	{
	    root = null;
	}
	
	public class Node
	{
	    Node leftChild, rightChild;
	    String name;

	    public Node(String n)
	    {
	        leftChild = null;
	        rightChild = null;
	        name = n;
	    }

	    public String toString()
	    {
	        return name;
	    }
	}


	public void insertNode(String par, String name)
	{
	    Node parent, current;
	    Node newMember = new Node(name);

	    if(root == null)
	        root = newMember;

	    
	    //if(root == null)
	    //    root = newMember;
	    else if(par == "")
	    {
	        if(root.rightChild == null)
	            root.rightChild = newMember;
	        else
	        {
	            current = root;
	            while(current.rightChild != null)
	                current = current.rightChild;
	            current.rightChild = newMember;
	        }
	    }

	    else
	    {
	        parent = findNode(par, root);

	        System.out.println("newFamilyMember is = " + newMember + "\n");
	        System.out.println("parent is = " + parent);

	        if (parent == null)
	            System.out.println("Parent doesn't exist");

	        //check if left child exist
	        else if(parent.leftChild == null)   
	            parent.leftChild = newMember;


	        // If parent already has a left child,
	        else
	        {
	            current = parent.leftChild;

	            while(current.rightChild != null)
	                current = current.rightChild;               

	            current.rightChild = newMember;
	        }   
	    }
	}


	public Node findNode(String name, Node localTree)
	{
	    Node current = localTree;

	    // return the node
	    if(current.name.equals(name))
	        return current;
	    
	    if(current.leftChild != null)
	    {
	        //System.out.println("going left to " + current.leftChild);
	        Node nodeFound = findNode(name, current.leftChild);
	        if ( nodeFound != null ) {
	          return nodeFound;
	        }
	    }

	    if(current.rightChild != null)
	    {
	        //System.out.println("going right to " + current.rightChild);
	        return findNode(name, current.rightChild);
	    }

	    return null;
	    
	    
	    //return null;
	    
	    
	}



	public void printTree(String par, Node localTree)
	{
	    Node parent, current;
	    parent = findNode(par, root);
	    System.out.println("parent= " + parent);

	    if (parent == null)
	        System.out.println(par + " doesn't exist.");

	    else
	    {
	        current = localTree;

	        System.out.println(current);

	        if(current.leftChild != null)
	            printTree(par, current.leftChild);

	        else if(current.rightChild != null)
	            printTree(par, current.rightChild);
	    }

	}


}
