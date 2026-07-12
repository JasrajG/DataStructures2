package model;

public class CircularArrayQueue<E> implements Queue<E>{
int r;
int f;
private final int N = 1000; 
private E[] data; 


	@SuppressWarnings("unchecked")
	public CircularArrayQueue() {
		r=0;
		f=0;
		data = (E[]) new Object[N]; 
	}

	@Override
	public int size() {
		if (r>=f) {
			return (r-f);
		}
		else {
		return (r + (N-f));
		}
		
	}

	@Override
	public boolean isEmpty() {
		if(r==f) {
		return true;}
		else {
			return false;
		}
	}

	@Override
	public E first() {
		if (this.size()==0) {
			throw new IllegalArgumentException();
		}
		else {
			return data[f];
		}
	}

	@Override
	public void enqueue(E e) {
		data[r]=e;
		r++;
		r=r%N;
		
	}

	@Override
	public E dequeue() {
		E first_element = data[f];
		data[f] = null;
		f++;
		f=f%N;
		return first_element;
	}

	
}
