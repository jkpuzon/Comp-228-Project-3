package adts;

import interfaces.ListInterface;
import nodes.LLNode;

public class DLList<E> implements ListInterface<E> {
	
	protected int frontIterator, backIterator;
	protected LLNode<E> head;
	protected LLNode<E> tail;
	
	public DLList() {
		
	}

	@Override
	public void add(E element) {
		
		
	}

	@Override
	public boolean remove(E element) {
		
		return false;
	}

	@Override
	public int size() {
		
		return 0;
	}

	@Override
	public boolean isEmpty() {
		
		return false;
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
		
		
	}
	
	public void resetBackIterator() {
		
	}

	@Override
	public E getNextItem() {
		
		return null;
	}

	public E find(E element) {
		
		return null;
	}
	
	public E find2(E element) {
		
		return null;
	}

}
