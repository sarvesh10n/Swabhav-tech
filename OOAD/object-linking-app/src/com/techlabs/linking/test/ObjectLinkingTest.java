package com.techlabs.linking.test;

import com.techlabs.node.Node;

public class ObjectLinkingTest {

	public static void main(String args[]) {
		Node<Integer> node3 = new Node<>(3, null);
		Node<Integer> node2 = new Node<>(2, node3);
		Node<Integer> node1 = new Node<>(1, node2);

		printDetails(node1);

	}

	public static void printDetails(Node node) {

		while (node != null) {
			System.out.println(node);
			node=node.getNext();
		}
	}
}
