package adts;

import interfaces.ListInterface;
import nodes.LLNode;

public class DLList<E> implements ListInterface<E> {
	
	protected boolean found;
	protected LLNode<E> frontIterator
	protected LLNode<E> backIterator;
	protected LLNode<E> head;
	protected LLNode<E> tail;
	protected LLNode<E> location; 

	@Override
	public void add(E element) {
		
		
	}

	@Override
	public boolean remove(E element) {
		find(element);
		if(location.getInfo() != null){
			location.getPrev().setNext(location.getNext());
			location.getNext().setPrev(location.getPrev());
			size--;
			return true;
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
		
		return false;
	}

	@Override
	public E get(E element) {
		
		return null;
	}

	@Override
	public void resetIterator() {
		frontIterator = head;
	}
	
	public void resetBackIterator() {
		backIterator = tail;
	}

	@Override
	public E getNextItem() {
		return frontIterator.getNext().getInfo();
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
