package com.techlabs.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class SwabhavQ<Student> implements Iterable<Student>{

	private LinkedList<Student> list = new LinkedList<Student>();

	public void enqueue(Student student) {
		list.addLast(student);
	}

	public Student dequeue() {
		return list.removeFirst();
	}

	public int getQueueSize() {
		return list.size();
	}
	
	public LinkedList<Student> getList()
	{
		return list;
	}

	@Override
	public Iterator<Student> iterator() {
		// TODO Auto-generated method stub
		return  list.iterator();
	}
}
