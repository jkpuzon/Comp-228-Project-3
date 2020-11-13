package adts;

import interfaces.ListInterface;
import nodes.LLNode;

public class DLList<E> implements ListInterface<E> {
	
	protected boolean found;
	protected int size;
	protected LLNode<E> forwardIterator;
	protected LLNode<E> backwardIterator;
	protected LLNode<E> head;
	protected LLNode<E> tail;
	protected LLNode<E> location;
	protected LLNode<E> current;

	@Override
	public void add(E element) {
		LLNode<E> newNode = new LLNode<E>(element);
		if(isEmpty()) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.setNext(newNode);
		}
		
		
		
	}

	@Override
	public boolean remove(E element) {
		find(element);
		if(found){
			location.getPrev().setNext(location.getNext());
			location.getNext().setPrev(location.getPrev());
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
		
		return null;
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
		return forwardIterator.getNext().getInfo();
	}
	
	public E getPrevItem() {
		
		return null;
	}

	public E find(E element) {
		
		return null;
	}
	
	public E find2(E element) {
		
		return null;
	}
	
	public String toString(){
		
	}

}
