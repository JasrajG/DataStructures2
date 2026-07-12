package model;

public interface Queue<E> {
	public int size();
	public boolean isEmpty();
	public E first();
	public void enqueue(E e);
	public E dequeue();
	
}
