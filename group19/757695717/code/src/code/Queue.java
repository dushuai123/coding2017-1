package code;

public class Queue {
	
	private int size = 0;
	private int CurrentCapacity = 0;
	Object[] mQueue = null;
	
	public Queue()
	{
		mQueue = new Object[CurrentCapacity]; 
	}
	public void enQueue(Object o){
		if(size == CurrentCapacity)
		{
			expansion();
		}
		
		mQueue[size] = o;
		size ++;
		
	}
	
	private void expansion()
	{
		CurrentCapacity = CurrentCapacity + CurrentCapacity>>1;
	}
	
	public void deQueue(){
		
		mQueue[size-1] = null;
		size --;
	}
	
	public boolean isEmpty(){
		
		if(size == 0)
		{
			return true;
		}
		return false;
	}
	
	public int size(){
		
		return size;
	}
}

