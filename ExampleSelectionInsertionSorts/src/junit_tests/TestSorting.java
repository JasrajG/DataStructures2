package junit_tests;
import static org.junit.Assert.*;

import org.junit.Test;

import model.Sorting;

public class TestSorting {

	/*
	 * Tests related to selection sort.
	 */
	
	@Test
	public void testSelectionSort_a() {
		int[] a = {};
		int[] sorted = {};
		Sorting s = new Sorting();
		s.selectionSort(a, a.length);
		assertArrayEquals(sorted, a);
	}
	
	@Test
	public void testSelectionSort_b() {
		int[] a = {3, 1, 4, 2};
		int[] sorted = {1, 2, 3, 4};
		Sorting s = new Sorting();
		s.selectionSort(a, a.length);
		assertArrayEquals(sorted, a);
	}
	
	@Test
	public void testSelectionSort_c() {
		int[] a = {8, 5, 3, 6, 10, 1, 4, 2, 7, 9};
		int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Sorting s = new Sorting();
		s.selectionSort(a, a.length);
		assertArrayEquals(sorted, a);
	}
	
	/*
	 * Tests related to insertion sort.
	 */
	
	@Test
	public void testInsertionSort_a() {
		int[] a = {};
		int[] sorted = {};
		Sorting s = new Sorting();
		s.insertionSort(a, a.length);
		assertArrayEquals(sorted, a);
	}
	
	@Test
	public void testInsertionSort_b() {
		int[] a = {3, 1, 4, 2};
		int[] sorted = {1, 2, 3, 4};
		Sorting s = new Sorting();
		s.insertionSort(a, a.length);
		assertArrayEquals(sorted, a);
	}
	
	@Test
	public void testInsertionSort_c() {
		int[] a = {8, 5, 3, 6, 10, 1, 4, 2, 7, 9};
		int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Sorting s = new Sorting();
		s.insertionSort(a, a.length);
		assertArrayEquals(sorted, a);
	}

}
