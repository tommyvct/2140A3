import java.io.FileReader;
import java.util.Scanner;

/**
 * WuTommyA3Q2
 */
public class WuTommyA3Q2 
{
    
    public static void main(String[] args) 
    {
        try {
            FileReader r =  new FileReader("A3Q2input.txt");
            Scanner s = new Scanner(r);
            ExpressionTree t = new ExpressionTree("");
    
            while (s.hasNextLine()) 
            {
                String buffer = s.nextLine();
    
                if (buffer.contains("COMMENT"))
                {
                    System.out.println(buffer.substring(8));
                }
                else if (buffer.contains("NEW"))
                {
                    t = new ExpressionTree(buffer.substring(4));
                }
                else if (buffer.contains("PRINTINFIX"))
                {
                    t.traverse(2);
                }
                else if (buffer.contains("PRINTPOSTFIX"))
                {
                    t.traverse(3);
                }
                else if (buffer.contains("PRINTPREFIX"))
                {
                    t.traverse(1);
                }
                else if (buffer.contains("SIMPLIFY"))
                {
                    t.simplify();
                }
            }
            s.close();
        } catch (Exception e) {
            System.exit(3);
        }


    }
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
    
    public void printTreeNode()
    {
        switch (this.nodeType) 
        {
            case OPERATOR:
                System.out.print(operator);
                break;
            case VARIABLE:
                System.out.print(varName);
                break;
            case NUMBER:
                System.out.print(value);
                break;
        }
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

    /**
     * Constructor for a new instance of {@code Tree} object.<p>
     * 
     * Creates an empty {@code Tree}.
     */
    public ExpressionTree(String newExpression)
    {
        if (newExpression.equals(""))
        {
            return;
        }

        String[] tokens = newExpression.split(" ");
        
        root = null;

        if (isOperator(tokens[0]))// prefix
        {
            this.root = makeTreePrefix(tokens);
        }
        else  //postfix
        {
            this.root = makeTreePostfix(tokens);
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

    /**
     * 
     * 
     */
    private TreeNode makeTreePostfix(String[] postfixExpression)
    {
        Stack operand = new Stack();

        for (int i = 0; i < postfixExpression.length; i++) 
        {
            if (isOperator(postfixExpression[i]))
            {
                char operator = postfixExpression[i].charAt(0);
                TreeNode leftChild = operand.pop();
                TreeNode rightChild = operand.pop();
                TreeNode newRoot = new TreeNode(operator);
                
                newRoot.setLeftChild(leftChild);
                newRoot.setRightChild(rightChild);

                operand.push(newRoot);
            }
            else   //operand
            {
                if (Character.isDigit(postfixExpression[i].charAt(0)))   // number
                {
                    operand.push(new TreeNode(Integer.parseInt(postfixExpression[i])));
                }
                else         // var
                {
                    operand.push(new TreeNode(postfixExpression[i]));
                }
            }
        }

        return operand.pop();
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

        /**
     * Print the {@code Tree} object in given traversals.
     * 
     * @param traverseType Specifies the desired traverse type. 
     * {@code 1} for preorder traversal,
     * {@code 2} for inorder traversal, and
     * {@code 3} for postorder traversal.
     */
    public void traverse(int traverseType) 
    {
        switch (traverseType) 
        {
        case 1:
            System.out.print("\nPreorder traversal: ");
            preOrder(root);
            break;
        case 2:
            System.out.print("\nInorder traversal:  ");
            inOrder(root);
            break;
        case 3:
            System.out.print("\nPostorder traversal: ");
            postOrder(root);
            break;
        }

        System.out.println();
    }

    /**
     * Print the {@code Tree} from given {@code TreeNode} in preorder until the end of the {@code Tree}.
     * 
     * @param localRoot where to start print
     */
    private void preOrder(TreeNode localRoot) 
    {
        if (localRoot != null) 
        {
            localRoot.printTreeNode();
            System.out.print(" ");
            preOrder(localRoot.getLeftChild());
            preOrder(localRoot.getRightChild());
        }
    }

    /**
     * Print the {@code Tree} from given {@code TreeNode} inorder until the end of the {@code Tree}.
     * 
     * @param localRoot where to start print
     */
    private void inOrder(TreeNode localRoot) 
    {
        if (localRoot != null) 
        {
            inOrder(localRoot.getLeftChild());
            localRoot.printTreeNode();
            System.out.print(" ");
            inOrder(localRoot.getRightChild());
        }
    }

    /**
     * Print the {@code Tree} from given {@code TreeNode} in postorder until the end of the {@code Tree}.
     * 
     * @param localRoot where to start print
     */
    private void postOrder(TreeNode localRoot) 
    {
        if (localRoot != null) 
        {
            postOrder(localRoot.getLeftChild());
            postOrder(localRoot.getRightChild());
            localRoot.printTreeNode();
            System.out.print(" ");
        }
    }

    public void simplify()
    {
        Queue toCheck = new Queue();
        TreeNode current = this.root;

        if (this.root == null)
        {
            System.out.println("The tree is empty, nothing to simplify.");
            return;
        }

        toCheck.enqueue(current);

        while (!toCheck.isEmpty())
        {
            TreeNode temp = toCheck.dequeue();

            if 
            (
                temp.getLeftChild().getNodeType() == NodeType.NUMBER &&
                temp.getRightChild().getNodeType() == NodeType.NUMBER
            )
            {
                int ans;
                switch (temp.getOperator()) 
                {
                    case '+':
                        ans = temp.getLeftChild().getValue() + temp.getRightChild().getValue();
                        temp.setNodeType(NodeType.NUMBER);
                        temp.setValue(ans);
                        temp.setLeftChild(null);
                        temp.setRightChild(null);
                        break;
                    case '-':
                        ans = temp.getLeftChild().getValue() - temp.getRightChild().getValue();
                        temp.setNodeType(NodeType.NUMBER);
                        temp.setValue(ans);
                        temp.setLeftChild(null);
                        temp.setRightChild(null);
                        break;

                    case '*':
                        ans = temp.getLeftChild().getValue() * temp.getRightChild().getValue();
                        temp.setNodeType(NodeType.NUMBER);
                        temp.setValue(ans);
                        temp.setLeftChild(null);
                        temp.setRightChild(null);
                        break;

                    case '^':
                        ans = (int) Math.pow(temp.getLeftChild().getValue(), temp.getRightChild().getValue());
                        temp.setNodeType(NodeType.NUMBER);
                        temp.setValue(ans);
                        temp.setLeftChild(null);
                        temp.setRightChild(null);
                        break;
                }
            }
            else if
            (
                isOperand(temp.getLeftChild()) &&
                temp.getRightChild().getNodeType() == NodeType.NUMBER &&
                temp.getRightChild().getValue() == 1
            )
            {
                temp.setNodeType(temp.getLeftChild().getNodeType());
                if (temp.getNodeType() == NodeType.NUMBER)
                {
                    temp.setValue(temp.getLeftChild().getValue());
                }
                else if (temp.getNodeType() == NodeType.VARIABLE)
                {
                    temp.setVarName(temp.getLeftChild().getVarName());
                }
            }
            else if
            (
                isOperand(temp.getRightChild()) &&
                temp.getLeftChild().getNodeType() == NodeType.NUMBER &&
                temp.getLeftChild().getValue() == 1 &&
                temp.getOperator() != '^'
            )
            {
                temp.setNodeType(temp.getRightChild().getNodeType());
                if (temp.getNodeType() == NodeType.NUMBER)
                {
                    temp.setValue(temp.getRightChild().getValue());
                }
                else if (temp.getNodeType() == NodeType.VARIABLE)
                {
                    temp.setVarName(temp.getRightChild().getVarName());
                }
            }
            else if
            (
                (
                    isOperand(temp.getLeftChild()) &&
                    temp.getRightChild().getNodeType() == NodeType.NUMBER &&
                    temp.getRightChild().getValue() == 0
                )
                ||
                (
                    isOperand(temp.getRightChild()) &&
                    temp.getLeftChild().getNodeType() == NodeType.NUMBER &&
                    temp.getLeftChild().getValue() == 0
                )
            )
            {
                temp.setNodeType(NodeType.NUMBER);
                temp.setValue(0);
            }
        }
    }
}