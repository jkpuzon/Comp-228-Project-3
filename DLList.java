package adts;

import interfaces.ListInterface;
import nodes.LLNode;

public class DLList<E> implements ListInterface<E> {
	
	protected boolean found;
	protected boolean isChanged = false;
	protected int size = 0;
	protected LLNode<E> forwardIterator;
	protected LLNode<E> backwardIterator;
	protected LLNode<E> head;
	protected LLNode<E> tail;
	protected LLNode<E> location;
	protected LLNode<E> current;

	@Override
	public void add(E element) {
		// Add the element passed as a parameter to the appropriate position in the list so that the list remains sorted.
		
		//Adding the first element in the list
		if(size == 0) {
			head = new LLNode<E>(element);
			next = null;
			prev = null;
			tail = head;
			size++;
			return;
		}
		else 
		{//new Node is less than the head and is going to be inserted before head
			if(element.compareTo(head.getInfo()) < 0) {
				
				//Creates a new node with head next = head and prev = null
				LLNode<E> newNode = new LLNode<E>(element);
				newNode.setNext(head);
				newNode.setPrev(null);
				
				//Set the old head previous = newNode
				head.setPrev(newNode);
				//new node will become new head
				head = newNode;
				//Increase size which represents number of elements in the list
				size++;
				return;
				
			}
			else 
			{
				//Inserting after head but before tail- somewhere in the middle of the list
				curr = head.getNext();
				while(curr != null)
				{
					if(element.compareTo(curr.getInfo()) <= 0)
					{
						//inserting before current 
						
						LLNode<E> newNode = new LLNode<E>(element);
						newNode.setNext(curr);
						newNode.setPrev(curr.getPrev());
						
						curr.getPrev().setNext(newNode);
						
						curr.setPrev(newNode);
						size++;
						return;
					}
					curr = curr.getNext();
				}
				//Inserting at the tail
		LLNode<E> newNode = new LLNode<E>(element);
		newNode.setNext(null);
		newNode.setPrev(tail);
		
		tail.setNext(newNode);
		tail = newNode;
		size++;
		return;
			}
		}
			
		
		
	}

	@Override
	public boolean remove(E element) {
		find(element);
		if(found){
			// not head nor tail side of list
			if(location.getNextItem() != null && location.getPrevItem() != null) {
				location.getPrevItem().setNext(location.getNext());
				location.getNextItem().setPrev(location.getPrevItem());
			}
			// tail end of list
			else if(location.getNext() == null) {
				tail = tail.getPrevItem();
				tail.setNext(null);
			}
			// head end of list
			else if(location.getPrevItem() == null) {
				head = head.getNextItem();
				head.getPrevItem().setInfo(null);
			}
			size--;
			return true;
		}
		else{
			return false;
		}
		return false;
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
		
		return false;
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
		forwardIterator = forwardIterator.getNext();
		return forwardIterator.getInfo();
	}
	
	public E getPrevItem() {
		
		return null;
	}

	public void find(E element) {
		found = false;
		location = null;
		resetIterator();
		while (forwardIterator.getInfo() != null) {
			forwardIterator.getNext();
			if (forwardIterator.getInfo() == element) {
				location = forwardIterator;
				found = true;
				break;
			}
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
		
		
		int low = 0, high = size() - 1, current = 0;
		while (low < high) {
			if (((Comparable<E>)binarySearch[current]).compareTo(element) == 0) {
				found = true;
				match = binarySearch[current];
			}
			else if (((Comparable<E>)binarySearch[current]).compareTo(element) > 0) {
				high = current;
				current = (high + low) / 2;
			}
			else {
				low = current;
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
		String str = " ";
		LLNode<E> current = head;
		while(current != null) {
			str = str + current.getInfo() + "\n";
			current = current.getNext();
		}
		return str;
	}

}
