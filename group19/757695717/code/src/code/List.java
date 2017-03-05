package code;

public interface List {
	public void add(Object o);
	public void add(int index, Object o);
	public Object get(int index);
	public void remove(int index);
	public int size();
}

