@Override
	public E getNextItem() {
		E next = forwardIterator.getInfo();
		forwardIterator = forwardIterator.getNext();
		if (forwardIterator == this.size - 1) {
		forwardIterator = this.size;
		}
	}	

@Override
	public E getPrevItem() {
		E prev = backwardsIterator.getInfo();
		backwardsIterator = backwardsIterator.getPrev();
		if (backwardsIterator == this.size - 1) {
		backwardsIterator = this.size;
		}
	}	
