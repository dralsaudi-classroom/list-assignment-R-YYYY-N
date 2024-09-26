package com.example.project;

public class ListTester {
    public static <T> void circularLeftShift(List <T> list, int n)
    {
        // Write the method circularLeftShift, user of List ADT, that takes as input a non-empty
        // List list and an integer n > 0 and performs n circular left shift of the list.
        // Example 2.1. Given the list l : A, B, C, D, E, circularShiftLeft(l, 1) results in
        // B, C, D, E, A, circularShiftLeft(l, 2) results in C, D, E, A, B.
    	if(!list.empty() && n > 0) {
    		list.findFirst();
    		for(int i = 0; i < n; i++) {
    			T temp = list.retrieve();
    			while(!list.last())
    				list.findNext();
    			list.insert(temp);
    			list.findFirst();
    			list.remove();
    		}
    	}
    }
    
    public static <T> void reverseCopy(DLL<T> l1, DLL<T> l2)
    {
        // Write the method reverseCopy, user of DoubleLinkedList, which copies the elements
        // of l1 to l2 in reverse order. The list l1 must not change. Assume that l2 is empty.
        // The method signature is public static <T> void reverseCopy(DoubleLinkedList<T> l1,
        // DoubleLinkedList<T> l2).
        // Example 4.1. If l1 : A ↔ B ↔ C ↔ D, then calling reverseCopy(l1, l2) results in
        // l2 : D ↔ C ↔ B ↔ A.
    	if(!l1.empty()) {
    		while(!l1.last())
        		l1.findNext();
        	
        	while(!l1.first()) {
        		l2.insert(l1.retrieve());
        		l1.findPrevious();
        	}
        	l2.insert(l1.retrieve());
    	}
    }
    
    public static <T> void printList(List <T> list) {
    	list.findFirst();
		while(!list.last()) {
			System.out.print(list.retrieve() + ", ");
			list.findNext();
		}
		System.out.println(list.retrieve());
    }
    
//    public static void main(String[] args) {
//    	DLL <Character> list1 = new DLL<Character>();
//    	list1.insert('A');
//    	list1.insert('B');
//    	list1.insert('C');
//    	list1.insert('D');
//    	list1.insert('E');
//    	list1.insert('F');
//    	list1.printList();
//    	System.out.println();
//    	DLL <Character> list2 = new DLL<Character>();
//    	reverseCopy(list1, list2);
//    	list2.printList();
//    	
//    }
}
