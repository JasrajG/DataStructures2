package model;

public interface Deque<E> {
/* Queue operations */
public int size();
public boolean isEmpty();
public E first();
public void addLast(E e); /* enqueue */
public E removeFirst(); /* dequeue */
/* Extended operations */
public void addFirst(E e);
public E removeLast();
}