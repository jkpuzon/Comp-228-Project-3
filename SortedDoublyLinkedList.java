package adts;

import interfaces.ListInterface;
import nodes.LLNode;

public class SortedDoublyLinkedList<E> implements ListInterface {
	LLNode<E> head, tail;
	E current;
	private boolean found = false, isChanged = false;
	private int location = 0;
	@SuppressWarnings("unchecked")
	E[] binarySearch = (E[]) new Object[size()];

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remove(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetIterator() {
		// TODO Auto-generated method stub
		
	}
	
	private void resetBackIterator() {
		
	}

	@Override
	public E getNextItem() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public E getPrevItem() {
		return null;
	}
	
	public void find(E element) {
		found = false;
		location = 0;
		current = head.getInfo();
		resetIterator();
		while (current != null) {
			if (current.equals(element)) {
				found = true;
				return;
			}
			location++;
			current = getNextItem();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void find2(E element) {
		found = false;	// In the case that the find()/find2() methods were recently called
		resetIterator();
		if (isChanged) {
			binarySearch = (E[]) new Object[size()];	// Make a new array if the list has been changed
			for (int i = 0; i < size(); i++) {
				binarySearch[i] = getNextItem(); 
			}
		}
		int low = 0, high = size() - 1;
		location = high / 2;
		while (low < high) {
			if (((Comparable<E>)(binarySearch[location])).compareTo(element) == 0) {	// Cast binarySearch[location] to the Comparable<E> interface, then compare it. // Should this be a switch statement?
				found = true;
				return;
			}
			else if (((Comparable<E>)(binarySearch[location])).compareTo(element) > 0) {
				high = location;
				location = (high + low) / 2;	// It can't be high / 2 because low might not be 0.
			}
			else {
				low = location;
				location = (high + low) / 2;
			}
			
		}
	}
}
