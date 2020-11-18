package adts;

import interfaces.ListInterface;
import nodes.DLLNode;

public class DDList<E extends Comparable<E>> implements ListInterface<E> {
	
	protected LLNode<E> head;
	protected LLNode<E> tail;
	protected LLNode<E> next;
	protected LLNode<E> prev;
	protected LLNode<E> curr;
	protected DLLNode<E> location = null;
	
	protected DLLNode<E> forwardIterator;
	protected DLLNode<E> backwardIterator;
	
	protected boolean found = false;
	protected boolean isChanged = false;
	protected int size = 0;

	
	
	

	

	public DDList() {
		// TODO Auto-generated constructor stub
		head =null;
		tail = null;
		next = null;
		prev = null;
		size = 0;
		
	}

	@Override
	public void add(E element) {
		// Add the element passed as a parameter to the appropriate position in the list so that the list remains sorted.
		
		//Adding the first element in the list
		if(size == 0) {
			head = new DLLNode<E>(element);
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
				DLLNode<E> newNode = new DLLNode<E>(element);
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
						
						DLLNode<E> newNode = new DLLNode<E>(element);
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
		DLLNode<E> newNode = new DLLNode<E>(element);
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
			else if(location.getPrev() == null) {
				head = head.getNext();
				head.getPrev().setInfo(null);
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
		//return the number of elements on the list
		return size;
	}

	@Override
	public boolean isEmpty() {
		//if there are no elements on the list return true, otherwise return false
		return (size == 0);
	}

	@Override
	public boolean contains(E element) {
		
		find(element);
		//find2(element);
		if(found == true) {
			return true;
		}
			
		else
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
		// resetIterator sets the current position for the getNextItem iterator to the first element on the list.
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

	
	public String toString(){
	//Return an appropriately formatted string that represents this list, showing the elements in sorted order.
		String str = " ";
		DLLNode<E> current = head;
		while(current != null) {
			str = str + current.getInfo() + "\n";
			current = current.getNext();
		}
		return str;

}
