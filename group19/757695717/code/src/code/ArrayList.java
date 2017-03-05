 package code;

public class ArrayList implements List {
	
	private int size = 0;
	
	private int CurrentCapacity = 0;
	
	private final int initCapacity = 12;
	
	private Object[] mAList = null;
	
	public ArrayList()
	{
		CurrentCapacity = initCapacity;
		mAList = new Object[initCapacity];
	}

	private void expansion()
	{
		Object[] oldAList = mAList;
		Object[] newAList = new Object[getNewCapacity()];
		System.arraycopy(oldAList, 0 , newAList, 0,oldAList.length);
		mAList = newAList;
	}
	
	private int getNewCapacity()
	{
		return(CurrentCapacity + CurrentCapacity>>1);
	}
	
	/**
	 * 插入一个元素到尾部
	 * @param o元素
	 */
	@Override
	public void add(Object o) {
		if(size == CurrentCapacity)
		{
			expansion();
		}
		mAList[size] = o;
		size++;
	}

	@Override
	public void add(int index, Object o) {
		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		if(size == CurrentCapacity)
		{
		
			expansion();
		}
		
		Object[] newAList = new Object[CurrentCapacity];
		System.arraycopy(mAList, 0, newAList, 0, index);
		System.arraycopy(mAList, index, newAList, index+1, size-index);
		newAList[index] = o;
		mAList = newAList;	
	}

	@Override
	public Object get(int index) {
		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		
		return mAList[index];
	}

	@Override
	public void remove(int index) {
		if(index < 0 ||index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		Object[] newAList = new Object[CurrentCapacity];
		System.arraycopy(mAList, 0, newAList, 0, index);
		System.arraycopy(mAList, index+1, newAList, index, size-index);
		mAList = newAList;
		size--;
	}

	@Override
	public int size() {
		
		return size;
	}
	
	
}

