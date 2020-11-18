public void add(E element) {

	DLLNode<E> current;

	DLLNode<E> newNode = new DLLNode<E>(element);

	if (head == null) {
           head = newNode;
           tail = new DLLNode(null);
           tail.setPrev(head);
           head.setNext(tail);
	}
	else if (((Comparable<E>) head.getInfo()).compareTo(newNode.getInfo()) >= 0){
		current= head;
		head = newNode;
		head.setNext(current);
		current.setPrev(head);
	}
	else {
		current = head.getNext();
			
		for(int i =1; i <this.size() && current.getData() != null; i ++) {
			if((Comparable<E>) current.getInfo().compareTo(newNode.getInfo()) > 0) {
				current = current.getNext();
			}
			else if((Comparable<E>) current.getInfo().compareTo(newNode.getInfo()) <= 0){
				current.getPrev().setNext(newNode);
				newNode.setNext(current);
				newNode.setNext(current.getPrev());
				current.setPrev(newNode);
				break;
			}
		}
		if ( current == tail ) {
			tail = newNode;
			current.setNext(tail);
			tail.setPrev(current);
			  
		}
 	}
		
	size++;
}
