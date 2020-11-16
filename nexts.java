@Override
	public E getPrevItem() {
		E prev = list[currentBackIteratorPos];
		currentBackIteratorPos--;
		if (currentBackIteratorPos == this.size - 1) {
		currentInteratorPos = this.size;
		}
	}	

@Override    
    public E getNextItem() {
        E next = list[currentIteratorPos];
        currentIteratorPos++;
        if (currentIteratorPos == this.size) {
            currentInteratorPos = 0;
        }
    }