package SinglyLinkedListTask;

import java.util.Scanner;

public class SinglyLinkedList {

	Node head;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SinglyLinkedList list = new SinglyLinkedList();
		int noOfNodes = sc.nextInt();
		if(noOfNodes == 0) {
			System.out.println("Please enter atleast one node");
		}
		
		while (noOfNodes != 0) {
			
			int input = sc.nextInt();
			list.insertNodes(list, input);
			noOfNodes--;

		}
		int position = sc.nextInt();
//		if(position > noOfNodes) {
//			System.out.println("Enter valid position to delete a node");
//		}

		printList(list);
		deleteAtPosition(list, position);
		printList(list);
	}

	public static SinglyLinkedList insertNodes(SinglyLinkedList list, int data) {

		Node newNode = new Node(data);
		if (list.head == null) {
			list.head = newNode;
		} else {
			Node current = list.head;
			while (current.next != null) {  //10->20->30->40->50
				current = current.next;
			}
			current.next = newNode;
		}

		return list;
	}

	public static void printList(SinglyLinkedList list) {
		Node current = list.head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static SinglyLinkedList deleteAtPosition(SinglyLinkedList list, int position) {
		if (position == 1) {
			list.head = list.head.next;
		} else {
			Node previous = list.head; // 10 ->20 ->30 ->40 ->50
			int count = 1;
			while (count < position - 1) { //1<3 2<3 
				previous = previous.next;
				count++;
			}
			Node current = previous.next;
			previous.next = current.next;
		}

		return list;
	}

}