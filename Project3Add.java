public static add(E element) {
		LLNode current;
		
		LLNode<E> newNode = new LLNode<E>(element);
		if (head == null) {
            head = newNode;
		}
		else if (head.getInfo().compareTo(newNode.getInfo()) > 0){
			newNode.setNext(head);
			newNode.getPrev().setInfo(newNode);
			head= newNode;
		}
		else {
			current = head;
			 while(current.getNextItem() != null && current.getNextItem() < newNode.getInfo()) {
				 current = current.getNextItem();
			 }
			newNode.setNext(current.getNextItem());
			
			if (current.getNextItem() != null) {
				newNoew.getNextItem.setPrevItem(newNode);
			}
			current.setNextItem(newNode);
			newNode.setPreV(current);
			 
		}
  }