
class Queue
{
    Object t[];
    int front,rear;
    int capacity;
    
    Queue()
    {
        capacity=20;
        t=new Object[20];
        front=rear=-1;     
    }
    
    Queue(int c)
    {
        capacity=c;
        t=new Object[capacity];
        front=rear=-1;  
    }
    
    boolean isEmpty()
    {
        if(front==-1&&rear==-1)
            return true;
        else
            return false;
    }

    boolean isFull()
    {
        if(rear==capacity-1)
            return true;
        else
            return false;
    }
    
    
    void ensureCapacity()
    {
    	Object b[];
    	capacity=capacity*2; //double the size of queue
    	
    	b=new Object[capacity];
    	
    	System.arraycopy(t, 0, b, 0, t.length);
    		
    	t=b;
    	
    }

    void enqueue(Object f)
    {
        if(isFull())
        ensureCapacity();
        
        
        t[++rear]=f;
        
        if(front==-1)
           front++;
        
    }
    
    Object dequeue()
    {
        if(isEmpty())
            return null;
        else
        {
            Object f=t[front];
            if(front==rear)
                front=rear=-1;
            else
             front++;
            return f;
        }
    }
    
    Object getFront()
    {
        return t[front];
    }
    
    Object getRear()
    {
        return t[rear];
    }
    
}