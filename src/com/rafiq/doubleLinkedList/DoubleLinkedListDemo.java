package com.rafiq.doubleLinkedList;

import java.util.InputMismatchException;

public class DoubleLinkedListDemo {
	static DoubleLinkedListUtility doubleLinkedListUtility = new DoubleLinkedListUtility();

	public static void main(String[] args) {
		linkedListAdapter();
	}
	
	

	private static void linkedListAdapter() {
		System.out.println("Please choice the optin you want to perform the operation on linked list.");
		System.out.println("1:create\n" + "2:Display\n" + "3:Insert at the beginning\n" + "4:Insert at the End\n"
				+ "5:Insert at the given position\n" + "6:Insert after the given position\n"
				+ "7:Delete from beginning\n" + "8:Delete from end\n" + "9:Delete from given position\n"
				+ "10:Reverse\n" + "0:Terminate the program\n");
		String input = doubleLinkedListUtility.myScanner.nextLine();
		while (!doubleLinkedListUtility.isObjectInteger(input)) {
			System.err.println("Please enter an integer value:");
			input=doubleLinkedListUtility.myScanner.nextLine();
		}
		
		switch (Integer.parseInt(input)) {
		case 1:
			doubleLinkedListUtility.create();
			linkedListAdapter();
			break;
		case 2:
			doubleLinkedListUtility.display();
			linkedListAdapter();
			break;
		case 3:
			doubleLinkedListUtility.insertAtbeginning();
			linkedListAdapter();
			break;
		case 4:
			doubleLinkedListUtility.insertAtEnd();
			linkedListAdapter();
			break;
		case 5:
			doubleLinkedListUtility.insertAtGivenPosition();
			linkedListAdapter();
			break;
		case 6:
			doubleLinkedListUtility.insertAfterGivenPosition();
			linkedListAdapter();
			break;
		case 7:
			doubleLinkedListUtility.deleteFromTheBeginning();
			linkedListAdapter();
			break;
		case 8:
			doubleLinkedListUtility.deleteFromTheEnd();
			linkedListAdapter();
			break;
		case 9:
			doubleLinkedListUtility.deleteFromGivenPosition();
			linkedListAdapter();
			break;
		case 10:
			doubleLinkedListUtility.reverse();
			linkedListAdapter();
			break;	
		case 0:
			System.err.println("Your program has been terminated");
			System.exit(0);
			break;
		default:
			System.err.println("Invalid choice please enter a valid input");
			linkedListAdapter();
			break;
		}
	}
}
