package nodes;

public class DLLNode<E> {

	private E info;
	private DLLNode<E> next;
	private DLLNode<E> prev;
	
	public DLLNode(E info) {
		this.info = info;
		next = null;
		prev = null;
	}
	
	public void setInfo(E info) {
		this.info = info;
	}
	
	public E getInfo() {
		return info;
	}
	
	public void setNext(DLLNode<E> reference) {
		this.next = reference;
	}
	
	public DLLNode<E> getNext(){
		return next;
	}
	
	public void setPrev(DLLNode<E> reference) {
		this.prev = reference;
	}
	
	public DLLNode<E> getPrev(){
		return prev;
	}
}
