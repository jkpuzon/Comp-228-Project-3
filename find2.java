import java.util.Arrays;

public class find2 {
	protected void find2(E target) {
		// Do nothing if list is empty or target is null
		
		if (target == null  || isEmpty())  return;	
		resetIterator(); 
		if(change = true) {
			
		    // convert the linked list to a sorted array
	        this.sortArray = toSortedArray() ;
		}
		System.out.println("Sorted array:");
		for (int i = 0; i < sortArray.length; i++ )
			System.out.println( "sortArray [ " + i + "] = " + sortArray[i]);
		int idx = Arrays.binarySearch(sortArray, target);
		System.out.println("idx of target = " + idx);
		 if (idx == -1) {
		  location = null;               // not found;                     
          found = false;
		}
         else {
             resetIterator();

              E item = sortArray[idx];

              while (hasNext() == true) {

                     System.out.println("current = " + current.getInfo());

                     if (current.getInfo( ).equals(item)) {
                	
                         System.out.println("Found " + current.getInfo());

                         location = current;

                          break;

                     } 

                      else {

                         current = current.getNext();

                         continue;

                     }

                }             

         }

		}


	protected E[]  toSortedArray() {
		E[] array = (E[]) new Object [size()];
		E item = null;
		System.out.println("Converting linked list to array");
		// Traverse  the linked list in order;  add elements to the array
		while (hasNext() == true) {
			item = getNextItem();
			array[index++] = item;
			System.out.println("adding " + item);
		}
		System.out.println("The array before sorting: ");
		for (int i = 0; i < size(); i++) {
			System.out.println(array[i]);
			
		}
	
		return array; 
	}
}
