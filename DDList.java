package adts;

import interfaces.ListInterface;
import nodes.LLNode;

public class DDList<E extends Comparable<E>> implements ListInterface<E> {
	
	protected LLNode<E> head;
	protected LLNode<E> tail;
	protected LLNode<E> next;
	protected LLNode<E> prev;
	protected LLNode<E> curr;
	
	E current;
	E[] binarySearch = (E[]) new Object[size()];
	protected boolean found = false, isChanged = false;
	protected int size = 0;
	protected int location;
	
	
	
	//protected LLNode<E> current; 
	

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
		/*Remove the first existing item from the list such that item.equals(element), 
		where element is the parameter passed to the remove operation, and return true;
		if no such item exists, return false.*/
		return false;
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
		/* Return true if the list contains an item such that item.equals(element) 
	 	is true for the element passed as a parameter to the contains method; otherwise, return false.
		*/
		//Not sure if this the correct way this method is suppose to use find and find2 and have not tested 
		find(element);
		find2(element);
		if(found == true) {
			return true;
		}
			
		else
		return false;
	}

	@Override
	public E get(E element) {
		/* Return the first item on the list where item.equals(element) is true for the element \
		passed as a parameter to the get method; if no such item exists, return null.
		*/
		/*current = head.getNext();
		while(current != null) {
			if(current.getInfo().equals(element))
				return current.getInfo();
			
			current = current.getNext();
		}*/
		return null;
		
	}

	@Override
	public void resetIterator() {
		// resetIterator sets the current position for the getNextItem iterator to the first element on the list.


	}

	@Override
	public E getNextItem() {
		/*getNextItem returns the element at the "current" position on the list, 
		  updating the current pointer to point to the next element on the list. 
		  If the element returned is the last item on the list, set the value of
		  the current position to the first element on the list.
		 */
		return null;
	}
	
	
	public E getPrevItem() {
		
		return null;
	}

	public void find(E element) {
		//helper method doing a linear search
		found = false;
		location = 0;
		current = head.getInfo();
		resetIterator();
		while (current != null) {
			if (current.equals(element)) {
				found = true;
				return;
			}
			location++;
			current = getNextItem();
		}
		
	}
	
	public void find2(E element) {
		//Helper method using a binary search
		found = false;	// In the case that the find()/find2() methods were recently called
		resetIterator();
		if (isChanged) {
			binarySearch = (E[]) new Object[size()];	// Make a new array if the list has been changed
			for (int i = 0; i < size(); i++) {
				binarySearch[i] = getNextItem(); 
			}
		}
		int low = 0, high = size() - 1;
		location = high / 2;
		while (low < high) {
			if (((Comparable<E>)(binarySearch[location])).compareTo(element) == 0) {	// Cast binarySearch[location] to the Comparable<E> interface, then compare it. // Should this be a switch statement?
				found = true;
				return;
			}
			else if (((Comparable<E>)(binarySearch[location])).compareTo(element) > 0) {
				high = location;
				location = (high + low) / 2;	// It can't be high / 2 because low might not be 0.
			}
			else {
				low = location;
				location = (high + low) / 2;
			}
			
		}
	}

	
	/*public String toString(){
	//Return an appropriately formatted string that represents this list, showing the elements in sorted order.
		String DLL = " ";
		current = head;
		while(current != null) {
			DLL = DLL + current.getInfo() + "\n";
			current = current.getNext();
		}
		return DLL;
	}
*/
}
