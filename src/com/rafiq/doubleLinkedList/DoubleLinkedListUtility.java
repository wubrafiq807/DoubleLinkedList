package com.rafiq.doubleLinkedList;

import java.util.Scanner;

public class DoubleLinkedListUtility {

	public Scanner myScanner = new Scanner(System.in);
	private Node head = null;
	private Node tempNode = null;
	private Node tail = null;

	public void create() {
		Integer choice = 1;
		String input = null;
		while (choice != 0) {
			Node newNode = createNewNode();
			if (head == null) {
				head = tail = newNode;
			} else {
				tail.setNext(newNode);
				newNode.setPre(tail);
				tail = newNode;
			}
			System.out.println("Press any number to add more node or press 0 to stop to adding node:");
			myScanner.nextLine();
			input=myScanner.nextLine();
			while (!isObjectInteger(input)) {
				System.err.println("Please enter an integer value:");
				input=myScanner.nextLine();
			}
			choice = Integer.parseInt(input);
		}
	}

	public void display() {
		System.out.println("The linked list:");
		tempNode = head;
		while (tempNode != null) {
			System.out.print(tempNode.getData());
			System.out.print(tempNode.getNext() != null ? "->" : "");
			tempNode = tempNode.getNext();
		}
		System.out.println();
	}

	public void insertAtbeginning() {
		Node newNode = createNewNode();
		head.setPre(newNode);
		newNode.setNext(head);
		head = newNode;
	}

	public void insertAtEnd() {
		Node newNode = createNewNode();
		if (head == null) {
			head = tail = newNode;
		} else {
			tail.setNext(newNode);
			newNode.setPre(tail);
			tail = newNode;
		}
	}

	public void insertAtGivenPosition() {

		int count = 1;
		System.out.println("Please enter the position");
		int position = myScanner.nextInt(), size = getSize();
		if (position > size || position < 0) {
			System.err.println("Invalid position");
		} else {
			if (position == 1) {
				insertAtbeginning();
			} else if (position == size) {
				insertAtEnd();
			} else {
				Node newNode = createNewNode();
				tempNode = head;
				while (count < position - 1) {
					tempNode = tempNode.getNext();
					count++;
				}
				newNode.setPre(tempNode);
				newNode.setNext(tempNode.getNext());
				tempNode.setNext(newNode);
				tempNode.getNext().setPre(newNode);
			}
		}

	}

	public void insertAfterGivenPosition() {

		int count = 1;
		System.out.println("Please enter the position");
		int position = myScanner.nextInt();
		if (position > getSize() || position < 0) {
			System.err.println("Invalid position");
		} else {
			if (position == getSize()) {
				insertAtEnd();
			} else {
				Node newNode = createNewNode();
				tempNode = head;
				while (count < position) {
					tempNode = tempNode.getNext();
					count++;
				}
				newNode.setPre(tempNode);
				newNode.setNext(tempNode.getNext());
				tempNode.setNext(newNode);
				tempNode.getNext().setPre(newNode);
			}
		}

	}

	public void deleteFromTheBeginning() {
		if (getSize() < 1) {
			System.err.println("List is arleady empty .Can not be perform delete operation");
		} else {
			tempNode = head;
			head = tempNode.getNext();
			head.setPre(null);
			tempNode = null;
		}
	}

	public void deleteFromTheEnd() {
		if (getSize() < 1) {
			System.err.println("List is already empty .Can not be perform delete operation");
		} else {
			tempNode = tail;
			tail = tempNode.getPre();
			tail.setNext(null);
			tempNode = null;
		}
	}

	public void deleteFromGivenPosition() {
		System.out.println("Please enter the position:");
		int position = myScanner.nextInt(), size = getSize();
		if (size < 1) {
			System.err.println("List is already empty .Can not be perform delete operation");
		} else {
			if (position > size || position < 1) {
				System.err.println("Invalid position");
			} else {
				if (position == 1) {
					deleteFromTheBeginning();
				} else if (position == size) {
					deleteFromTheEnd();
				} else {
					int count = 1;
					tempNode = head;
					while (count < position) {
						tempNode = tempNode.getNext();
						count++;
					}
					tempNode.getNext().setPre(tempNode.getPre());
					tempNode.getPre().setNext(tempNode.getNext());
					tempNode = null;
				}
			}
		}
	}

	public void reverse() {
		Node currNode = head, nextNode = null;
		while (currNode != null) {
			nextNode = currNode.getNext();
			currNode.setNext(currNode.getPre());
			currNode.setPre(nextNode);
			currNode = nextNode;
		}
		currNode = head;
		head = tail;
		tail = currNode;
	}

	public int getSize() {
		tempNode = head;
		int lenthOfLinked = 0;
		while (tempNode != null) {
			tempNode = tempNode.getNext();
			lenthOfLinked++;
		}
		return lenthOfLinked;
	}

	private Node createNewNode() {
		return new Node(inputData(), null, null);
	}

	private int inputData() {
		System.out.println("Please enter data:");
		return myScanner.nextInt();
	}

	public boolean isObjectInteger(String number) {
		try {
			Integer.parseInt(number);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
