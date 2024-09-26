package com.example.project;

public class LinkedList<T> implements List<T>{
	private Node<T> head;
	private Node<T> current;
	
    public LinkedList() {
		head = current = null;
	}
	public boolean empty() {
		return head == null;
	}
	public boolean last() {
		return current.next == null;
	}
    public boolean full() {
        return false;
    }
    public void findFirst() {
        current = head;
    }
    public void findNext() {
        current = current.next;
    }
    public T retrieve() {
        return current.data;
    }
    public void update(T e) {
        current.data = e;
    }
    public void insert(T e) {
        if (empty()) {
            current = head = new Node<T>(e);
        } else {
            Node<T> tmp = current.next;
            current.next = new Node<T>(e);
            current = current.next;
            current.next = tmp;
        }
    }
    public void remove() {
        if (current == head) {
            head = head.next;
        } else {
            Node<T> tmp = head;
            while (tmp.next != current) {
                tmp = tmp.next;
            }
            tmp.next = current.next;
        }
        if (current.next == null) {
            current = head;
        } else {
            current = current.next;
        }
    }
    public T mostFrequentElement() {
        // Write the method mostFrequentElement, member of the class LinkedList, that returns
        // the most frequent element in the list. The most frequent element is the element
        // appearing the highest number of times. If one or more element appear the same
        // number of times, the one encountered earlier is returned.
        // Example 1.1. Given the list l : A, B, C, B, C, D, E, mostFrequentElement() returns
        // B.
    	
    	if(empty())
    		return null;
    	
    	T most = head.data;
    	int mostCount = 0, counter;
    	Node <T> tmp = head;
    	
    	//this is less efficient than using 2D array or a different type of linked list where nodes hold frequency and data type :( 
    	do {
    		Node <T> runner = head;
    		counter = 0;
    		if(mostCount == 0 || tmp.data != most) //count to find best if first element OR its not the same element as current most
	    		do {
	    			if(runner.data == tmp.data)
	    				counter++;
	    			runner = runner.next;
	    		}while (runner != null);
    		
    		if(counter > mostCount) {
    			most = tmp.data;
    			mostCount = counter;
    		}
    		
    		tmp = tmp.next;
    	} while (tmp != null);
    	
    	return most;
    }
}