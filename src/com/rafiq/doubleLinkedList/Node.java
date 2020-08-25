package com.rafiq.doubleLinkedList;

public class Node {
	private int data;
	private Node next;
	private Node pre;

	public Node() {
	}

	public Node(int data, Node next, Node pre) {
		this.data = data;
		this.next = next;
		this.pre = pre;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPre() {
		return pre;
	}

	public void setPre(Node pre) {
		this.pre = pre;
	}
}
