package test;

import java.lang.reflect.Array;

public class ArrayStack<E> {
private E[] data;
	
@SuppressWarnings("unchecked")
	public ArrayStack(){
		data = (E[]) new Object[10];
	}


public E getData(int i) {
	
	return (E) data[i];
}

}
