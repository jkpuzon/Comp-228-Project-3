package apps;

import adts.SortedDoublyLinkedList;

public class Project3Test {
	
	public static void main(String[] args) {
		
		SortedDoublyLinkedList<String> list1 = new SortedDoublyLinkedList<String>();
		list1.add("Clarinet");
		System.out.println(list1.isEmpty());
		
		list1.add("Accordion");
		System.out.println(list1);
		
		list1.add("oboe");
		list1.add("viola");
		
		long startTime = System.nanoTime();
		System.out.println(list1.get("Clarinet"));
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println("Start: " + startTime);
		System.out.println("End: " + estimatedTime);
		
		startTime = System.nanoTime();
		System.out.println(list1.remove("Clarinet"));
		estimatedTime = System.nanoTime() - startTime;
		System.out.println("Start: " + startTime);
		System.out.println("End: " + estimatedTime);
		
		
		list1.add("Piano");
		
		startTime = System.nanoTime();
		System.out.println(list1.remove("Piano"));
		estimatedTime = System.nanoTime() - startTime;
		System.out.println("Start: " + startTime);
		System.out.println("End: " + estimatedTime);
		
		
		startTime = System.nanoTime();
		System.out.println(list1.remove("viola"));
		estimatedTime = System.nanoTime() - startTime;
		System.out.println("Start: " + startTime);
		System.out.println("End: " + estimatedTime);
		
		System.out.println(list1.size());
		
		
		startTime = System.nanoTime();
		System.out.println(list1.contains("Accordion"));
		estimatedTime = System.nanoTime() - startTime;
		System.out.println("Start: " + startTime);
		System.out.println("End: " + estimatedTime);
		
		startTime = System.nanoTime();
		System.out.println(list1.contains("viola"));
		estimatedTime = System.nanoTime() - startTime;
		System.out.println("Start: " + startTime);
		System.out.println("End: " + estimatedTime);
		
		
		System.out.println(list1.getNextItem());
		System.out.println(list1.getNextItem());
		list1.resetIterator();
		System.out.println(list1.getNextItem());
		
		System.out.println(list1.getPrevItem());
		System.out.println(list1.getPrevItem());
		list1.resetBackIterator();
		System.out.println(list1.getPrevItem());
		
		SortedDoublyLinkedList<String> list2 = new SortedDoublyLinkedList<String>();
		System.out.println(list2.remove("oboe"));
		
		System.out.println(list2.isEmpty());
		
		
	}
}
