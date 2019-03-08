import java.util.Random;

/**
 * A Breadth-First Traversal of a Binary Tree <p>
 * Main class for Assignment 3, Qustion 1.
 * This class insert random integers into a binary tree,
 * then print the tree using preoeder, inorder, postorder
 * and breadth-first traversal.
 * 
 * @author Tommy Wu (7852291)
 */
public class WuTommyA3Q1
{

    public static void main(String[] args) 
    {
        Random rd = new Random();
        Tree tree = new Tree();

        // 1. Insert 20 random integers (with values between 1 and 999) in a binary search tree.
        for (int i = 0; i < 20; i++) 
        {
            tree.insert(rd.nextInt(999) + 1);
        }

        // 2. Print the tree using a preorder traversal.
        // 3. Print the tree using an inorder traversal.
        // 4. Print the tree using a postorder traversal.
        for (int i = 1; i <= 3; i++) 
        {
            tree.traverse(i);
        }

        // 5. Print the tree using a breadth-first traversal.
        System.out.println();
        tree.displayTreeBFT();
    }
}




/**
 * {@code TreeNode} class, node class for {@code Tree} class.<p>
 * It carries one integer data.
 * 
 * @author Tommy Wu (7852291)
 */
class TreeNode
{
    private int data;   // data to store
    private TreeNode leftChild;
    private TreeNode rightChild;

