package adts;

import interfaces.ListInterface;
import nodes.DLLNode;

public class DLList<E> implements ListInterface<E> {
	
	protected boolean found = false;
	protected boolean isChanged = false;
	protected int size = 0;
	protected DLLNode<E> forwardIterator;
	protected DLLNode<E> backwardIterator;
	protected DLLNode<E> head;
	protected DLLNode<E> tail = null;
	protected DLLNode<E> location = null;
	protected DLLNode<E> current;

	public void add(E element) {
		DLLNode<E> newNode = new DLLNode<E>(element);

		if (head == null) {
	           head = tail = newNode;
	           head.setPrev(null);
	           size++;
	           return;
		}
		
		if(((Comparable<E>) newNode.getInfo()).compareTo(head.getInfo()) < 0) {
			newNode.setPrev(null);
			head.setPrev(newNode);
			newNode.setNext(head);
			head = newNode;
			size++;
			return;
		}
		
		if(((Comparable<E>) newNode.getInfo()).compareTo(tail.getInfo()) > 0) {
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail = newNode;
			size++;
			return;
		}
		
		DLLNode<E> temp = head.getNext();
		while(((Comparable<E>) temp.getInfo()).compareTo(newNode.getInfo()) < 0) {
			temp = temp.getNext();
		}
		
		temp.getPrev().setNext(newNode);
		newNode.setPrev(temp.getPrev());
		temp.setPrev(newNode);
		newNode.setNext(temp);
			
		size++;
	}
		
	@Override
	public boolean remove(E element) {
		find(element);
		//find2(element);
		if(found){
			// not head or tail side of list
			if(location.getNext() != null && location.getPrev() != null) {
				location.getPrev().setNext(location.getNext());
				location.getNext().setPrev(location.getPrev());
			}
			// tail end of list
			else if(location.getNext() == null) {
				tail = tail.getPrev();
				tail.setNext(null);
			}
			// head end of list
			else if(location == head) {
				head = head.getNext();
				head.setPrev(null);
			}
			size--;
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean contains(E element) {
		find(element);
		if(found) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public E get(E element) {
		find(element);
		if(found){
		    return location.getInfo();
		}
		else {	
		    return null;
		}
	}

	@Override
	public void resetIterator() {
		forwardIterator = head;
	}
	
	public void resetBackIterator() {
		backwardIterator = tail;
	}

	@Override
	public E getNextItem() {
		E temp = forwardIterator.getInfo();
		forwardIterator = forwardIterator.getNext();
		if(forwardIterator == null){
			forwardIterator = head;
		}
		return temp;
	}
	
	public E getPrevItem() {
		E temp = backwardIterator.getInfo();
		backwardIterator = backwardIterator.getPrev();
		if(backwardIterator == null) {
			backwardIterator = tail;
		}
		return temp;
	}

	public void find(E element) {
		found = false;
		location = null;
		resetIterator();
		while (forwardIterator.getInfo() != null) {
			if (forwardIterator.getInfo() == element) {
				location = forwardIterator;
				found = true;
				break;
			}
			forwardIterator = forwardIterator.getNext();
		}
	}
	
	public void find2(E element) {
		// Set found
		// Set location. Location is LLNode<E>.
		// binarySearch is 
		found = false;
		location = null;
		E match = null;
		resetIterator();
		
		
		E[] binarySearch = (E[]) new Object[size()];// Make a new array if the list has been changed
		for (int i = 0; i < size(); i++) {
			binarySearch[i] = forwardIterator.getNext().getInfo();
		}
		
		
		int low = 0, high = size() - 1, current = (high - low)/2;
		while (low <= high && found == false) {
			
			if (((Comparable<E>)binarySearch[current]).compareTo(element) == 0) {
				found = true;
				match = binarySearch[current];
			}
			else if (((Comparable<E>)binarySearch[current]).compareTo(element) > 0) {
				high = current -1;
				current = (high + low) / 2;
			}
			else {
				low = current +1;
				current = (high + low) / 2;
			}
		}
		resetIterator();
		while (forwardIterator != null) {
			if (forwardIterator.getInfo().equals(match)) {
				location = forwardIterator;
			}
			forwardIterator = forwardIterator.getNext();
		}
			
	}
		
	
	public String toString() {
		String str = "";
		DLLNode<E> current = head;
		while(current != null) {
			str = str + current.getInfo() + "\n";
			current = current.getNext();
		}
		return str;
	}
}
