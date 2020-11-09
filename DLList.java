package adts;

import interfaces.ListInterface;
import nodes.LLNode;

public class DLList<E> implements ListInterface<E> {

	//look into LLNode or DLLNode
	protected DLLNode<E> head;
	protected DLLNode<E> tail;
	protected DLLNode<E> current;
	

	@Override
	public E get(E element) {
		// TODO Auto-generated method stub
		DLLNode<E> current = head.getNext();
		while(current != null) {
			if(current.getInfo().equals(element))
				return current.getInfo();
			
			current = current.getNext();
		}
		return null;
	}

	public String toString() {
		String DLL = " ";
		DLLNode<E> current = head;
		while(current != null) {
			DLL = DLL + current.getInfo() + "\n";
			current = current.getNext();
		}
		return DLL;
	}

	
}
