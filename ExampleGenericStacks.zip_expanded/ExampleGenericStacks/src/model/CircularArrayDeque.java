package model;

public class CircularArrayDeque<E> implements Deque<E>{
	int r;
	int f;
	private final int N = 1000; 
	private E[] data; 


		@SuppressWarnings("unchecked")
		public CircularArrayDeque() {
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
	public void addLast(E e) {
		data[r]=e;
		r++;
		r=r%N;
		
	}

	@Override
	public E removeFirst() {
		E first_element = data[f];
		data[f] = null;
		f++;
		f=f%N;
		return first_element;
	}

	@Override
	public void addFirst(E e) {
		f--;
		if (f<0) {
			f=N-1;
		}
		data[f]=e;
		
	}

	@Override
	public E removeLast() {
		E last_element = data[r];
		data[r] = null;
		r--;
		if (r<0) {
			r=N-1;
		}
		
		return last_element;
	}

}
