package com.techlabs.node;

public class Node<T> {

	private Integer data;
	private Node<T> next;
	
	public Node()
	{
		
	}
	
	public Node(Integer data, Node<T> next) {
		super();
		this.data = data;
		this.next = next;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	@Override
	public String toString()
	{
		return data.toString();
	}
	
	
}
