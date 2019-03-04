/**
 * a
 */
class Queue 
{
    private Node front;
    private Node end;
    private int size;
    
    public Queue()
    {
        this.front = null;
        this.end = null;
        this.size = 0;
    }

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

    public int size()
    {
        return this.size;
    }

    public boolean enqueue(TreeNode toEnqueue)
    {
        if (toEnqueue == null)
        {
            return false;
        }

        if (this.size == 0)
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

    public TreeNode dequeue()
    {
        if (this.size <= 0)
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

    public TreeNode peek()
    {
        if (this.size <= 0)
        {
            return null;
        }
        else 
        {
            return this.front.getTreeNode();
        }
    }
}

class TreeNode
{
    private int data;   // data to store
    private TreeNode leftChild;
    private TreeNode rightChild;

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

class Node
{
    private TreeNode treeNode;
    private Node next;

    public Node(TreeNode newTreeNode, Node newNext)
    {
        this.treeNode = newTreeNode;
        this.next = newNext;
    }

    public Node(TreeNode newTreeNode)
    {
        this.treeNode = newTreeNode;
        this.next = null;
    }

    /**
     * @return the treeNode
     */
    public TreeNode getTreeNode() 
    {
        return treeNode;
    }

    /**
     * @param treeNode the treeNode to set
     */
    public void setTreeNode(TreeNode treeNode) 
    {
        this.treeNode = treeNode;
    }

    /**
     * @return the next
     */
    public Node getNext() 
    {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Node next) 
    {
        this.next = next;
    }
}

class Tree
{
    private TreeNode root;
    private int treeSize;

    public Tree()
    {
        root = null;
        treeSize = 0;
    }

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

    private void preOrder(TreeNode localRoot) 
    {
        if (localRoot != null) 
        {
            System.out.print(localRoot.getData() + " ");
            preOrder(localRoot.getLeftChild());
            preOrder(localRoot.getRightChild());
        }
    }

    private void inOrder(TreeNode localRoot) 
    {
        if (localRoot != null) 
        {
            inOrder(localRoot.getLeftChild());
            System.out.print(localRoot.getData() + " ");
            inOrder(localRoot.getRightChild());
        }
    }

    private void postOrder(TreeNode localRoot) 
    {
        if (localRoot != null) 
        {
            postOrder(localRoot.getLeftChild());
            postOrder(localRoot.getRightChild());
            System.out.print(localRoot.getData() + " ");
        }
    }

    public void displayTree() 
    {
        Stack globalStack = new Stack();
        int nBlanks = 32;
        boolean isRowEmpty = false;

        globalStack.push(root);
        System.out.println("......................................................");

        while (isRowEmpty == false) 
        {
            Stack localStack = new Stack();

            isRowEmpty = true;
    
            for (int j = 0; j < nBlanks; j++)
            {
                System.out.print(' ');
            }
    
            while (globalStack.isEmpty() == false) 
            {
                TreeNode temp = (TreeNode) globalStack.pop();

                if (temp != null) 
                {
                    System.out.print(temp.getData());
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());
    
                    if (temp.getLeftChild() != null || temp.getRightChild() != null)
                    {
                        isRowEmpty = false;
                    }
                } 
                else 
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }

                for (int j = 0; j < nBlanks * 2 - 2; j++)
                {
                    System.out.print(' ');
                }
            } 

            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false)
            {
                globalStack.push(localStack.pop());
            }
        } 
        System.out.println("......................................................");
    }
  
}

class Stack
{
    private Node top;
    private int size;

    public Stack()
    {
        this.top = null;
        this.size = 0;
    }

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

    public int size()
    {
        return this.size;
    }

    public boolean push(TreeNode toPush)
    {
        if (toPush == null)
        {
            return false;
        }

        if (this.size == 0)
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

    public TreeNode pop()
    {
        if (this.size == 0)
        {
            return null;
        }

        TreeNode ret = this.top.getTreeNode();

        this.top = this.top.getNext();
        return ret;
    }

    public TreeNode peek()
    {
        return this.top.getTreeNode();
    }
}

