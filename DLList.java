package adts;

import interfaces.ListInterface;
import nodes.LLNode;

public class DLList<E> implements ListInterface<E> {

	//look into LLNode or DLLNode
	protected LLNode<E> head;
	protected LLNode<E> tail;
	protected LLNode<E> location;
	
	

	@Override
	public E get(E element) {
		// TODO Auto-generated method stub
		find(element);
		if(found == true){
		    return location.getInfo();
		}
		else {	
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