    /**
     * Constructor for a new instance of {@code TreeNode} object.<p>
     * 
     * Create an {@code TreeNode} with given data, set the left and right child as {@code null}.
     * 
     * @param newData data to initialize a {@code TreeNode}
     */
    public TreeNode(int newData)
    {
        this.data = newData;
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * @return the data
     */
    public int getData() 
    {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) 
    {
        this.data = data;
    }

    /**
     * @return the reference to the leftChild
     */
    public TreeNode getLeftChild() 
    {
        return leftChild;
    }

    /**
     * @param leftChild the reference to the leftChild to set
     */
    public void setLeftChild(TreeNode leftChild) 
    {
        this.leftChild = leftChild;
    }

    /**
     * @return the reference to the rightChild
     */
    public TreeNode getRightChild() 
    {
        return rightChild;
    }

    /**
     * @param rightChild the reference to the rightChild to set
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

/**
 * {@code Tree} class implemented a binary tree.<p>
 * This tree carries one integer data per node.
 * 
 * @author Tommy Wu (7852291)
 */
class Tree
{
    private TreeNode root;
    private int treeSize;

    /**
     * Constructor for a new instance of {@code Tree} object.<p>
     * 
     * Creates an empty {@code Tree}.
     */
    public Tree()
    {
        root = null;
        treeSize = 0;
    }

    /**
     * Find a {@code TreeNode} data in this instance of {@code Tree} object that contains the integer to find.
     * 
     * @param toFind the integer to find
     * @return {@code TreeNode} object that contains the integer to find
     */
    public TreeNode find(int toFind)
    {
        if (treeSize <= 0)
        {
            return null;
        }

        TreeNode current = root;  // start ar root

        while (current.getData() != toFind)
        {
            if (toFind < current.getData()) // go left?
            {
                current= current.getLeftChild();
            }
            else // or go right?
            {
                current = current.getRightChild();
            }

            if (current == null) // if no child,
            {
                return null; // didn't find it
            }
        }

        return current; // found it
    }

    /**
     * Insert the given data in this {@code Tree}.
     * 
     * @param toInsert integer data to insert
     */
    public void insert(int toInsert)
    {
        TreeNode newTreeNode = new TreeNode(toInsert);   // make new node, insert data

        if (root == null) // no node in root
        {
            root = newTreeNode;  // start with this node
        }
        else   // root occupied
        {
            TreeNode current = root;   // start at root
            TreeNode parent;

            while (true)   // (exits internally)
            {
                parent = current;

                if (toInsert < current.getData())   // go left?
                {
                    current = current.getLeftChild();

                    if(current == null)     // if end of the line,
                    {
                        parent.setLeftChild(newTreeNode);   // insert on left
                        return;
                    }
                }
                else      // or go right?
                {
                    current = current.getRightChild();

                    if (current == null)    // if end of the line
                    {
                        parent.setRightChild(newTreeNode);    // insert on right
                        return;
                    }
                }
            }
        }
    }

    /**
     * Delete a {@code TreeNode} data in this instance of {@code Tree} object that contains the integer to delete.
     * 
     * @param toDelete the integer to delete
     * @return {@code true} if the integer to delete is found and deleted, {@code false} if the list is empty or the integer to delete is not found.
     */
    public boolean delete(int toDelete)
    {
        if (treeSize <= 0)
        {
            return false;
        }

        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;

        while (current.getData() != toDelete)   // search for node
        {
            parent = current;

            if (toDelete < current.getData())     // go left?
            {
                isLeftChild = true;
                current = current.getLeftChild();
            }
            else                        // or go right?
            {
                isLeftChild = false;
                current = current.getRightChild();
            }

            if (current == null)         // end of the line,
            {
                return false;            // didn't find it  
            }
        }
        // found node to delete

        // if no children, simply delete it
        if (current.getLeftChild() == null && current.getRightChild() == null) 
        {
            if (current == root) // if root,
            {
                root = null; // tree is empty
            }
            else if (isLeftChild)
            {
                parent.setLeftChild(null); // disconnect
            }
            else // from parent
            {
                parent.setRightChild(null);
            }
        }

        // if no right child, replace with left subtree
        else if (current.getRightChild() == null)
        {
            if (current == root)
            {
                root = current.getLeftChild();
            }
            else if (isLeftChild)
            {
                parent.setLeftChild(current.getLeftChild());
            }
            else
            {
                parent.setRightChild(current.getLeftChild());
            }
        }

        // if no left child, replace with right subtree
        else if (current.getLeftChild() == null)
        {
            if (current == root)
            {
                root = current.getRightChild();
            }
            else if (isLeftChild)
            {
                parent.setLeftChild(current.getRightChild());
            }
            else
            {
                parent.setRightChild(current.getRightChild());
            }
        }

        else // two children, so replace with inorder successor
        {
            // get successor of node to delete (current)
            TreeNode successor = getSuccessor(current);

            // connect parent of current to successor instead
            if (current == root)
            {
                root = successor;
            }
            else if (isLeftChild)
            {
                parent.setLeftChild(successor);
            }
            else
            {
                parent.setRightChild(successor);
            }

            // connect successor to current's left child
            successor.setLeftChild(current.getLeftChild());

        }
        // (successor cannot have a left child)
        return true; // success
    }

    /**
     * Get the Successor of the given {@code TreeNode} from this {@code Tree} instance.
     * 
     * @param delNode the {code TreeNode} to get it's successor
     * @return the given {@code TreeNode}'s successor
     */
    private TreeNode getSuccessor(TreeNode delNode) 
    {
        TreeNode successorParent = delNode;
        TreeNode successor = delNode;
        TreeNode current = delNode.getRightChild(); // go to right child

        while (current != null) // until no more left children,
        {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild(); // go to left child
        }

        // if successor not right child, make connections
        if (successor != delNode.getRightChild())
        {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(delNode.getRightChild());
        }

        return successor;
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
            System.out.print(localRoot.getData() + " ");
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
            System.out.print(localRoot.getData() + " ");
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
            System.out.print(localRoot.getData() + " ");
        }
    }

    /**
     * Display current instance of binary tree with Breadth-First Traversal.<p>
     * 
     *  Create a queue to store nodes to be printed. 
     *  Put the root node in queue to start.
     *  While this queue is not empty, 
     *      dequeue the queue and print it,
     *      if this node have children, enqueue them.
     *  Until the queue is empty, that means all Nodes
     *  are printed.
     */
    public void displayTreeBFT()
    {
        Queue toPrint = new Queue();
        TreeNode current = this.root;

        
        if (this.root == null)
        {
            System.out.println("The tree is empty, nothing to print.");
            return;
        }
        
        System.out.print("Breadth-first traversal: ");
        toPrint.enqueue(current);

        while (!toPrint.isEmpty())
        {
            TreeNode temp = toPrint.dequeue();

            System.out.print(temp.getData() + " ");

            if (temp.getLeftChild() != null)
            {
                toPrint.enqueue(temp.getLeftChild());
            }

            if (temp.getRightChild() != null)
            {
                toPrint.enqueue(temp.getRightChild());
            }
        }

        System.out.println();
    }
}