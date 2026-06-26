package model;

public class Sorting {
	public void selectionSort(int[] a, int n) {
		for (int i = 0; i <= (n - 2); i ++) {
			int minIndex = i;
			for (int j = i; j <= (n - 1); j ++) {
				if (a[j] < a[minIndex]) { 
					minIndex = j; 
				}
			}
			int temp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = temp;
		}
	}

	public void insertionSort(int[] a, int n) { 
		for (int i = 1; i < n; i ++) {
			int current = a[i];
			int j = i;
			while (j > 0 && a[j - 1] > current) {
				a[j] = a[j - 1];
				j --;
			}
			a[j] = current;
		}
	}
	
	

	
	
}
