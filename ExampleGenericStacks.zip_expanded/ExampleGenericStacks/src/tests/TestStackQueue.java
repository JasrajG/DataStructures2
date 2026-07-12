package tests;

import static org.junit.Assert.*;
import model.StackQueue;
import model.CircularArrayQueue;
import model.Queue;

import org.junit.Test;

public class TestStackQueue {

	@Test
	public void test() {
		StackQueue<String> q = new StackQueue<String>();
		q.enqueue("Alan"); /* dynamic binding */
		q.enqueue("Mark"); /* dynamic binding */
		q.enqueue("Tom"); /* dynamic binding */
		assertTrue(q.size() == 3 && !q.isEmpty());
		assertEquals("Alan", q.first());
	}
	
	
	@Test
	public void test2() {
		Queue<String> q = new CircularArrayQueue<String>();
		q.enqueue("Alan"); /* dynamic binding */
		q.enqueue("Mark"); /* dynamic binding */
		q.enqueue("Tom"); /* dynamic binding */
		assertTrue(q.size() == 3 && !q.isEmpty());
		assertEquals("Alan", q.first());
	}

}