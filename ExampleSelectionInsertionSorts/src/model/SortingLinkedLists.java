package model;

public class SortingLinkedLists {

	
	public void selectionSort(DoublyLinkedList<Integer> list, int n) {
		
	
		
		int s = list.getSize();
		
		
		
		Node <Integer> target = list.getFirst();
		
		for(int j= 0; j<list.getSize(); j++) {
			int min = target.getElement();
			
			Node<Integer> current2 = target;
			Node<Integer> current1 = target;		
			
			for (int i = 0; i< s;i++) {
				if (current2.getElement() < min) {
					current1=current2;
				}
			}
			list.remove(current1);
			list.addBetween(current1.getElement(), target.getPrev(), target);
			s--;
			target=current1;
		
		}
	}
	
	
	
	
}
