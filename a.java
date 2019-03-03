/**
 * a
 */
class Queue 
{
    Node front;
    Node back;
    int size;
    
    public Queue()
    {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    public boolean isEmpty()
    {
        if (this.size == 0)
        {
            return true;
        }
        else return false;
    }

    public boolean enqueue(Node toEnqueue)
    {
        if (this.size == 0)
        {
            this.front = toEnqueue;
            this.back = toEnqueue;
            this.size++;
        }
        else
        {

        }
    }

    private boolean validNode(Node toValidate)
    {
        
    }
}