/**
 * WuTommyA3Q2
 */
public class WuTommyA3Q2 {

    
}

enum NodeType
{
    OPERATOR, VARIABLE, NUMBER;
}

/**
 * {@code TreeNode} class, node class for {@code Tree} class.<p>
 * It carries one integer data.
 * 
 * @author Tommy Wu (7852291)
 */
class TreeNode
{
    private NodeType nodeType;   // data to store
    private char operator;
    private String varName;
    private int value;
    private TreeNode leftChild;
    private TreeNode rightChild;

    /**
     * Constructor for a new instance of {@code TreeNode} object.<p>
     * 
     * Create an {@code TreeNode} with given data, set the left and right child as {@code null}.
     * 
     * @param newData data to initialize a {@code NUMBER} {@code TreeNode}
     */
    public TreeNode(int newValue)
    {
        this.nodeType = NodeType.NUMBER;
        this.value = newValue;

        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * Constructor for a new instance of {@code TreeNode} object.<p>
     * 
     * Create an {@code TreeNode} with given data, set the left and right child as {@code null}.
     * 
     * @param newData data to initialize a {@code OPERATOR} {@code TreeNode}
     */
    public TreeNode(char newOperator)
    {
        this.nodeType = NodeType.OPERATOR;
        this.operator = newOperator;

        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * Constructor for a new instance of {@code TreeNode} object.<p>
     * 
     * Create an {@code TreeNode} with given data, set the left and right child as {@code null}.
     * 
     * @param newData data to initialize a {@code VARIABLE} {@code TreeNode}
     */
    public TreeNode(String newVarName)
    {
        this.nodeType = NodeType.VARIABLE;
        this.varName = newVarName;

        this.leftChild = null;
        this.rightChild = null;
    }

	/**
	 * @return the nodeType
	 */
    public NodeType getNodeType() 
    {
		return nodeType;
	}

	/**
	 * @param nodeType the nodeType to set
	 */
    public void setNodeType(NodeType nodeType) 
    {
		this.nodeType = nodeType;
	}

	/**
	 * @return the operator
	 */
    public char getOperator() 
    {
		return operator;
	}

	/**
	 * @param operator the operator to set
	 */
    public void setOperator(char operator) 
    {
		this.operator = operator;
	}

	/**
	 * @return the varName
	 */
    public String getVarName() 
    {
		return varName;
	}

	/**
	 * @param varName the varName to set
	 */
    public void setVarName(String varName) 
    {
		this.varName = varName;
	}

	/**
	 * @return the value
	 */
    public int getValue() 
    {
		return value;
	}

	/**
	 * @param value the value to set
	 */
    public void setValue(int value) 
    {
		this.value = value;
	}

	/**
	 * @return the leftChild
	 */
    public TreeNode getLeftChild() 
    {
		return leftChild;
	}

	/**
	 * @param leftChild the leftChild to set
	 */
    public void setLeftChild(TreeNode leftChild) 
    {
		this.leftChild = leftChild;
	}

	/**
	 * @return the rightChild
	 */
    public TreeNode getRightChild() 
    {
		return rightChild;
	}

	/**
	 * @param rightChild the rightChild to set
	 */
    public void setRightChild(TreeNode rightChild) 
    {
		this.rightChild = rightChild;
	}
}

/**
 * {@code Node} class powered {@code Queue} and {@code Stack}.
 * 
 * @author Tommy Wu (7852291)
 */
class Node
{
    private TreeNode treeNode;
    private Node next;

    /**
     * Constructor for a new instance of {@code Node} object for implementing {@code Stack} and {@code Queue}.<p>
     * 
     * Create an {@code Node} with given data and reference to the next {@code Node}.
     * 
     * @param newData data to initialize a {@code TreeNode}
     * @param newNext reference to the next {@code Node}
     */
    public Node(TreeNode newTreeNode, Node newNext)
    {
        this.treeNode = newTreeNode;
        this.next = newNext;
    }

    /**
     * Constructor for a new instance of {@code Node} object for implementing {@code Stack} and {@code Queue}.<p>
     * 
     * Create an {@code Node} with given {@code TreeNode} data and set reference to the next {@code Node} to {@code null}.
     * 
     * @param newData data to initialize a {@code TreeNode}
     */
    public Node(TreeNode newTreeNode)
    {
        this.treeNode = newTreeNode;
        this.next = null;
    }

    /**
     * @return the reference to the {@code TreeNode} data
     */
    public TreeNode getTreeNode() 
    {
        return treeNode;
    }

    /**
     * @param treeNode the reference to the {@code TreeNode} data to set
     */
    public void setTreeNode(TreeNode treeNode) 
    {
        this.treeNode = treeNode;
    }

    /**
     * @return the reference to the next {@code Node}
     */
    public Node getNext() 
    {
        return next;
    }

    /**
     * @param next the reference to the next {@code Node} to set
     */
    public void setNext(Node next) 
    {
        this.next = next;
    }
}


/**
 * {@code Queue} class powered by linked list.
 * 
 * @author Tommy Wu (7852291)
 */
class Queue 
{
    private Node front;
    private Node end;
    private int size;
    
    /**
     * Constructor for a new instance of {@code Queue} object.<p>
     * 
     * Creates an empty {@code Queue}.
     */
    public Queue()
    {
        this.front = null;
        this.end = null;
        this.size = 0;
    }

    /**
     * Tell if this {@code Queue} instance is empty or not
     * 
     * @return {@code true} if empty, {@code false} if not
     */
    public boolean isEmpty()
    {
        if (this.size == 0)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    /**
     * Tell the size of this {@code Queue} instance
     * 
     * @return size of this {@code Queue} instance
     */
    public int size()
    {
        return this.size;
    }

    /**
     * Put a {@code TreeNode} in the end of this {@code Queue} instance
     * 
     * @param toEnqueue {@code TreeNode} to enqueue
     * @return {@code true} if {@code toEnqueue} is not {@code null} and added in this {@code Queue} instance, {@code false} if not
     */
    public boolean enqueue(TreeNode toEnqueue)
    {
        if (toEnqueue == null)
        {
            return false;
        }

        if (this.isEmpty())
        {
            this.front = new Node(toEnqueue);
            this.end = this.front;
        }
        else
        {
            this.end.setNext(new Node(toEnqueue));
            this.end = this.end.getNext();
        }
        
        this.size++;
        return true;
    }

    /**
     * Remove and return the {@code TreeNode} in the front of this {@code Queue} instance
     * 
     * @return {@code TreeNode} in the front of this {@code Queue} instance, or {@code null} if this {@code Queue} instance is empty
     */
    public TreeNode dequeue()
    {
        if (this.isEmpty())
        {
            return null;
        }
        else 
        {
            TreeNode ret = front.getTreeNode();
            this.front = this.front.getNext();
            this.size--;
            return ret;
        }
    }

    /**
     * Peek the front of this {@code Queue} instance object without removing it
     * 
     * @return {@code TreeNode} in the front of this {@code Queue} instance, or {@code null} if this {@code Queue} instance is empty
     */
    public TreeNode peek()
    {
        if (this.isEmpty())
        {
            return null;
        }
        else 
        {
            return this.front.getTreeNode();
        }
    }

    public TreeNode peek(int index)
    {
        if (this.isEmpty())
        {
            return null;
        }
        else 
        {
            Node current = this.front;
            for (int i = 0; i < index; i++) 
            {
                current = current.getNext();
            }
            return current.getTreeNode();
        }
    }
}


/**
 * {@code Stack} class powered by linked list.
 * 
 * @author Tommy Wu (7852291)
 */
class Stack
{
    private Node top;
    private int size;

    /**
     * Constructor for a new instance of {@code Queue} object.<p>
     * 
     * Creates an empty {@code Stack}.
     */
    public Stack()
    {
        this.top = null;
        this.size = 0;
    }

    /**
     * Tell if this {@code Stack} instance is empty or not
     * 
     * @return {@code true} if empty, {@code false} if not
     */
    public boolean isEmpty()
    {
        if (this.size == 0)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    /**
     * Tell the size of this {@code Stack} instance
     * 
     * @return size of this {@code Stack} instance
     */
    public int size()
    {
        return this.size;
    }

    /**
     * Push a {@code TreeNode} on the top of this {@code Stack} instance.
     * 
     * @param toPush {@code TreeNode} to push
     * @return {@code true} if {@code toPsh} is not {@code null} and added in this {@code Queue} instance, {@code false} if not
     */
    public boolean push(TreeNode toPush)
    {
        if (toPush == null)
        {
            return false;
        }

        if (this.isEmpty())
        {
            this.top = new Node(toPush);
        }
        else
        {
            this.top.setNext(new Node(toPush));
            this.top = this.top.getNext();
        }

        this.size++;
        return true;
    }

    /**
     * Remove and return the {@code TreeNode} on the top of this {@code Stack} instance
     * 
     * @return {@code TreeNode} on the top of this {@code Stack} instance, or {@code null} if this {@code Stack} instance is empty
     */
    public TreeNode pop()
    {
        if (this.isEmpty())
        {
            return null;
        }

        TreeNode ret = this.top.getTreeNode();

        this.top = this.top.getNext();
        return ret;
    }

    /**
     * Peek on the top of this {@code Stack} instance object without removing it
     * 
     * @return {@code TreeNode} in the front of this {@code Stack} instance, or {@code null} if this {@code Queue} instance is empty
     */
    public TreeNode peek()
    {
        if (this.isEmpty())
        {
            return null;
        }
        else 
        {
            return this.top.getTreeNode();
        }
    }
}

class ExpressionTree
{
    private TreeNode root;
    private int treeSize;

    /**
     * Constructor for a new instance of {@code Tree} object.<p>
     * 
     * Creates an empty {@code Tree}.
     */
    public ExpressionTree(String newExpression)
    {
        String[] tokens = newExpression.split(" ");
        
        root = null;
        treeSize = 0;

        if (isOperator(tokens[0]))// prefix
        {
            this.root = makeTreePrefix(tokens);
        }
        else  //postfix
        {
            
        }
    }

    private TreeNode makeTreePrefix(String[] prefixExpression)
    {
        Queue expressionQueue = new Queue();

        for (int i = 0; i < prefixExpression.length; i++) 
        {
            if (isOperator(prefixExpression[i]))      // operator
            {
                expressionQueue.enqueue(new TreeNode(prefixExpression[i].charAt(0)));
            }
            else if (Character.isDigit(prefixExpression[i].charAt(0))) // number
            {
                expressionQueue.enqueue(new TreeNode(Integer.parseInt(prefixExpression[i])));
            }
            else // variable
            {
                expressionQueue.enqueue(new TreeNode(prefixExpression[i]));
            }
        }
        
        while (expressionQueue.size() > 1)  // exit when there is only one TreeNode, the root of the tree
        {
            if 
            (
                (
                    expressionQueue.peek().getNodeType() == NodeType.NUMBER   ||   // number
                    expressionQueue.peek().getNodeType() == NodeType.VARIABLE      // variable
                )    
                ||
                (
                    expressionQueue.peek().getLeftChild()  != null            &&   // have left child
                    expressionQueue.peek().getRightChild() != null                 // or right child
                )
            )  // number or variable
            {
                expressionQueue.enqueue(expressionQueue.dequeue());           // put it back of the queue
            }
            else // operator
            {
                TreeNode operatorNode = expressionQueue.dequeue();
    
                if (isOperand(expressionQueue.peek(0)) && isOperand(expressionQueue.peek(1)))
                {
                    operatorNode.setLeftChild(expressionQueue.dequeue());       // append left child
                    operatorNode.setRightChild(expressionQueue.dequeue());      // append right child
                }
    
                expressionQueue.enqueue(operatorNode);
            }
        }

        return expressionQueue.dequeue();
    }

    private boolean isOperand(TreeNode toDetermine)
    {
        if
        (
            (
                toDetermine.getNodeType() == NodeType.NUMBER   ||  // number or var
                toDetermine.getNodeType() == NodeType.VARIABLE     
            )    
            ||
            (
                toDetermine.getLeftChild()  != null            &&  // or have left child
                toDetermine.getRightChild() != null                // or right child
            )
        )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean isOperator(String toDetermine)
    {
        if // operator
        (
            toDetermine == "+" &&
            toDetermine == "-" &&
            toDetermine == "*" &&
            toDetermine == "^"
        )
        {
            return true;
        }
        else
        {
            return false;
        }

    }

}