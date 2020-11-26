package apps;

import adts.DLList;

public class DLLTest {

	public static void main(String[] args) {
		
		long[] times = new long[5];
		
		DLList<String> list1 = new DLList<>();
		
		System.out.println("Before the adds is the list empty?: " + list1.isEmpty() + "\n");
		
		list1.add("Clarinet");
		list1.add("Accordion");
		list1.add("oboe");
		list1.add("viola");
		list1.add("guitar");
		list1.add("drums");
		list1.add("bass");
		list1.add("piano");
		list1.add("triangle");
		
		System.out.println("After the adds is the list empty?: " + list1.isEmpty() + "\n");
		System.out.println("The size of this list is: " + list1.size() + "\n");
		System.out.println("HEAD OF LIST: \n" + list1 + "");
		
		System.out.println("Is \"guitar\" removed?: " + list1.remove("guitar") + "\n");
		System.out.println("The size of the list after remove is: " + list1.size() + "\n");
		
		System.out.println("List after guitar remove");
		System.out.println("HEAD OF LIST: \n" + list1 + "");
		
		System.out.println("Can we remove \"guitar\" again?: " + list1.remove("guitar") + "\n");
		
		list1.resetIterator();
		System.out.println("Lets get the next item on the list from the head side: " + list1.getNextItem());
		System.out.println("Lets get the next item again-------------------------: " + list1.getNextItem() + "\n");
		
		list1.resetBackIterator();
		System.out.println("Lets get the previous item on the list from the tail side: " + list1.getPrevItem());
		System.out.println("Lets get the previous item again-------------------------: " + list1.getPrevItem() + "\n");
		
		long startTime = System.nanoTime();
		System.out.println("Does the list contain \"viola\"?: " + list1.contains("viola"));
		long estimatedTime = System.nanoTime() - startTime;
		times[0] = estimatedTime;
		
		startTime = System.nanoTime();
		System.out.println("Does the list contain \"oboe\"?: " + list1.contains("oboe"));
		estimatedTime = System.nanoTime() - startTime;
		times[1] = estimatedTime;
		
		startTime = System.nanoTime();
		System.out.println("Does the list contain \"bass\"?: " + list1.contains("bass"));
		estimatedTime = System.nanoTime() - startTime;
		times[2] = estimatedTime;
		
		startTime = System.nanoTime();
		System.out.println("Does the list contain \"drums\"?: " + list1.contains("drums"));
		estimatedTime = System.nanoTime() - startTime;
		times[3] = estimatedTime;
		
		startTime = System.nanoTime();
		System.out.println("Does the list contain \"guitar\"?: " + list1.contains("guitar")); 
		estimatedTime = System.nanoTime() - startTime;
		times[4] = estimatedTime;
		
		System.out.println("\nLets retrive \"drums\" from the list: " + list1.get("drums"));
		
		System.out.println("\nLets attempt to retrieve \"guitar\" which isn't on the list: " + list1.get("guitar"));
		
		System.out.println("\nLets attempt to remove \"guitar\" which isn't on the list" + list1.remove("guitar"));
		
		double avgTimes = 0;
		for(int i = 0; i < times.length; i++) {
			avgTimes += times[i];
		}
		
		avgTimes = avgTimes/times.length;
		
		
		// To test the times for both finds run this program twice and just comment out the other method from the main code in the 
		// contains method to test
		System.out.println("The search takes an average time of " + avgTimes + " nano seconds to search");

		
		DLList<Integer> list2 = new DLList<>();
		
		System.out.println("\n\nLets test out an int list of one item:");
		
		
		list2.add(100);
		
		
		System.out.println(list2);
		
		System.out.println("\nCan we remove the only item \"100\"?: " + list2.remove(100) + "\n");
		
		System.out.println("\nThe list after the remove: ");
		System.out.println(list2);
		
		System.out.println("\nCan we remove an item not on the list?: " + list2.remove(100));
		
		
		
	
	}

}
